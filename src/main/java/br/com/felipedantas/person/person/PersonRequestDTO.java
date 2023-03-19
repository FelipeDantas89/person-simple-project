package br.com.felipedantas.person.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class PersonRequestDTO {

  @NotBlank
  private String name;
  @NotBlank
  @Size(min = 11, max = 14)
  private String identifier;
}
