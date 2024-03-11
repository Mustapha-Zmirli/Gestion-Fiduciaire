package fst.sir.gestionfiduciaire.dao.commun;


import fst.sir.gestionfiduciaire.bean.commun.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteDao  extends JpaRepository<Societe,Long> {
    Societe findByCode(String code);
    int deleteByCode(String code);

}