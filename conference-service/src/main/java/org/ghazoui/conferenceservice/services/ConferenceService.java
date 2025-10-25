package org.ghazoui.conferenceservice.services;

import org.ghazoui.conferenceservice.dtos.ConferenceDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ConferenceService {

    List<ConferenceDTO> getAllConferences();
    ConferenceDTO getConferenceById(Long id);
    ConferenceDTO createConference(ConferenceDTO ConferenceDTO);
    ConferenceDTO updateConference(ConferenceDTO ConferenceDTO);
    void deleteConference(Long id);
}
