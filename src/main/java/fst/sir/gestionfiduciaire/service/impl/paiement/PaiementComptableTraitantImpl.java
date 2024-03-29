package fst.sir.gestionfiduciaire.service.impl.paiement;


import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import fst.sir.gestionfiduciaire.dao.paiement.PaiementComptableTraitantDao;
import fst.sir.gestionfiduciaire.service.facade.commun.ComptableService;
import fst.sir.gestionfiduciaire.service.facade.commun.SocieteService;
import fst.sir.gestionfiduciaire.service.facade.demande.DemandeService;
import fst.sir.gestionfiduciaire.service.facade.paiement.PaiementComptableTraitantService;
import fst.sir.gestionfiduciaire.service.facade.paiement.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@Service
public class PaiementComptableTraitantImpl implements PaiementComptableTraitantService {
    private @Autowired PaiementComptableTraitantDao dao;
    private @Autowired SocieteService societeService;
    private @Autowired DemandeService demandeService;
    private @Autowired ComptableService comptableService;
    private @Autowired TypePaiementService typePaiementService;

    @PersistenceContext
    private EntityManager entityManager;
    // Méthode pour générer un rapport sur les paiements effectués sur une période donnée
    @Override
    public List<Map<String, Object>> genererRapportPaiements(Date dateDebut, Date dateFin) {
        Query query = entityManager.createQuery("SELECT pd FROM PaiementDemande pd WHERE pd.datePaiement BETWEEN :dateDebut AND :dateFin");
        query.setParameter("dateDebut", dateDebut);
        query.setParameter("dateFin", dateFin);
        List<PaiementDemande> paiementsDemande = query.getResultList();

        List<Map<String, Object>> rapport = new ArrayList<>();
        for (PaiementDemande paiementDemande : paiementsDemande) {
            Map<String, Object> rapportPaiement = new HashMap<>();
            rapportPaiement.put("ID", paiementDemande.getId());
            rapportPaiement.put("Code", paiementDemande.getCode());
            /*
            rapportPaiement.put("Societe", paiementDemande.getSociete().getNom()); // Supposons que Societe a un attribut nom
            rapportPaiement.put("ComptableTraitant", paiementDemande.getComptableTraitant().getNom()); // Supposons que Comptable a un attribut nom
            // Ajoutez d'autres attributs si nécessaire*/
            rapportPaiement.put("Montant", paiementDemande.getMontant());
            rapportPaiement.put("TypePaiement", paiementDemande.getTypePaiement().getLibelle());
            rapportPaiement.put("DatePaiement", paiementDemande.getDatePaiement());
            rapportPaiement.put("Demande", paiementDemande.getDemande().getId());
            rapport.add(rapportPaiement);
        }
        return rapport;
    }

    // Méthode pour suivre l'état actuel d'un paiement spécifique
    @Override
    public String suivreEtatPaiement(Long idPaiement) {
        // Requête pour récupérer l'état du paiement
        Query query = entityManager.createQuery("SELECT pd.etat FROM PaiementDemande pd WHERE pd.id = :idPaiement", String.class);
        query.setParameter("idPaiement", idPaiement);
        try {
            // Récupérer l'état du paiement
            String etat = (String) query.getSingleResult();
            return "L'état du paiement avec l'ID " + idPaiement + " est : " + etat;
        } catch (jakarta.persistence.NoResultException e) {
            return "Aucun paiement trouvé avec l'ID " + idPaiement;
        }
    }
    @Override
    public int countPaiementsByComptable(Comptable comptable) {
        List<PaiementComptableTraitant> paiements = (List<PaiementComptableTraitant>) dao.findByComptableTraitantCin(comptable.getCin());
        return paiements.size(); // Retourne la taille de la liste des paiements
    }
    @Override
    public List<Comptable> getNombrePaiementsParComptable() {
        List<Comptable> comptables = comptableService.getAll(); // Récupérer tous les comptables
        for (Comptable comptable : comptables) {
            int nombrePaiements = countPaiementsByComptable(comptable);
            comptable.setNombrePaiementsTraites(nombrePaiements);
        }
        return comptables;
    }
    @Override
    public double getMontantTotalPaiements() {
        List<PaiementComptableTraitant> paiements = dao.findAll();
        double montantTotal = 0.0;
        for (PaiementComptableTraitant paiement : paiements) {
            montantTotal += paiement.getMontant();
        }
        return montantTotal;
    }
    @Override
    public List<PaiementComptableTraitant> findAll() {
        return dao.findAll();
    }

