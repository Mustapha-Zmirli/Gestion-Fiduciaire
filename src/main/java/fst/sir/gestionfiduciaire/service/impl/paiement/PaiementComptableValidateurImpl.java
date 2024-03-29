package fst.sir.gestionfiduciaire.service.impl.paiement;


import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableValidateur;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import fst.sir.gestionfiduciaire.dao.paiement.PaiementComptableValidateurDao;
import fst.sir.gestionfiduciaire.service.facade.commun.ComptableService;
import fst.sir.gestionfiduciaire.service.facade.commun.SocieteService;
import fst.sir.gestionfiduciaire.service.facade.demande.DemandeService;
import fst.sir.gestionfiduciaire.service.facade.paiement.PaiementComptableValidateurService;
import fst.sir.gestionfiduciaire.service.facade.paiement.TypePaiementService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PaiementComptableValidateurImpl implements PaiementComptableValidateurService {
    private @Autowired PaiementComptableValidateurDao dao;
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
            rapportPaiement.put("ComptableValidateur", paiementDemande.getComptableValidateur().getNom()); // Supposons que Comptable a un attribut nom
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
        List<PaiementComptableValidateur> paiements = (List<PaiementComptableValidateur>) dao.findByComptableValidateurCin(comptable.getCin());
        return paiements.size(); // Retourne la taille de la liste des paiements
    }
    @Override
    public List<Comptable> getNombrePaiementsParComptable() {
        List<Comptable> comptables = comptableService.getAll(); // Récupérer tous les comptables
        for (Comptable comptable : comptables) {
            int nombrePaiements = countPaiementsByComptable(comptable);
            comptable.setNombrePaiementsValidees(nombrePaiements);
        }
        return comptables;
    }
    @Override
    public double getMontantTotalPaiements() {
        List<PaiementComptableValidateur> paiements = dao.findAll();
        double montantTotal = 0.0;
        for (PaiementComptableValidateur paiement : paiements) {
            montantTotal += paiement.getMontant();
        }
        return montantTotal;
    }
    @Override
    public List<PaiementComptableValidateur> findAll() {
        return dao.findAll();
    }
    @Override
    public double getMontantMoyenPaiements() {
        List<PaiementComptableValidateur> paiements = dao.findAll();
        if (paiements.isEmpty()) {
            return 0.0; // Retourner 0 si aucun paiement n'est trouvé
        }
        double total = paiements.stream().mapToDouble(PaiementComptableValidateur::getMontant).sum();
        return total / paiements.size(); // Retourner la moyenne des montants des paiements
    }

    @Override
    public void affecterPaiementEnValidation(Comptable comptable, PaiementComptableValidateur paiement) {
        // Assurez-vous que le paiement est en attente de validation (par exemple, la variable d'état est true)
        if (paiement.isEnAttenteValidation()) {
            // Affectez le comptable validateur au paiement
            paiement.setComptableValidateur(comptable);
            // Mettez à jour la variable d'état pour indiquer que le paiement est en cours de validation
            paiement.setEnAttenteValidation(false);
            // Enregistrez les modifications dans la base de données
            dao.save(paiement);
        } else {
            // Si le paiement n'est pas en attente de validation, lancez une exception ou gérez-le selon vos besoins
            throw new IllegalStateException("Le paiement n'est pas en attente de validation.");
        }
    }
    @Override
    public void validerPaiement(Comptable comptable, PaiementComptableValidateur paiement) {
        // Assurez-vous que le paiement est en attente de validation
        if (paiement.isEnAttenteValidation()) {
            // Mettez à jour le statut du paiement comme validé
            paiement.setValide(true);
            // Mettez à jour le comptable valideur qui a validé le paiement
            paiement.setComptableValidateur(comptable);

            // Enregistrez les modifications dans la base de données
            dao.save(paiement);

            // Autres actions à effectuer après la validation du paiement, si nécessaire
        } else {
            // Si le paiement n'est pas en attente de validation, lancez une exception ou gérez-le selon vos besoins
            throw new IllegalStateException("Le paiement n'est pas en attente de validation.");
        }
    }

    @Override
    public void rejeterPaiement(Comptable comptable, PaiementComptableValidateur paiement, String raison) {
        // Assurez-vous que le paiement est en attente de validation
        if (paiement.isEnAttenteValidation()) {
            // Mettez à jour le statut du paiement comme rejeté
            paiement.setValide(false); // Le paiement est invalide car il est rejeté
            // Mettez à jour le comptable valideur qui a rejeté le paiement
            paiement.setComptableValidateur(comptable);
            // Ajoutez la raison du rejet
            paiement.setRaisonRejet(raison);
            // Mettez à jour d'autres informations du paiement si nécessaire

            // Enregistrez les modifications dans la base de données
            dao.save(paiement);

            // Autres actions à effectuer après le rejet du paiement, si nécessaire
        } else {
            // Si le paiement n'est pas en attente de validation, lancez une exception ou gérez-le selon vos besoins
            throw new IllegalStateException("Le paiement n'est pas en attente de validation.");
        }
    }

    @Override
    public void reaffecterPaiement(Comptable nouveauComptable, PaiementComptableValidateur paiement) {
        // Réaffecter le paiement au nouveau comptable
        paiement.setComptableValidateur(nouveauComptable);
        paiement.setValide(true); // Marquer le paiement comme valide (en attente de validation)
        paiement.setRaisonRejet(null); // Effacer la raison de rejet
        dao.save(paiement);
    }

    @Override
    public void genererRapportDelaisValidation(Date dateDebut, Date dateFin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<PaiementComptableValidateur> paiements = dao.findAll();

        System.out.println("=== Rapport des délais de validation ===");
        System.out.println("Période : " + sdf.format(dateDebut) + " - " + sdf.format(dateFin));
        System.out.println("----------------------------------------------------");
        System.out.println("ID Paiement | Date Limite | Délai de Validation (jours)");

        for (PaiementComptableValidateur paiement : paiements) {
            if (paiement.isEnAttenteValidation()) {
                // Calcul du délai de validation
                long delaiValidation = calculerDelaiValidation(paiement.getDateCreation(), paiement.getDateLimite());

                // Affichage des détails du paiement
                String dateLimite = sdf.format(paiement.getDateLimite());
                System.out.println(paiement.getId() + " | " + dateLimite + " | " + delaiValidation);
            }
        }
        System.out.println("----------------------------------------------------");
    }

    // Méthode pour calculer le délai de validation en jours
    private long calculerDelaiValidation(Date dateCreation, Date dateLimite) {
        long delaiMillisecondes = dateLimite.getTime() - dateCreation.getTime();
        return delaiMillisecondes / (1000 * 60 * 60 * 24); // Conversion de millisecondes en jours
    }

    @Override
    public List<PaiementComptableValidateur> getPaiementsRejetes() {
        return dao.findByValideFalse(); // Récupérer les paiements non valides (rejetés)
    }

    @Override
    public PaiementComptableValidateur findByCode(String code) {
        return dao.findByCode(code);
    }

    @Override
    public PaiementComptableValidateur findBySocieteCode(String code) {
        return dao.findBySocieteCode(code);
    }

    @Override
    public PaiementComptableValidateur findByDemandeCode(String code) {
        return dao.findByDemandeCode(code);
    }

    @Override
    public PaiementComptableValidateur findByComptableValidateurCin(String cin) {
        return dao.findByComptableValidateurCin(cin);
    }

    @Override
    public PaiementComptableValidateur findByTypePaiementCode(String code) {
        return dao.findByTypePaiementCode(code);
    }

    @Override
    public int save(PaiementComptableValidateur paiementComptableValidateur) {
        String code = paiementComptableValidateur.getSociete().getCode();
        Societe societe = societeService.findByCode(code);
        paiementComptableValidateur.setSociete(societe);

        String code1 = paiementComptableValidateur.getDemande().getCode();
        Demande demande = demandeService.findByCode(code1);
        paiementComptableValidateur.setDemande(demande);

        String code2 = paiementComptableValidateur.getComptableValidateur().getCin();
        Comptable comptable = comptableService.findByCin(code2);
        paiementComptableValidateur.setComptableValidateur(comptable);

        String code3 = paiementComptableValidateur.getTypePaiement().getCode();
        TypePaiement typePaiement = typePaiementService.findByCode(code3);
        paiementComptableValidateur.setTypePaiement(typePaiement);

        if (findByCode(paiementComptableValidateur.getCode()) == null) {
            dao.save(paiementComptableValidateur);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }

    @Override
    public int deleteBySocieteCode(String code) {
        return dao.deleteBySocieteCode(code);
    }

    @Override
    public int deleteByDemandeCode(String code) {
        return dao.deleteByDemandeCode(code);
    }

    @Override
    public int deleteByComptableValidateurCin(String cin) {
        return dao.deleteByComptableValidateurCin(cin);
    }

    @Override
    public int deleteByTypePaiementCode(String code) {
        return dao.deleteByTypePaiementCode(code);
    }
}

