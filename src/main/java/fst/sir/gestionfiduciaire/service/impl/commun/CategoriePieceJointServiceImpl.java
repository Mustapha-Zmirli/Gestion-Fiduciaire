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
    private CategoriePieceJointDao dao;

    @Override
    public CategoriePieceJoint findByCode(String code) {
        return dao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }


    @Override
    public int save(CategoriePieceJoint categoriePieceJoint) {

        dao.save(categoriePieceJoint);
        return 1;
    }

}
