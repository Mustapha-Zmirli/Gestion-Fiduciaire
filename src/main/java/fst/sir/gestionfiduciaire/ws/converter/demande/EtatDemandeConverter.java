package fst.sir.gestionfiduciaire.ws.converter.demande;

import fst.sir.gestionfiduciaire.bean.demande.EtatDemande;
import fst.sir.gestionfiduciaire.ws.dto.demande.EtatDemandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EtatDemandeConverter {
    public EtatDemande toBean(EtatDemandeDto dto){
        EtatDemande bean = new EtatDemande();
        BeanUtils.copyProperties(dto,bean);
        return bean;
    }
    public List<EtatDemande> toBean(List<EtatDemandeDto> dtos){
        return dtos.stream().map(this::toBean).toList();
    }
    public EtatDemandeDto toDto(EtatDemande bean){
        EtatDemandeDto dto = new EtatDemandeDto();
        BeanUtils.copyProperties(bean,dto);
        return dto;
    }
    public List<EtatDemandeDto> toDto(List<EtatDemande> beans){
        return beans.stream().map(this::toDto).toList();
    }
}
