package fst.sir.gestionfiduciaire.dao.Demande;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeDao extends JpaRepository<Demande,Long> {
    Demande findByCode(String code);
    int deleteByCode(String code);
}
