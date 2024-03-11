package fst.sir.gestionfiduciaire.ws.converter.commun;


import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.ws.dto.commun.SocieteDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SocieteConverter {
    public Societe toBean(SocieteDto dto) {
        Societe bean = new Societe();
        bean.setId(dto.getId());
        bean.setCode(dto.getCode());
        return bean;
    }

    public List<Societe> toBean(List<SocieteDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public SocieteDto toDto(Societe bean) {
        SocieteDto dto = new SocieteDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        return dto;
    }

    public List<SocieteDto> toDto(List<Societe> beans) {
        return beans.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }
}
