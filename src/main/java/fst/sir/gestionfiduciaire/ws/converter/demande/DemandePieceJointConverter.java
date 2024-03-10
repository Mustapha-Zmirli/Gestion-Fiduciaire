package fst.sir.gestionfiduciaire.ws.converter.demande;

import fst.sir.gestionfiduciaire.bean.demande.DemandePieceJoint;
import fst.sir.gestionfiduciaire.ws.dto.demande.DemandePieceJointDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class DemandePieceJointConverter{
public DemandePieceJointDto toDto(DemandePieceJoint bean){
    DemandePieceJointDto dto = new DemandePieceJointDto();
    dto.setId(bean.getId());
    dto.setCode(bean.getCode());
    dto.setDemande(bean.getDemande());
    dto.setPath(bean.getPath());
    return dto;
}

public List<DemandePieceJointDto> toDto(List<DemandePieceJoint> beans) {
    return beans.stream().map(e->toDto(e)).collect(Collectors.toList());
}

public DemandePieceJoint toBean(DemandePieceJointDto dto){
    DemandePieceJoint bean = new DemandePieceJoint();
    bean.setId(dto.getId());
    bean.setCode(dto.getCode());

    bean.setDemande(dto.getDemande());
    bean.setPath(dto.getPath());
    return bean;
}
public List<DemandePieceJoint> toBean(List<DemandePieceJointDto> dtos) {
    return dtos.stream().map(this::toBean).collect(Collectors.toList());
}


}
