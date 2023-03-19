package br.com.felipedantas.person.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
  private final PersonRepository repository;

  public Person create(Person person) {
    setIdentifierTypeByIdentifierSize(person);
    return repository.save(person);
  }

  private void setIdentifierTypeByIdentifierSize(Person person) {
    person.setIdentifierType(person.getIdentifier().length() == 11
        ? IdentifierTypeEnum.CPF
        : IdentifierTypeEnum.CNPJ);
  }
}
