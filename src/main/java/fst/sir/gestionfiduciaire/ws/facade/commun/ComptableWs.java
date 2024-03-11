package fst.sir.gestionfiduciaire.ws.facade.commun;


import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.service.impl.commun.ComptableServiceImpl;
import fst.sir.gestionfiduciaire.ws.converter.commun.ComptableConverter;
import fst.sir.gestionfiduciaire.ws.dto.commun.ComptableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Comptable")
public class ComptableWs {
    @Autowired
    ComptableServiceImpl comptableService;
    @Autowired
    ComptableConverter converter;

    @GetMapping("/cin/{cin}")
    public ComptableDto findByCin(@PathVariable String cin) {
        Comptable bean = comptableService.findByCin(cin);
        ComptableDto dto = converter.toDto(bean);
        return dto;
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return comptableService.deleteByCin(cin);
    }
    @PostMapping("/")
    public ComptableDto save(@RequestBody ComptableDto comptableDto) {
        Comptable comptable = converter.toBean(comptableDto);
        comptable = comptableService.save(comptable);
        return converter.toDto(comptable);
    }

}