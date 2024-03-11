package fst.sir.gestionfiduciaire.ws.facade.demande;

import fst.sir.gestionfiduciaire.bean.demande.DemandePieceJoint;
import fst.sir.gestionfiduciaire.service.impl.demande.DemandePieceJointImpl;
import fst.sir.gestionfiduciaire.ws.converter.demande.DemandePieceJointConverter;
import fst.sir.gestionfiduciaire.ws.dto.demande.DemandePieceJointDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/DeamandePieceJoint")
public class DemandePieceJointProvided{
    @Autowired
    DemandePieceJointImpl pieceJointService;
    @Autowired
    DemandePieceJointConverter converter;
    @GetMapping("/code/{code}")
    public DemandePieceJointDto findByCode(@PathVariable String code) {
        DemandePieceJoint bean = pieceJointService.findByCode(code);
        DemandePieceJointDto dto = converter.toDto(bean);
        return dto;
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(String code) {
        return pieceJointService.deleteByCode(code);
    }
    @PostMapping("")
    public int save( @RequestBody DemandePieceJoint demandePieceJoint) {
        return pieceJointService.save(demandePieceJoint);
    }
}