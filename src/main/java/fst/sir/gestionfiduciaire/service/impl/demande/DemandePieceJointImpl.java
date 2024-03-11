package fst.sir.gestionfiduciaire.service.impl.demande;

import fst.sir.gestionfiduciaire.bean.demande.DemandePieceJoint;
import fst.sir.gestionfiduciaire.dao.demande.DemandePieceJointDao;
import fst.sir.gestionfiduciaire.service.facade.demande.DemandePieceJointService;
import fst.sir.gestionfiduciaire.service.facade.demande.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandePieceJointImpl implements DemandePieceJointService {
    @Autowired
    DemandePieceJointDao pieceJointDao;
    @Override
    public DemandePieceJoint findByCode(String code) {
        return pieceJointDao.findByCode(code);
    }
    @Override
    public int deleteByCode(String code) {
        return pieceJointDao.deleteByCode(code);
    }
}
