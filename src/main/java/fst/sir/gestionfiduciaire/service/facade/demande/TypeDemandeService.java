package fst.sir.gestionfiduciaire.service.facade.demande;

import fst.sir.gestionfiduciaire.bean.demande.TypeDemande;
import jakarta.transaction.Transactional;

public interface TypeDemandeService {

    int save(TypeDemande typeDemande);

    TypeDemande findByCode(String Code);


    int deleteByCode(String code);
}
