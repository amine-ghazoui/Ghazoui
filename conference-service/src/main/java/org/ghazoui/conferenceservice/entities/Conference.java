package org.ghazoui.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.ghazoui.conferenceservice.model.Keynote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Long keynoteId;

    @OneToMany(mappedBy = "conference")
    List<Review> reviews = new ArrayList<>();

    @Transient
    Keynote keynote;
}
