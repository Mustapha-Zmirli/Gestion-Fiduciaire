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



    @Override
    public int save(Societe societe) {
        Societe existingSociete = dao.findByCode(societe.getCode());
        if (existingSociete != null) {
            existingSociete.setNom(societe.getNom());
            existingSociete.setIce(societe.getIce());
            existingSociete.setRc(societe.getRc());
            existingSociete.setEmail(societe.getEmail());
            existingSociete.setTelephone(societe.getTelephone());
            dao.save(existingSociete);
            return -1;
        } else {
            dao.save(societe);
            return 1;
        }
    }
}


