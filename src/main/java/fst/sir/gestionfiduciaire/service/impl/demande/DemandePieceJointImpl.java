package fst.sir.gestionfiduciaire.service.impl.demande;

import fst.sir.gestionfiduciaire.bean.demande.DemandePieceJoint;
import fst.sir.gestionfiduciaire.dao.demande.DemandeDao;
import fst.sir.gestionfiduciaire.dao.demande.DemandePieceJointDao;
import fst.sir.gestionfiduciaire.service.facade.demande.DemandePieceJointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandePieceJointImpl implements DemandePieceJointService {
    @Autowired
    DemandePieceJointDao pieceJointDao;
    @Autowired
    DemandeDao demandeDao;

    @Override
    public DemandePieceJoint findByCode(String code) {
        return pieceJointDao.findByCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return pieceJointDao.deleteByCode(code);
    }
    @Override
    public int save(DemandePieceJoint demandePieceJoint) {
        String code = demandePieceJoint.getDemande().getCode();
        demandePieceJoint.setDemande(demandeDao.findByCode(code));
        if (findByCode(demandePieceJoint.getCode()) == null) {
            pieceJointDao.save(demandePieceJoint);
            return 1;
        } else {
            return -1;

        }
    }

    @Override
    public DemandePieceJoint findPieceJointByDemandeCode(String code) {
        return pieceJointDao.findPieceJointByDemandeCode(code);
    }
}
