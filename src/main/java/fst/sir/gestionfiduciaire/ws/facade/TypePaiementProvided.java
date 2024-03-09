package fst.sir.gestionfiduciaire.ws.facade;

import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import fst.sir.gestionfiduciaire.service.impl.TypePaiementServiceImpl;
import fst.sir.gestionfiduciaire.ws.converter.TypePaiementConverter;
import fst.sir.gestionfiduciaire.ws.dto.TypePaiementDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/typePaiement/")
public class TypePaiementProvided {
    private final TypePaiementConverter converter;
    public TypePaiementProvided(TypePaiementConverter converter, TypePaiementServiceImpl typePaiementService) {
        this.converter = converter;
        this.typePaiementService = typePaiementService;
    }

    @GetMapping("code/{code}")
    public TypePaiementDto findByCode(@PathVariable String code) {
        TypePaiement bean = typePaiementService.findByCode(code);
        return converter.toDto(bean);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typePaiementService.deleteByCode(code);
    }
    @PostMapping("")
    public int save(@RequestBody TypePaiementDto dto) {
        TypePaiement bean = converter.toBean(dto);
        return typePaiementService.save(bean);
    }

    private final TypePaiementServiceImpl typePaiementService;
}
