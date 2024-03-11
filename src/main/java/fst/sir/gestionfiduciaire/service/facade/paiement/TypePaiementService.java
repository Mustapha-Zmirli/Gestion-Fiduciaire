package fst.sir.gestionfiduciaire.service.facade.paiement;

import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;

public interface TypePaiementService {
    TypePaiement findByCode(String code);


    int deleteByCode(String code);

    int  save(TypePaiement typePaiement);


}