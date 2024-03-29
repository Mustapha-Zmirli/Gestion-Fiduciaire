package fst.sir.gestionfiduciaire.ws.converter.paiement;


import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableValidateur;
import fst.sir.gestionfiduciaire.ws.dto.paiement.PaiementComptableTraitantDto;
import fst.sir.gestionfiduciaire.ws.dto.paiement.PaiementComptableValidateurDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaiementComptableValidateurConverter {
    public PaiementComptableValidateur toBean(PaiementComptableValidateurDto dto){
        PaiementComptableValidateur bean=new PaiementComptableValidateur();
        BeanUtils.copyProperties(dto,bean);
        return bean;
    }
    public List<PaiementComptableValidateur> toBean(List<PaiementComptableValidateurDto> dtos){
        return dtos.stream().map(this::toBean).toList();
    }
    public PaiementComptableValidateurDto toDto(PaiementComptableValidateur bean){
        PaiementComptableValidateurDto dto=new PaiementComptableValidateurDto();
        BeanUtils.copyProperties(bean, dto);
        return dto;
    }
    public List<PaiementComptableValidateurDto> toDto(List<PaiementComptableValidateur> beans){
        return beans.stream().map(this::toDto).toList();
    }

}


