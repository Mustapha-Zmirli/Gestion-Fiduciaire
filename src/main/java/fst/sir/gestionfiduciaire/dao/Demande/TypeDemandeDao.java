package fst.sir.gestionfiduciaire.dao.Demande;

import fst.sir.gestionfiduciaire.bean.demande.TypeDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDemandeDao extends JpaRepository<TypeDemande, Long> {
    int deleteByCode(String code);

    TypeDemande findByCode(String code);
}
