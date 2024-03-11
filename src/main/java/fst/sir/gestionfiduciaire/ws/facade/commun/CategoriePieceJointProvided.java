package fst.sir.gestionfiduciaire.ws.facade.commun;


import fst.sir.gestionfiduciaire.bean.commun.CategoriePieceJoint;
import fst.sir.gestionfiduciaire.service.facade.commun.CategoriePieceJointService;
import fst.sir.gestionfiduciaire.ws.converter.commun.CategoriePieceJointConverter;
import fst.sir.gestionfiduciaire.ws.dto.commun.CategoriePieceJointDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categoriePieceJoint")
public class CategoriePieceJointProvided {
    @Autowired
    private CategoriePieceJointService service;
    @Autowired
    private CategoriePieceJointConverter converter;
    @GetMapping("/code/{code}")
    public CategoriePieceJointDto findByCode(@PathVariable String code) {
        CategoriePieceJoint bean = service.findByCode(code);
        CategoriePieceJointDto dto = converter.toDto(bean);
        return dto;
    }
    @DeleteMapping("/code/{code}")

    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }
    @PostMapping("/")
    public int save(@RequestBody CategoriePieceJointDto dto) {
        CategoriePieceJoint bean = converter.toBean(dto);
        return service.save(bean);
    }
}
