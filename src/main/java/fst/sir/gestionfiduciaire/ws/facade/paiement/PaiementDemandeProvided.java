package fst.sir.gestionfiduciaire.ws.facade.paiement;

import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import fst.sir.gestionfiduciaire.service.impl.paiement.PaiementServiceImpl;
import fst.sir.gestionfiduciaire.ws.converter.paiement.PaiementDemandeConverter;
import fst.sir.gestionfiduciaire.ws.dto.paiement.PaiementDemandeDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
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
    @DeleteMapping("demande/code/{code}")
    public int deleteByDemandeCode(@PathVariable String code) {
        return paiementService.deleteByDemandeCode(code);
    }
    @GetMapping("")
    public List<PaiementDemandeDto> findAll() {
        List<PaiementDemande> beans = paiementService.findAll();
        return converter.toDto(beans);
    }
    @PostMapping("")
    public int save(@RequestBody PaiementDemandeDto dto) {
        PaiementDemande bean = converter.toBean(dto);
        return paiementService.save(bean);
    }
    @GetMapping("demande/code/{code}")
    public List<PaiementDemandeDto> findByDemandeCode(@PathVariable String code) {
        List<PaiementDemande> beans = paiementService.findByDemandeCode(code);
        return converter.toDto(beans);
    }
    @PutMapping("code/{code}")
    public int update(@PathVariable String code, @RequestBody PaiementDemandeDto paiementDto) {
        PaiementDemande bean = converter.toBean(paiementDto);
        return paiementService.update(code, bean);
    }
    @GetMapping("demande/code/{code}/totalPaye")
    public double getTotalPayeOfDemande(@PathVariable String code) {
        return paiementService.getTotalPayeOfDemande(code);
    }
    @GetMapping("societe/code/{code}")
    public List<PaiementDemandeDto> getPaiementsBySocieteCode(@PathVariable String code) {
        List<PaiementDemande> paiements = paiementService.findBySocieteCode(code);
        return converter.toDto(paiements);
    }
    @GetMapping("betweenDates")
    public List<PaiementDemande> getPaiementsBetweenDates(
            @RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        return paiementService.getPaiementsBetweenDates(dateDebut, dateFin);
    }
    private final PaiementServiceImpl paiementService;
    private final PaiementDemandeConverter converter;
}