package fst.sir.gestionfiduciaire.ws.converter.demande;

import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.ws.dto.demande.DemandeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DemandeConverter {
    public DemandeDto toDto(Demande bean){
        DemandeDto dto = new DemandeDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        dto.setLibelle(bean.getLibelle());
        dto.setDateDemande(bean.getDateDemande());
        dto.setDateExigibilite(bean.getDateExigibilite());
        dto.setEtatDemande(bean.getEtatDemande());
        dto.setTypeDemande(bean.getTypeDemande());
        dto.setComptableTraitant(bean.getComptableTraitant());
        dto.setComptableValidateur(bean.getComptableValidateur());
        dto.setSociete(bean.getSociete());
        return dto;
    }
    public List<DemandeDto> toDto(List<Demande> beans) {
        return beans.stream().map(e->toDto(e)).collect(Collectors.toList());
    }

    public Demande toBean(DemandeDto dto){
        Demande bean = new Demande();
        bean.setId(dto.getId());
        bean.setCode(dto.getCode());
        bean.setLibelle(dto.getLibelle());
        bean.setDateDemande(dto.getDateDemande());
        bean.setDateExigibilite(dto.getDateExigibilite());
        bean.setEtatDemande(dto.getEtatDemande());
        bean.setTypeDemande(dto.getTypeDemande());
        bean.setComptableTraitant(dto.getComptableTraitant());
        bean.setComptableValidateur(dto.getComptableValidateur());
        bean.setSociete(dto.getSociete());
        return bean;
    }
    public List<Demande> toBean(List<DemandeDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

}
