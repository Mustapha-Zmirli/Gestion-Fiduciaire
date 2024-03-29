package fst.sir.gestionfiduciaire.dao.demande;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeDao extends JpaRepository<Demande,Long> {
    Demande findByCode(String code);
    int deleteByCode(String code);
    List<Demande> findAll();
}