   /* @Override
    public double getMontantMoyenPaiements() {
        List<PaiementComptableTraitant> paiements = dao.findAll();
        if (paiements.isEmpty()) {
            return 0.0; // Retourner 0 si aucun paiement n'est trouvé
        }
        double total = 0.0;
        for (PaiementComptableTraitant paiement : paiements) {
            total += paiement.getMontant();
        }
        return total / paiements.size(); // Retourner la moyenne des montants des paiements
    }*/
   @Override
   public double getMontantMoyenPaiements() {
       List<PaiementComptableTraitant> paiements = dao.findAll();
       if (paiements.isEmpty()) {
           return 0.0; // Retourner 0 si aucun paiement n'est trouvé
       }
       double total = paiements.stream().mapToDouble(PaiementComptableTraitant::getMontant).sum();
       return total / paiements.size(); // Retourner la moyenne des montants des paiements
   }
    @Override
    public void affecterPaiementEnAttente(Comptable comptable, PaiementComptableTraitant paiement) {
        // Assurez-vous que le paiement est en attente
        if (paiement.isEnAttente()) {
            // Affectez le comptable au paiement
            paiement.setComptableTraitant(comptable);
            // Mettez à jour l'état du paiement en cours de traitement
            paiement.setEnAttente(false);
            // Enregistrez les modifications dans la base de données
            dao.save(paiement);
        } else {
            // Si le paiement n'est pas en attente, lancez une exception ou gérez-le selon vos besoins
            throw new IllegalStateException("Le paiement n'est pas en attente.");
        }
    }

    @Override
    public List<PaiementComptableTraitant> getPaiementsTraitesParComptableTraitant(Comptable comptable) {
        return dao.findByComptableTraitant(comptable);
    }
    @Override
    public int getNombrePaiementsTraites(Comptable comptable) {
        List<PaiementComptableTraitant> paiementsTraites = getPaiementsTraitesParComptableTraitant(comptable);
        return paiementsTraites.size();
}

    @Override
    public boolean estEnAttenteDeTraitement(PaiementComptableTraitant paiement) {
        return paiement.getComptableTraitant() == null;
    }
    @Override
    public PaiementComptableTraitant getPaiementParSociete(Societe societe) {
        String codeSociete = societe.getCode();
        return dao.findBySocieteCode(codeSociete);
    }




    @Override
    public PaiementComptableTraitant findByCode(String code){
        return dao.findByCode(code);
    }
    @Override
    public PaiementComptableTraitant findBySocieteCode(String code){
        return dao.findBySocieteCode(code);
    }
    @Override
    public PaiementComptableTraitant findByDemandeCode(String code){
        return dao.findByDemandeCode(code);
    }
    @Override
    public PaiementComptableTraitant findByComptableTraitantCin(String cin){
        return dao.findByComptableTraitantCin(cin);
    }
    @Override
    public PaiementComptableTraitant findByTypePaiementCode(String code){
        return dao.findByTypePaiementCode(code);
    }

    @Override
    public int save(PaiementComptableTraitant paiementComptableTraitant){
        String code = paiementComptableTraitant.getSociete().getCode();
        Societe societe=societeService.findByCode(code);
        paiementComptableTraitant.setSociete(societe);

        String code1 = paiementComptableTraitant.getDemande().getCode();
        Demande demande=demandeService.findByCode(code1);
        paiementComptableTraitant.setDemande(demande);

        String code2 = paiementComptableTraitant.getComptableTraitant().getCin();
        Comptable comptable=comptableService.findByCin(code2);
        paiementComptableTraitant.setComptableTraitant(comptable);

        String code3 = paiementComptableTraitant.getTypePaiement().getCode();
        TypePaiement typePaiement=typePaiementService.findByCode(code3);
        paiementComptableTraitant.setTypePaiement(typePaiement);

        if (findByCode(paiementComptableTraitant.getCode()) == null) {
            dao.save(paiementComptableTraitant);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int deleteByCode(String code){
        return dao.deleteByCode(code);
    }
    @Override
    public int deleteBySocieteCode(String code){
        return dao.deleteBySocieteCode(code);
    }
    @Override
    public int deleteByDemandeCode(String code){
        return dao.deleteByDemandeCode(code);
    }
    @Override
    public int deleteByComptableTraitantCin(String cin){
        return dao.deleteByComptableTraitantCin(cin);
    }
    @Override
    public int deleteByTypePaiementCode(String code){
        return dao.deleteByTypePaiementCode(code);
    }
}


