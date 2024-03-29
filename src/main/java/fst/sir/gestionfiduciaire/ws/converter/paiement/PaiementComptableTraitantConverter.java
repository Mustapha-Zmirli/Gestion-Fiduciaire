package fst.sir.gestionfiduciaire.ws.converter.paiement;


import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;
import fst.sir.gestionfiduciaire.ws.dto.paiement.PaiementComptableTraitantDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaiementComptableTraitantConverter {
    public PaiementComptableTraitant toBean(PaiementComptableTraitantDto dto){
        PaiementComptableTraitant bean=new PaiementComptableTraitant();
        BeanUtils.copyProperties(dto,bean);
        return bean;
    }
    public List<PaiementComptableTraitant> toBean(List<PaiementComptableTraitantDto> dtos){
        return dtos.stream().map(this::toBean).toList();
    }
    public PaiementComptableTraitantDto toDto(PaiementComptableTraitant bean){
        PaiementComptableTraitantDto dto=new PaiementComptableTraitantDto();
        BeanUtils.copyProperties(bean, dto);
        return dto;
    }
    public List<PaiementComptableTraitantDto> toDto(List<PaiementComptableTraitant> beans){
        return beans.stream().map(this::toDto).toList();
    }
}

