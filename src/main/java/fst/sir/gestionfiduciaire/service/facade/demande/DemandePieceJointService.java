package fst.sir.gestionfiduciaire.service.facade.demande;

import fst.sir.gestionfiduciaire.bean.demande.DemandePieceJoint;

public interface DemandePieceJointService {

    DemandePieceJoint findByCode(String code);

    int deleteByCode(String code);

    int save(DemandePieceJoint demandePieceJoint);
}
