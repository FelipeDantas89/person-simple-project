package br.com.felipedantas.person.person;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

  private final PersonService service;

  @PostMapping
  public ResponseEntity<PersonResponseDTO> create(@Valid @RequestBody PersonRequestDTO personDTO) {
    var personSaved = service.create(PersonMapper.toEntity(personDTO));
    var personResponse = PersonMapper.toResponse(personSaved);

    return ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
  }
}
