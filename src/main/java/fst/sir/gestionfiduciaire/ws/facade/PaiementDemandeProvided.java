package fst.sir.gestionfiduciaire.ws.facade;

import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import fst.sir.gestionfiduciaire.service.impl.PaiementServiceImpl;
import fst.sir.gestionfiduciaire.ws.converter.PaiementDemandeConverter;
import fst.sir.gestionfiduciaire.ws.dto.PaiementDemandeDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/paiement/")
public class PaiementDemandeProvided {
    public PaiementDemandeProvided(PaiementServiceImpl paiementService, PaiementDemandeConverter converter) {
        this.paiementService = paiementService;
        this.converter = converter;
    }

    @GetMapping("code/{code}")
    public PaiementDemandeDto findByCode(@PathVariable String code) {
        PaiementDemande bean = paiementService.findByCode(code);
        return converter.toDto(bean);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return paiementService.deleteByCode(code);
    }
    @GetMapping("")
    public List<PaiementDemandeDto> findAll() {
        List<PaiementDemande> beans = paiementService.findAll();
        return converter.toDto(beans);
    }
    @GetMapping("demande/ref/{ref}")
    public List<PaiementDemandeDto> findByDemandeRef(@PathVariable String ref) {
        List<PaiementDemande> beans = paiementService.findByDemandeRef(ref);
        return converter.toDto(beans);
    }

    @DeleteMapping("demande/ref/{ref}")
    public int deleteByDemandeRef(@PathVariable String ref) {
        return paiementService.deleteByDemandeRef(ref);
    }
    private final PaiementServiceImpl paiementService;
    private final PaiementDemandeConverter converter;
}