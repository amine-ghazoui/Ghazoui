package org.ghazoui.conferenceservice.dtos;

import jakarta.persistence.*;
import lombok.*;
import org.ghazoui.conferenceservice.entities.Conference;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class ReviewDTO {

    private Long id;
    private Date date;
    private String text;
    private Integer note;
}
