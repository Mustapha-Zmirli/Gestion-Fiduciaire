package fst.sir.gestionfiduciaire.ws.facade.paiement;

import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableValidateur;
import fst.sir.gestionfiduciaire.service.facade.paiement.PaiementComptableValidateurService;
import fst.sir.gestionfiduciaire.ws.converter.paiement.PaiementComptableValidateurConverter;
import fst.sir.gestionfiduciaire.ws.dto.paiement.PaiementComptableValidateurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/PaiementComptableValidateur/")
public class PaiementComptableValidateurWs {
    private @Autowired PaiementComptableValidateurService paiementComptableValidateurService;
    private @Autowired PaiementComptableValidateurConverter converter;
    @GetMapping("Societe/code/{code}")
    public PaiementComptableValidateur findBySocieteCode(@PathVariable String code) {
        return paiementComptableValidateurService.findBySocieteCode(code);
    }
    @GetMapping("Demande/code/{code}")
    public PaiementComptableValidateur findByDemandeCode(@PathVariable String code) {
        return paiementComptableValidateurService.findByDemandeCode(code);
    }
    @GetMapping("Comptable/cin/{cin}")
    public PaiementComptableValidateur findByComptableValidateurCin(@PathVariable String cin) {
        return paiementComptableValidateurService.findByComptableValidateurCin(cin);
    }
    @GetMapping("code/{code}")
    public PaiementComptableValidateurDto findByCode(@PathVariable String code) {
        PaiementComptableValidateur bean=paiementComptableValidateurService.findByCode(code);
        return converter.toDto(bean);
    }
    @GetMapping("TypePaiement/code/{code}")
    public PaiementComptableValidateur findByTypePaiementCode(@PathVariable String code) {
        return paiementComptableValidateurService.findByTypePaiementCode(code);
    }
    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return paiementComptableValidateurService.deleteByCode(code);
    }
    @DeleteMapping("Societe/code/{code}")
    public int deleteBySocieteCode(@PathVariable String code) {
        return paiementComptableValidateurService.deleteBySocieteCode(code);
    }
    @DeleteMapping("Demande/code/{code}")
    public int deleteByDemandeCode(@PathVariable String code) {
        return paiementComptableValidateurService.deleteByDemandeCode(code);
    }
    @DeleteMapping("Comptable/cin/{cin}")

    public int deleteByComptableValidateurCin(@PathVariable String cin) {
        return paiementComptableValidateurService.deleteByComptableValidateurCin(cin);
    }
    @DeleteMapping("TypePaiement/code/{code}")
    public int deleteByTypePaiementCode(@PathVariable String code) {
        return paiementComptableValidateurService.deleteByTypePaiementCode(code);
    }
    @PostMapping("")
    public int save(@RequestBody PaiementComptableValidateurDto dto) {
        PaiementComptableValidateur bean= converter.toBean(dto);
        return paiementComptableValidateurService.save(bean);
    }
    @GetMapping("")
    public List<PaiementComptableValidateurDto> findAll() {
        List<PaiementComptableValidateur> beans = paiementComptableValidateurService.findAll();
        return converter.toDto(beans);
    }
}


