package fst.sir.gestionfiduciaire.service.impl.commun;

import fst.sir.gestionfiduciaire.bean.commun.CategorieComptable;
import fst.sir.gestionfiduciaire.dao.commun.CategorieComptableDao;
import fst.sir.gestionfiduciaire.service.facade.commun.CategorieComptableService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieComptableServiceImpl implements CategorieComptableService {
    @Autowired
    private CategorieComptableDao categorieComptableDao;

    @Override
    public CategorieComptable findByCode(String code) {
        return categorieComptableDao.findByCode(code);
    }

   @Override
    @Transactional
    public int deleteByCode(String code) {
        return categorieComptableDao.deleteByCode(code);
    }

    //public List<CategorieComptable> findByLibelleLike(String libelle) {
    // return categorieComptableDao.findByLibelleLike(libelle);
    //}

    @Override
    public CategorieComptable save(CategorieComptable categorieComptable) {
        CategorieComptable res=null;
        if (findByCode(categorieComptable.getCode())==null){
            res=categorieComptableDao.save(categorieComptable);
        }
        return res;
    }
}
