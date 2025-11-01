package org.ghazoui.conferenceservice.services;

import org.ghazoui.conferenceservice.dtos.ConferenceDTO;
import org.ghazoui.conferenceservice.dtos.ReviewDTO;


import java.util.List;

public interface ConferenceService {

    List<ConferenceDTO> getAllConferences();
    ConferenceDTO getConferenceById(Long id);
    ConferenceDTO createConference(ConferenceDTO ConferenceDTO);
    ConferenceDTO updateConference(ConferenceDTO ConferenceDTO);
    void deleteConference(Long id);

    // *****************************************************************************************

//    List<ReviewDTO> getReviewsByConferenceId(Long conferenceId);
//    ReviewDTO getReviewById(Long id);
//    ReviewDTO createReview(Long conferenceId, ReviewDTO reviewDTO);
//    ReviewDTO updateReview(ReviewDTO reviewDTO);
//    void deleteReview(Long id);
}
