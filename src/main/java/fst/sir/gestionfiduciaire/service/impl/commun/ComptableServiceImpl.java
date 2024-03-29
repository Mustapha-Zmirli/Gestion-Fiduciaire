package fst.sir.gestionfiduciaire.service.impl.commun;


import fst.sir.gestionfiduciaire.bean.commun.CategorieComptable;
import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.dao.commun.CategorieComptableDao;
import fst.sir.gestionfiduciaire.dao.commun.ComptableDao;
import fst.sir.gestionfiduciaire.service.facade.commun.ComptableService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComptableServiceImpl implements ComptableService {

    @Autowired
    ComptableDao comptableDao;
    @Autowired
    CategorieComptableDao categorieComptableDao;
    @Override
    public Comptable findByCin(String cin) {
        return comptableDao.findByCin(cin);
    }
    @Override
    @Transactional
    public int deleteByCin(String cin) {
        return comptableDao.deleteByCin(cin);
    }


    //public List<Comptable> findByNomLike(String nom) {
    // return comptableDao.findByNomLike(nom);
    //}

    // public List<Comptable> findByPrenomLike(String prenom) {
    // return comptableDao.findByPrenomLike(prenom);
    //}


    @Override
    public Comptable save(Comptable comptable) {
        Comptable res=null;
        String code = comptable.getCategorieComptable().getCode();
        CategorieComptable categorieComptable1 = categorieComptableDao.findByCode(code);
        comptable.setCategorieComptable(categorieComptable1);
        if (findByCin(comptable.getCin())==null){
            res=comptableDao.save(comptable);
        }
        return res;
    }

    @Override
    public List<Comptable> getAll() {
        return comptableDao.findAll();
    }
}
