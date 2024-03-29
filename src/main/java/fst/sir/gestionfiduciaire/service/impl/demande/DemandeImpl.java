package fst.sir.gestionfiduciaire.service.impl.demande;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.dao.commun.ComptableDao;
import fst.sir.gestionfiduciaire.dao.commun.SocieteDao;
import fst.sir.gestionfiduciaire.dao.Demande.DemandeDao;
import fst.sir.gestionfiduciaire.service.facade.demande.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeImpl implements DemandeService {
    @Autowired
    DemandeDao demandeDao;
    @Autowired
    SocieteDao societeDao;
    @Autowired
    fst.sir.gestionfiduciaire.dao.Demande.EtatDemandeDao etatDemandeDao;
    @Autowired
    fst.sir.gestionfiduciaire.dao.Demande.TypeDemandeDao typeDemandeDao;
    @Autowired
    ComptableDao comptableDao;

    @Override
    public Demande findByCode(String code) {
        return demandeDao.findByCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return demandeDao.deleteByCode(code);
    }
    @Override
    public int save(Demande demande) {
        String code1 = demande.getSociete().getCode();
        demande.setSociete(societeDao.findByCode(code1));
        String code2 = demande.getTypeDemande().getCode();
        demande.setTypeDemande(typeDemandeDao.findByCode(code2));
        String code3 = demande.getEtatDemande().getCode();
        demande.setEtatDemande(etatDemandeDao.findByCode(code3));
        String cin1 = demande.getComptableTraitant().getCin();
        demande.setComptableTraitant(comptableDao.findByCin(cin1));
        String cin2 = demande.getComptableValidateur().getCin();
        demande.setComptableValidateur(comptableDao.findByCin(cin2));
        if (findByCode(demande.getCode()) == null) {
            demandeDao.save(demande);
            return 1;
        } else {
            return -1;
        }
    }
}

