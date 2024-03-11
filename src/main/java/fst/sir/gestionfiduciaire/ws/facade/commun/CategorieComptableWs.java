package fst.sir.gestionfiduciaire.ws.facade.commun;


import fst.sir.gestionfiduciaire.bean.commun.CategorieComptable;
import fst.sir.gestionfiduciaire.service.impl.commun.CategorieComptableServiceImpl;
import fst.sir.gestionfiduciaire.ws.converter.commun.CategorieComptableConverter;
import fst.sir.gestionfiduciaire.ws.dto.commun.CategorieComptableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/CategorieComptable")
public class CategorieComptableWs {
    @Autowired
    private CategorieComptableServiceImpl categorieComptableService;

    @Autowired

    CategorieComptableConverter converter;

    @GetMapping("/code/{code}")
    public CategorieComptableDto findByCode(@PathVariable String code) {
        CategorieComptable bean = categorieComptableService.findByCode(code);
        CategorieComptableDto dto = converter.toDto(bean);
        return dto;
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieComptableService.deleteByCode(code);
    }
    @PostMapping("/")
    public CategorieComptable save(@RequestBody CategorieComptableDto categorieComptableDto) {
        CategorieComptable bean=converter.toBean(categorieComptableDto);
        return categorieComptableService.save(bean);
    }
}

