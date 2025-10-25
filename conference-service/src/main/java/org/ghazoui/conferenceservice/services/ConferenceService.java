package org.ghazoui.conferenceservice.services;

import org.ghazoui.conferenceservice.dtos.ConferenceDTO;


import java.util.List;

public interface ConferenceService {

    List<ConferenceDTO> getAllConferences();
    ConferenceDTO getConferenceById(Long id);
    ConferenceDTO createConference(ConferenceDTO ConferenceDTO);
    ConferenceDTO updateConference(ConferenceDTO ConferenceDTO);
    void deleteConference(Long id);
}
