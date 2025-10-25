package org.ghazoui.conferenceservice.dtos;

import lombok.*;

import java.util.Date;

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
}
