package fst.sir.gestionfiduciaire.service.impl.paiement;

import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import fst.sir.gestionfiduciaire.dao.Demande.DemandeDao;
import fst.sir.gestionfiduciaire.dao.paiement.PaiementDao;
import fst.sir.gestionfiduciaire.service.facade.paiement.PaiementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {
    public PaiementServiceImpl(PaiementDao paiementDao, DemandeDao demandeDao) {
        this.paiementDao = paiementDao;
        this.demandeDao = demandeDao;
    }

    @Override
    public int save(PaiementDemande paiement) {
        Demande demande = demandeDao.findByCode(paiement.getDemande().getCode());
        paiement.setDemande(demande);
        if (demande == null) {
            return -1;
        } else if (findByCode(paiement.getCode()) != null) {
            return -2;
        } else {
            paiementDao.save(paiement);
            return 1;
        }
    }

    @Override
    public PaiementDemande findByCode(String code) {
        return paiementDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return paiementDao.deleteByCode(code);
    }

    public List<PaiementDemande> findAll() {
        return paiementDao.findAll();
    }

    @Override
    public List<PaiementDemande> findByDemandeCode(String code) {
        return paiementDao.findByDemandeCode(code);
    }

    @Override
    @Transactional
    public int deleteByDemandeCode(String code) {
        return paiementDao.deleteByDemandeCode(code);
    }


    private final PaiementDao paiementDao;
    private final DemandeDao demandeDao;
}
