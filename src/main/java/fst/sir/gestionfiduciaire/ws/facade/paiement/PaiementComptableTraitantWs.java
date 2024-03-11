package fst.sir.gestionfiduciaire.ws.facade.paiement;

import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;
import fst.sir.gestionfiduciaire.service.facade.paiement.PaiementComptableTraitantService;
import fst.sir.gestionfiduciaire.ws.converter.paiement.PaiementComptableTraitantConverter;
import fst.sir.gestionfiduciaire.ws.dto.paiement.PaiementComptableTraitantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/PaiementComptableTraitant/")
public class PaiementComptableTraitantWs {
    private @Autowired PaiementComptableTraitantService paiementComptableTraitantService;
    private @Autowired PaiementComptableTraitantConverter converter;
    @GetMapping("code/{code}")
    public PaiementComptableTraitantDto findByCode(@PathVariable String code) {
        PaiementComptableTraitant bean=paiementComptableTraitantService.findByCode(code);
        return converter.toDto(bean);
    }
    @GetMapping("Societe/code/{code}")
    public PaiementComptableTraitant findBySocieteCode(@PathVariable String code) {
        return paiementComptableTraitantService.findBySocieteCode(code);
    }
    @GetMapping("Demande/code/{code}")
    public PaiementComptableTraitant findByDemandeCode(@PathVariable String code) {
        return paiementComptableTraitantService.findByDemandeCode(code);
    }
    @GetMapping("Comptable/cin/{cin}")
    public PaiementComptableTraitant findByComptableTraitantCin(@PathVariable String cin) {
        return paiementComptableTraitantService.findByComptableTraitantCin(cin);
    }
    @GetMapping("TypePaiement/code/{code}")
    public PaiementComptableTraitant findByTypePaiementCode(@PathVariable String code) {
        return paiementComptableTraitantService.findByTypePaiementCode(code);
    }
    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return paiementComptableTraitantService.deleteByCode(code);
    }
    @PostMapping("")
    public PaiementComptableTraitant save(@RequestBody PaiementComptableTraitantDto dto) {
        PaiementComptableTraitant bean=converter.toBean(dto);
        return paiementComptableTraitantService.save(bean);
    }
    @DeleteMapping("Societe/code/{code}")
    public int deleteBySocieteCode(@PathVariable String code) {
        return paiementComptableTraitantService.deleteBySocieteCode(code);
    }
    @DeleteMapping("Demande/code/{code}")
    public int deleteByDemandeCode(@PathVariable String code) {
        return paiementComptableTraitantService.deleteByDemandeCode(code);
    }
    @DeleteMapping("Comptable/cin/{cin}")
    public int deleteByComptableTraitantCin(@PathVariable String cin) {
        return paiementComptableTraitantService.deleteByComptableTraitantCin(cin);
    }
    @DeleteMapping("TypePaiement/code/{code}")
    public int deleteByTypePaiementCode(@PathVariable String code) {
        return paiementComptableTraitantService.deleteByTypePaiementCode(code);
    }
}

