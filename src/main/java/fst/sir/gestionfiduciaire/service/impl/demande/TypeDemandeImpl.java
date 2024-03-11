package fst.sir.gestionfiduciaire.service.impl.demande;

import fst.sir.gestionfiduciaire.bean.demande.TypeDemande;
import fst.sir.gestionfiduciaire.dao.Demande.TypeDemandeDao;
import fst.sir.gestionfiduciaire.service.facade.demande.TypeDemandeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeDemandeImpl implements TypeDemandeService {
    @Autowired
    private  TypeDemandeDao dao;

    @Override
    public int save(TypeDemande typeDemande) {
        if (findByCode(typeDemande.getCode()) == null) {
            return -1;
        } else
            dao.save(typeDemande);
        return 1;
    }

    @Override
    public TypeDemande findByCode(String Code) {
        return dao.findByCode(Code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }
}
