package fst.sir.gestionfiduciaire.dao.commun;

import fst.sir.gestionfiduciaire.bean.commun.CategorieComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieComptableDao extends JpaRepository<CategorieComptableDao,Long> {
    public CategorieComptable findByCode(String code);

    int deleteByCode(String code);

    // List <CategorieComptable> findByLibelleLike (String libelle) ;
    CategorieComptable save(CategorieComptable categorieComptable);
}