package tn.esprit.autoloc.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
    @NotBlank(message = "le nom est obligatoir")
    String nom;
    @NotBlank
    String prenom;
    String email;
    String telephone;
}
