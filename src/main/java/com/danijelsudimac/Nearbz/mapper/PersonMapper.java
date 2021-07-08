package com.danijelsudimac.Nearbz.mapper;

import com.danijelsudimac.Nearbz.dto.PersonDto;
import com.danijelsudimac.Nearbz.model.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {
    Person dtoToEntity(PersonDto dto);
    PersonDto entityToDto(Person person);
}
