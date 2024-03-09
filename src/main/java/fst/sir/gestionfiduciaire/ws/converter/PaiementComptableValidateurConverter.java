package fst.sir.gestionfiduciaire.ws.converter;


import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableValidateur;
import fst.sir.gestionfiduciaire.ws.dto.PaiementComptableValidateurDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PaiementComptableValidateurConverter {
    public PaiementComptableValidateur toBean(PaiementComptableValidateurDto dto){
        PaiementComptableValidateur bean=new PaiementComptableValidateur();
        BeanUtils.copyProperties(dto,bean);
        return bean;
    }
    public PaiementComptableValidateurDto toDto(PaiementComptableValidateur bean){
        PaiementComptableValidateurDto dto=new PaiementComptableValidateurDto();
        BeanUtils.copyProperties(bean, dto);
        return dto;
    }

}


