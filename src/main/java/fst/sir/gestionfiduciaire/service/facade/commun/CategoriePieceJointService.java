package fst.sir.gestionfiduciaire.service.facade.commun;


import fst.sir.gestionfiduciaire.bean.commun.CategoriePieceJoint;

public interface CategoriePieceJointService {
    CategoriePieceJoint findByCode(String code);

    int deleteByCode(String code);
    int save (CategoriePieceJoint categoriePieceJoint);
}