package fst.sir.gestionfiduciaire.ws.converter;


import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;
import fst.sir.gestionfiduciaire.ws.dto.PaiementComptableTraitantDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PaiementComptableTraitantConverter {
    public PaiementComptableTraitant toBean(PaiementComptableTraitantDto dto){
        PaiementComptableTraitant bean=new PaiementComptableTraitant();
        BeanUtils.copyProperties(dto,bean);
        return bean;
    }
    public PaiementComptableTraitantDto toDto(PaiementComptableTraitant bean){
        PaiementComptableTraitantDto dto=new PaiementComptableTraitantDto();
        BeanUtils.copyProperties(bean, dto);
        return dto;
    }

}

