package fst.sir.gestionfiduciaire.ws.converter.paiement;

import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import fst.sir.gestionfiduciaire.ws.dto.paiement.PaiementDemandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaiementDemandeConverter {
    public PaiementDemande toBean(PaiementDemandeDto dto){
        PaiementDemande bean = new PaiementDemande();
        BeanUtils.copyProperties(dto,bean);
        return bean;
    }
    public List<PaiementDemande> toBean(List<PaiementDemandeDto> dtos){
        return dtos.stream().map(this::toBean).toList();
    }
    public PaiementDemandeDto toDto(PaiementDemande bean){
        PaiementDemandeDto dto = new PaiementDemandeDto();
        BeanUtils.copyProperties(bean,dto);
        return dto;
    }
    public List<PaiementDemandeDto> toDto(List<PaiementDemande> beans){
        return beans.stream().map(this::toDto).toList();
    }
}
