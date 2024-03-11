package fst.sir.gestionfiduciaire.ws.converter.demande;

import fst.sir.gestionfiduciaire.bean.demande.TypeDemande;
import fst.sir.gestionfiduciaire.ws.dto.demande.TypeDemandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeDemandeConverter {
    public TypeDemande toBean(TypeDemandeDto dto){
        TypeDemande bean = new TypeDemande();
        BeanUtils.copyProperties(dto,bean);
        return bean;
    }
    public List<TypeDemande> toBean(List<TypeDemandeDto> dtos){
        return dtos.stream().map(this::toBean).toList();
    }
    public TypeDemandeDto toDto(TypeDemande bean){
        TypeDemandeDto dto = new TypeDemandeDto();
        BeanUtils.copyProperties(bean,dto);
        return dto;
    }
    public List<TypeDemandeDto> toDto(List<TypeDemande> beans){
        return beans.stream().map(this::toDto).toList();
    }

}

