package fst.sir.gestionfiduciaire.ws.facade.demande;


import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.service.impl.demande.DemandeImpl;
import fst.sir.gestionfiduciaire.ws.converter.demande.DemandeConverter;
import fst.sir.gestionfiduciaire.ws.dto.demande.DemandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Deamande")
public class DemandeProvided {
    @Autowired
    DemandeImpl demande;
    @Autowired
    DemandeConverter converter;
    @GetMapping("/code/{code}")
    public DemandeDto findByCode(@PathVariable String code) {
        Demande bean = demande.findByCode(code);
        DemandeDto dto=converter.toDto(bean);
        return dto;
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return demande.deleteByCode(code);
    }
}
