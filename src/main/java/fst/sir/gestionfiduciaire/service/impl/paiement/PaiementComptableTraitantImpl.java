package fst.sir.gestionfiduciaire.service.impl.paiement;


import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;
import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import fst.sir.gestionfiduciaire.dao.paiement.PaiementComptableTraitantDao;
import fst.sir.gestionfiduciaire.service.facade.commun.ComptableService;
import fst.sir.gestionfiduciaire.service.facade.commun.SocieteService;
import fst.sir.gestionfiduciaire.service.facade.demande.DemandeService;
import fst.sir.gestionfiduciaire.service.facade.paiement.PaiementComptableTraitantService;
import fst.sir.gestionfiduciaire.service.facade.paiement.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementComptableTraitantImpl implements PaiementComptableTraitantService {
    private @Autowired PaiementComptableTraitantDao dao;
    private @Autowired SocieteService societeService;
    private @Autowired DemandeService demandeService;
    private @Autowired ComptableService comptableService;
    private @Autowired TypePaiementService typePaiementService;
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


