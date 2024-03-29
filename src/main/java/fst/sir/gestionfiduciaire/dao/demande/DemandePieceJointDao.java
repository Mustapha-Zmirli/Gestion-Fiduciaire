package fst.sir.gestionfiduciaire.dao.demande;
import fst.sir.gestionfiduciaire.bean.demande.DemandePieceJoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandePieceJointDao extends JpaRepository<DemandePieceJoint,Long> {
    DemandePieceJoint findByCode(String code);
    int deleteByCode(String code);
    DemandePieceJoint findPieceJointByDemandeCode(String code);
}
