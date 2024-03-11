package fst.sir.gestionfiduciaire.dao.commun;


import fst.sir.gestionfiduciaire.bean.commun.CategoriePieceJoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriePieceJointDao extends JpaRepository<CategoriePieceJoint,Long> {
    CategoriePieceJoint findByCode(String code);
    int deleteByCode(String code);

}