package br.com.felipedantas.person.person;

public class PersonMapper {

  public static Person toEntity(PersonRequestDTO request) {
    return Person.builder()
        .name(request.getName())
        .identifier(request.getIdentifier())
        .build();
  }

  public static PersonResponseDTO toResponse(Person person) {
    return PersonResponseDTO.builder()
        .id(person.getId())
        .name(person.getName())
        .identifier(person.getIdentifier())
        .identifierType(person.getIdentifierType())
        .build();
  }
}
