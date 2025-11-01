package org.ghazoui.conferenceservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class Keynote {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}
