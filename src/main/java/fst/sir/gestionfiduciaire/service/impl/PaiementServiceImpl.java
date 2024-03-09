package fst.sir.gestionfiduciaire.service.impl;

import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import fst.sir.gestionfiduciaire.dao.PaiementDao;
import fst.sir.gestionfiduciaire.service.facade.PaiementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {
    public PaiementServiceImpl(PaiementDao paiementDao) {
        this.paiementDao = paiementDao;
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
    public List<PaiementDemande> findByDemandeRef(String ref) {
        return paiementDao.findByDemandeRef(ref);
    }

    @Override
    @Transactional
    public int deleteByDemandeRef(String ref) {
        return paiementDao.deleteByDemandeRef(ref);
    }


    private final PaiementDao paiementDao;
}
