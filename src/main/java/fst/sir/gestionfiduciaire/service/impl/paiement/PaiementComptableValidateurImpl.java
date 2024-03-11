package fst.sir.gestionfiduciaire.service.impl.paiement;


import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableValidateur;
import fst.sir.gestionfiduciaire.dao.paiement.PaiementComptableValidateurDao;
import fst.sir.gestionfiduciaire.service.facade.paiement.PaiementComptableValidateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementComptableValidateurImpl implements PaiementComptableValidateurService {
    private @Autowired PaiementComptableValidateurDao dao;
    private @Autowired PaiementComptableValidateurService paiementComptableValidateurService;
    @Override
    public PaiementComptableValidateur findByCode(String code){
        return dao.findByCode(code);
    }
    @Override
    public PaiementComptableValidateur findBySocieteCode(String code){
        return dao.findBySocieteCode(code);
    }
    @Override
    public PaiementComptableValidateur findByDemandeCode(String code){
        return dao.findByDemandeCode(code);
    }
    @Override
    public PaiementComptableValidateur findByComptableValidateurCin(String cin){
        return dao.findByComptableValidateurCin(cin);
    }
    @Override
    public PaiementComptableValidateur findByTypePaiementCode(String code){
        return dao.findByTypePaiementCode(code);
    }

    @Override
    public PaiementComptableValidateur save(PaiementComptableValidateur paiementComptableValidateur) {
        return dao.save(paiementComptableValidateur);
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
    public int deleteByComptableValidateurCin(String cin) {
        return dao.deleteByComptableValidateurCin(cin);
    }
    @Override
    public int deleteByTypePaiementCode(String code) {
        return dao.deleteByTypePaiementCode(code);
    }
}

