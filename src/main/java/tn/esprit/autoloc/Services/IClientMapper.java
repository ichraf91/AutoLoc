package tn.esprit.autoloc.Services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.DTO.ClientRequestDto;
import tn.esprit.autoloc.DTO.ClientResponseDto;
import tn.esprit.autoloc.Entities.Client;
@Mapper(componentModel ="spring")
public interface IClientMapper {

    ClientResponseDto toDto(Client client);
    Client toEntity(ClientRequestDto dto);

}
