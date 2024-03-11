package fst.sir.gestionfiduciaire.service.impl.paiement;


import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;
import fst.sir.gestionfiduciaire.dao.paiement.PaiementComptableTraitantDao;
import fst.sir.gestionfiduciaire.service.facade.paiement.PaiementComptableTraitantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementComptableTraitantImpl implements PaiementComptableTraitantService {
    private @Autowired PaiementComptableTraitantDao dao;
    private @Autowired PaiementComptableTraitantService paiementComptableTraitantService;
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
    public PaiementComptableTraitant save(PaiementComptableTraitant paiementComptableTraitant){
        return dao.save(paiementComptableTraitant);
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


