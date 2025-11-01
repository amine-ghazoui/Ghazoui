package org.ghazoui.conferenceservice.dtos;

import lombok.*;
import org.ghazoui.conferenceservice.entities.Review;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class ConferenceDTO {

    private Long id;
    private String titre;
    private String typeConference;
    private Date date;
    private Integer duree;
    private Integer nombreInscrits;
    private Double score;
    List<Review> reviews = new ArrayList<>();
}
