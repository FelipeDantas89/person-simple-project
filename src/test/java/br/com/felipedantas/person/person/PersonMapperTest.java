package br.com.felipedantas.person.person;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class PersonMapperTest {

  @Test
  void shouldMapRequestToEntity() {
    var request = buildRequest();
    var entity = PersonMapper.toEntity(request);

    assertEquals(request.getName(), entity.getName());
    assertEquals(request.getIdentifier(), entity.getIdentifier());
  }

  @Test
  void shouldMapEntityToResponse() {
    var entity = buildEntity();
    var response = PersonMapper.toResponse(entity);

    assertEquals(entity.getId(), response.getId());
    assertEquals(entity.getName(), response.getName());
    assertEquals(entity.getIdentifier(), response.getIdentifier());
    assertEquals(entity.getIdentifierType(), response.getIdentifierType());
  }

  private Person buildEntity() {
    return Person.builder()
        .id(UUID.randomUUID())
        .name("name")
        .identifier("12345678901")
        .identifierType(IdentifierTypeEnum.CPF)
        .build();
  }

  private PersonRequestDTO buildRequest() {
    return PersonRequestDTO.builder()
        .name("name")
        .identifier("12345678901")
        .build();
  }
}