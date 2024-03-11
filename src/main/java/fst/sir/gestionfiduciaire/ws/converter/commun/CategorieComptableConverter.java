package fst.sir.gestionfiduciaire.ws.converter.commun;


import fst.sir.gestionfiduciaire.bean.commun.CategorieComptable;
import fst.sir.gestionfiduciaire.ws.dto.commun.CategorieComptableDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorieComptableConverter {
    public CategorieComptableDto toDto(CategorieComptable bean){
        CategorieComptableDto dto = new CategorieComptableDto();
        dto.setId(bean.getId());
        dto.setLibelle(bean.getLibelle());
        dto.setCode(bean.getCode());
        return dto;
    }

    public List<CategorieComptableDto> toDto(List<CategorieComptable> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

    public CategorieComptable toBean(CategorieComptableDto dto){
        CategorieComptable bean = new CategorieComptable();
        bean.setId(dto.getId());
        bean.setLibelle(dto.getLibelle());
        bean.setCode(dto.getCode());
        return bean;
    }

    public List<CategorieComptable> toBean(List<CategorieComptableDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }
}