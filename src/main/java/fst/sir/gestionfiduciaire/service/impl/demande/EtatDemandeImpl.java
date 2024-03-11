package fst.sir.gestionfiduciaire.service.impl.demande;


import fst.sir.gestionfiduciaire.bean.demande.EtatDemande;
import fst.sir.gestionfiduciaire.dao.Demande.EtatDemandeDao;
import fst.sir.gestionfiduciaire.service.facade.demande.EtatDemandeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtatDemandeImpl implements EtatDemandeService {
    private @Autowired EtatDemandeDao dao;

    @Override
    public int save(EtatDemande etatDemande) {
        if (findByCode(etatDemande.getCode()) == null) {
            return -1;
        } else
            dao.save(etatDemande);
        return 1;
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }

    @Override
    public EtatDemande findByCode(String code) {
        return dao.findByCode(code);
    }
}