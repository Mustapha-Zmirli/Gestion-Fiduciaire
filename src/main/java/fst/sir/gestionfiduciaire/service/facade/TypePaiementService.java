package fst.sir.gestionfiduciaire.service.facade;

import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;

public interface TypePaiementService {
    TypePaiement findByCode(String code);


    int deleteByCode(String code);

    int  save(TypePaiement typePaiement);


}