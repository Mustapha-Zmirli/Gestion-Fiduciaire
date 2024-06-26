package fst.sir.gestionfiduciaire.service.impl.paiement;

import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import fst.sir.gestionfiduciaire.dao.Demande.DemandeDao;
import fst.sir.gestionfiduciaire.dao.paiement.PaiementDao;
import fst.sir.gestionfiduciaire.service.facade.paiement.PaiementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {
    public PaiementServiceImpl(PaiementDao paiementDao, DemandeDao demandeDao) {
        this.paiementDao = paiementDao;
        this.demandeDao = demandeDao;
    }

    @Override
    public int save(PaiementDemande paiement) {
        Demande demande = demandeDao.findByCode(paiement.getDemande().getCode());
        paiement.setDemande(demande);
        if (demande == null) {
            return -1;
        } else if (findByCode(paiement.getCode()) != null) {
            return -2;
        } else {
            paiementDao.save(paiement);
            return 1;
        }
    }

    @Override
    public PaiementDemande findByCode(String code) {
        return paiementDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return paiementDao.deleteByCode(code);
    }

    public List<PaiementDemande> findAll() {
        return paiementDao.findAll();
    }

    @Override
    public List<PaiementDemande> findByDemandeCode(String code) {
        return paiementDao.findByDemandeCode(code);
    }

    @Override
    @Transactional
    public int deleteByDemandeCode(String code) {
        return paiementDao.deleteByDemandeCode(code);
    }

    @Override
    public List<PaiementDemande> findBySocieteCode(String code) {
        // Delegate the database query to the paiementDao
        return paiementDao.findBySocieteCode(code);
    }

    @Override
    public double getTotalPayeOfDemande(String code) {
        List<PaiementDemande> paiements = paiementDao.findByDemandeCode(code);
        double totalPaye=0;
        for (PaiementDemande paiement : paiements) {
            totalPaye += paiement.getMontant();
        }
        return totalPaye;
    }
    @Override
    @Transactional
    public int update(String code, PaiementDemande nouveauPaiement) {

        if (paiementDao.findByCode(code) == null) {
            return -1;
        }

        PaiementDemande paiement = paiementDao.findByCode(code);
        paiement.setMontant(nouveauPaiement.getMontant());
        paiement.setDatePaiement(nouveauPaiement.getDatePaiement());
        paiement.setTypePaiement(nouveauPaiement.getTypePaiement());
        paiement.setDemande(demandeDao.findByCode(nouveauPaiement.getDemande().getCode()));
        paiementDao.save(paiement);
        return 1;
    }
    @Override
    public List<PaiementDemande> getPaiementsBetweenDates(Date dateDebut, Date dateFin) {
        return paiementDao.getPaiementsBetweenDates(dateDebut, dateFin);
    }


    private final PaiementDao paiementDao;
    private final DemandeDao demandeDao;
}
