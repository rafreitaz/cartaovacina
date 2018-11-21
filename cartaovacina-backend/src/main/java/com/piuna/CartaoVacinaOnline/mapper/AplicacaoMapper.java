package com.piuna.CartaoVacinaOnline.mapper;

import com.piuna.CartaoVacinaOnline.domain.AplicacaoVacina;
import com.piuna.CartaoVacinaOnline.dto.AplicacaoVacinaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AplicacaoMapper extends EntityMapper<AplicacaoVacinaDTO, AplicacaoVacina>{

    @Override
    @Mappings({
            @Mapping(source = "usuario", target = "usuario.nome"),
            @Mapping(source = "vacina", target = "vacina.nome"),
            @Mapping(source = "clinica", target = "clinica.nome"),
    })
    AplicacaoVacina toEntity(AplicacaoVacinaDTO dto);

    @Override
    @Mappings({
            @Mapping(target = "usuario", source = "usuario.nome"),
            @Mapping(target = "vacina", source = "vacina.nome"),
            @Mapping(target = "clinica", source = "clinica.nome"),
    })
    AplicacaoVacinaDTO toDto(AplicacaoVacina entity);
}
