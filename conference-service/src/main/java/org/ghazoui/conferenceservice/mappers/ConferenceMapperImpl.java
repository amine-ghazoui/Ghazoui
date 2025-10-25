package org.ghazoui.conferenceservice.mappers;

import org.ghazoui.conferenceservice.dtos.ConferenceDTO;
import org.ghazoui.conferenceservice.entities.Conference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ConferenceMapperImpl {

    public ConferenceDTO fromConference(Conference keynote) {
        ConferenceDTO keynoteDTO = new ConferenceDTO();
        BeanUtils.copyProperties(keynote, keynoteDTO);
        return keynoteDTO;
    }

    public Conference fromConferenceDTO(ConferenceDTO keynoteDTO) {
        Conference keynote = new Conference();
        BeanUtils.copyProperties(keynoteDTO, keynote);
        return keynote;
    }
}
