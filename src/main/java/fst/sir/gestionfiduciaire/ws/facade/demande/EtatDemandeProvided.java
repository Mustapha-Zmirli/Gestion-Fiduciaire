package fst.sir.gestionfiduciaire.ws.facade.demande;

import fst.sir.gestionfiduciaire.bean.demande.EtatDemande;
import fst.sir.gestionfiduciaire.service.facade.demande.EtatDemandeService;
import fst.sir.gestionfiduciaire.service.impl.demande.EtatDemandeImpl;
import fst.sir.gestionfiduciaire.ws.converter.demande.EtatDemandeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/EtatDemande/")
public class EtatDemandeProvided {

    private @Autowired EtatDemandeImpl etatDemande;
    private @Autowired EtatDemandeConverter converter;

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return etatDemande.deleteByCode(code);
    }
    @GetMapping("code/{code}")
    public EtatDemande findByCode(@PathVariable String code) {
        return etatDemande.findByCode(code);
    }
    @PostMapping("")
    public int save(@RequestBody EtatDemande etatDemande) {
        return this.etatDemande.save(etatDemande);
    }
}