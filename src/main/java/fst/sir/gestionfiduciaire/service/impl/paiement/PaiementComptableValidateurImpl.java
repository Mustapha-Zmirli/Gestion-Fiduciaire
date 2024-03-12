package fst.sir.gestionfiduciaire.service.impl.paiement;


import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableValidateur;
import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import fst.sir.gestionfiduciaire.dao.paiement.PaiementComptableValidateurDao;
import fst.sir.gestionfiduciaire.service.facade.commun.ComptableService;
import fst.sir.gestionfiduciaire.service.facade.commun.SocieteService;
import fst.sir.gestionfiduciaire.service.facade.demande.DemandeService;
import fst.sir.gestionfiduciaire.service.facade.paiement.PaiementComptableValidateurService;
import fst.sir.gestionfiduciaire.service.facade.paiement.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementComptableValidateurImpl implements PaiementComptableValidateurService {
    private @Autowired PaiementComptableValidateurDao dao;
    private @Autowired SocieteService societeService;
    private @Autowired DemandeService demandeService;
    private @Autowired ComptableService comptableService;
    private @Autowired TypePaiementService typePaiementService;

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

