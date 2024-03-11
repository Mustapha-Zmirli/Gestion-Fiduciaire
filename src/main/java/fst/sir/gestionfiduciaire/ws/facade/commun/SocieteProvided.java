package fst.sir.gestionfiduciaire.ws.facade.commun;


import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.service.facade.commun.SocieteService;
import fst.sir.gestionfiduciaire.ws.converter.commun.SocieteConverter;
import fst.sir.gestionfiduciaire.ws.dto.commun.SocieteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/societe")
public class SocieteProvided {

    @Autowired
    private SocieteService service;

    @Autowired
    private SocieteConverter converter;

    @GetMapping("/code/{code}")
    public SocieteDto findByCode(@PathVariable String code) {
        Societe bean = service.findByCode(code);
        SocieteDto dto = converter.toDto(bean);
        return dto;
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }
}
