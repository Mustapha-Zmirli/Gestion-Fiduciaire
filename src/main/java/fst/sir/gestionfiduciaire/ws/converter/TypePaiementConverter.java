package fst.sir.gestionfiduciaire.ws.converter;

import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import fst.sir.gestionfiduciaire.ws.dto.TypePaiementDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypePaiementConverter {
    public TypePaiement toBean(TypePaiementDto dto){
        TypePaiement bean = new TypePaiement();
        BeanUtils.copyProperties(dto,bean);
        return bean;
    }
    public List<TypePaiement> toBean(List<TypePaiementDto> dtos){
        return dtos.stream().map(this::toBean).toList();
    }
    public TypePaiementDto toDto(TypePaiement bean){
        TypePaiementDto dto = new TypePaiementDto();
        BeanUtils.copyProperties(bean,dto);
        return dto;
    }
    public List<TypePaiementDto> toDto(List<TypePaiement> beans){
        return beans.stream().map(this::toDto).toList();
    }
}
