package fst.sir.gestionfiduciaire.ws.converter.commun;


import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.ws.dto.commun.ComptableDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComptableConverter {

    public ComptableDto toDto(Comptable bean) {
        ComptableDto dto = new ComptableDto();
        dto.setId(bean.getId());
        dto.setCin(bean.getCin());
        dto.setNom(bean.getNom());
        dto.setPrenom(bean.getPrenom());
        dto.setEmail(bean.getEmail());
        dto.setCategorieComptableId(bean.getCategorieComptable());
        return dto;
    }

    public List<ComptableDto> toDto(List<Comptable> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Comptable toBean(ComptableDto dto) {
        Comptable bean = new Comptable();
        bean.setId(dto.getId());
        bean.setCin(dto.getCin());
        bean.setNom(dto.getNom());
        bean.setPrenom(dto.getPrenom());
        bean.setEmail(dto.getEmail());
        bean.setCategorieComptable(dto.getCategorieComptableId());
        return bean;
    }

    public List<Comptable> toBean(List<ComptableDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }
}
