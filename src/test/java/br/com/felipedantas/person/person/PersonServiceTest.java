package br.com.felipedantas.person.person;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonServiceTest {

  private PersonService service;
  private PersonRepository repository;

  @BeforeEach
  void setUp() {
    repository = mock(PersonRepository.class);
    service = new PersonService(repository);
  }

  @Test
  void shouldCreateWithCpf() {
    var person = buildPersonWithCpf();

    when(service.create(person)).thenReturn(person);

    var savedPerson = service.create(person);

    assertEquals(person.getName(), savedPerson.getName());
    assertEquals(person.getIdentifier(), savedPerson.getIdentifier());
    assertEquals(IdentifierTypeEnum.CPF, savedPerson.getIdentifierType());
  }

  @Test
  void shouldCreateWithCnpj() {
    var person = buildPersonWithCnpj();

    when(service.create(person)).thenReturn(person);

    var savedPerson = service.create(person);

    assertEquals(person.getName(), savedPerson.getName());
    assertEquals(person.getIdentifier(), savedPerson.getIdentifier());
    assertEquals(IdentifierTypeEnum.CNPJ, savedPerson.getIdentifierType());
  }

  private Person buildPersonWithCpf() {
    return Person.builder()
        .name("name")
        .identifier("12345678901")
        .build();
  }

  private Person buildPersonWithCnpj() {
    return Person.builder()
        .name("name")
        .identifier("12345678901234")
        .build();
  }
}