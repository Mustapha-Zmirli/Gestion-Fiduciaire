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
        bean.setIce(dto.getIce());
        bean.setTelephone(dto.getTelephone());
        bean.setEmail(dto.getEmail());
        bean.setRc(dto.getRc());
        bean.setNom(dto.getNom());
        return bean;
    }

    public List<Societe> toBean(List<SocieteDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public SocieteDto toDto(Societe bean) {
        SocieteDto dto = new SocieteDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        dto.setNom(bean.getNom());
        dto.setIce(bean.getIce());
        dto.setTelephone(bean.getTelephone());
        dto.setEmail(bean.getEmail());
        dto.setRc(bean.getRc());
        return dto;
    }

    public List<SocieteDto> toDto(List<Societe> beans) {
        return beans.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }


}
