package fst.sir.gestionfiduciaire.ws.facade.demande;

import fst.sir.gestionfiduciaire.bean.demande.TypeDemande;
import fst.sir.gestionfiduciaire.service.facade.demande.TypeDemandeService;
import fst.sir.gestionfiduciaire.service.impl.demande.TypeDemandeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/TypeDemande")
public class TypeDemandeProvided {
    @Autowired
    private TypeDemandeImpl  typeDemande;

    @PostMapping("")
    public int save(@RequestBody TypeDemande typeDemande) {
        return this.typeDemande.save(typeDemande);
    }

    @GetMapping("code/{code}")
    public TypeDemande findByCode(@PathVariable String Code) {
        return typeDemande.findByCode(Code);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String Code) {
        return typeDemande.deleteByCode(Code);
    }
}