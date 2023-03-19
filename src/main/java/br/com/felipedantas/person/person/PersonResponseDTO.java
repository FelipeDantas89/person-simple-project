package br.com.felipedantas.person.person;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDTO {

  private UUID id;
  private String name;
  private String identifier;
  private IdentifierTypeEnum identifierType;
}
