package org.ghazoui.keynoteservice.dtos;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class KeynoteDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}
