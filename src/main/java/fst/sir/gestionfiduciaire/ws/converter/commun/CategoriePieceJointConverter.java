package fst.sir.gestionfiduciaire.ws.converter.commun;


import fst.sir.gestionfiduciaire.bean.commun.CategoriePieceJoint;
import fst.sir.gestionfiduciaire.ws.dto.commun.CategoriePieceJointDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class CategoriePieceJointConverter {


    public CategoriePieceJoint toBean(CategoriePieceJointDto dto) {
        CategoriePieceJoint bean = new CategoriePieceJoint();
        bean.setLibelle(dto.getLibelle());
        bean.setCode(dto.getCode());
        bean.setId(dto.getId());
        return bean;
    }

    public List<CategoriePieceJoint> toBean(List<CategoriePieceJointDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public CategoriePieceJointDto toDto(CategoriePieceJoint bean) {
        CategoriePieceJointDto dto = new CategoriePieceJointDto();
        dto.setLibelle(bean.getLibelle());
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        return dto;
    }

    public List<CategoriePieceJointDto> toDto(List<CategoriePieceJoint> beans) {
        return beans.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }
}
