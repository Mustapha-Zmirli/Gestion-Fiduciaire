package fst.sir.gestionfiduciaire.service.impl.commun;

import fst.sir.gestionfiduciaire.bean.commun.CategoriePieceJoint;
import fst.sir.gestionfiduciaire.dao.commun.CategoriePieceJointDao;
import fst.sir.gestionfiduciaire.service.facade.commun.CategoriePieceJointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class CategoriePieceJointServiceImpl implements CategoriePieceJointService {
    @Autowired
    private CategoriePieceJointDao categoriePieceJointeDao;

    @Override
    public CategoriePieceJoint findByCode(String code) {
        return categoriePieceJointeDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return categoriePieceJointeDao.deleteByCode(code);
    }


    @Override
    public int save(CategoriePieceJoint categoriePieceJointe) {
        CategoriePieceJoint existingCategorie = categoriePieceJointeDao.findByCode(categoriePieceJointe.getCode());
        if (existingCategorie != null) {
            existingCategorie.setCode(categoriePieceJointe.getCode());
            categoriePieceJointeDao.save(existingCategorie);
            return -1;
        } else {
            categoriePieceJointeDao.save(categoriePieceJointe);
            return 1;
        }
    }

}
