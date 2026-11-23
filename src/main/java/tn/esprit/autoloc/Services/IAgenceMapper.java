package tn.esprit.autoloc.Services;

import org.mapstruct.Mapper;
import tn.esprit.autoloc.DTO.AgenceDto;
import tn.esprit.autoloc.Entities.Agence;

@Mapper(componentModel = "spring")

public interface IAgenceMapper {

        AgenceDto toDto(Agence agence);
        Agence toEntity(AgenceDto dto);

}
