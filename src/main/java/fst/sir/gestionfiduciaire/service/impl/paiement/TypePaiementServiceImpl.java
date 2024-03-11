package fst.sir.gestionfiduciaire.service.impl.paiement;

import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import fst.sir.gestionfiduciaire.dao.paiement.TypePaiementDao;
import fst.sir.gestionfiduciaire.service.facade.paiement.TypePaiementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypePaiementServiceImpl implements TypePaiementService {


    public TypePaiementServiceImpl(TypePaiementDao typePaiementDao) {
        this.typePaiementDao = typePaiementDao;
    }

    @Override
    public TypePaiement findByCode(String code) {
        return typePaiementDao.findByCode(code);
    }
    @Transactional
    @Override
    public int deleteByCode(String code) {
        return typePaiementDao.deleteByCode(code);
    }

    @Override
    public int save(TypePaiement typePaiement) {
        if (findByCode(typePaiement.getCode()) == null) {
            return -1;
        } else {
            typePaiementDao.save(typePaiement);
        }
        return 1;
    }

    private final TypePaiementDao typePaiementDao;


}