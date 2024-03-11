package fst.sir.gestionfiduciaire.service.impl.demande;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.dao.demande.DemandeDao;
import fst.sir.gestionfiduciaire.service.facade.demande.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeImpl implements DemandeService {
    @Autowired
    DemandeDao demandeDao;
    @Override
    public Demande findByCode(String code) {
        return demandeDao.findByCode(code);
    }
    @Override
    public int deleteByCode(String code) {
        return demandeDao.deleteByCode(code);
    }

}

