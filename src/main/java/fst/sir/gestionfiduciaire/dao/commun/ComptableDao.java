package fst.sir.gestionfiduciaire.dao.commun;



import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComptableDao extends JpaRepository<Comptable,Long> {

    Comptable findByCin(String cin);
    int deleteByCin(String cin);
    //List<Comptable> findByNomLike(String nom);
    // List<Comptable> findByPrenomLike(String prenom);
    Comptable save(Comptable comptable);

}

