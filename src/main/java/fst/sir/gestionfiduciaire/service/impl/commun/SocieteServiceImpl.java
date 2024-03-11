package fst.sir.gestionfiduciaire.service.impl.commun;


import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.dao.commun.SocieteDao;
import fst.sir.gestionfiduciaire.service.facade.commun.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SocieteServiceImpl implements SocieteService {
    @Autowired
    private SocieteDao dao;

    @Override
    public Societe findByCode(String code) {
        return dao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }




    public int save(Societe s)
    {
        if (findByCode(s.getCode()) != null) {
            return -1;
        }else if (findByCode(s.getCode()) != null) {
            return -2;
        } else {
            dao.save(s);
            return 1;}
    }
}
