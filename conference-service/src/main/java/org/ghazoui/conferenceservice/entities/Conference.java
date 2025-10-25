package org.ghazoui.conferenceservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Conference {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private TypeConference typeConference;
    private Date date;
    private Integer duree;
    private Integer nombreInscrits;
    private Double score;
}
