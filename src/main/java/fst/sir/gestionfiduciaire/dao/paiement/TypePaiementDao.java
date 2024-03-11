package fst.sir.gestionfiduciaire.dao.paiement;

import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaiementDao extends JpaRepository<TypePaiement,Long> {
    TypePaiement findByCode(String code);
    int deleteByCode(String code);

}