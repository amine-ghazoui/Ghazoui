package org.ghazoui.conferenceservice.services;

import lombok.AllArgsConstructor;
import org.ghazoui.conferenceservice.dtos.ConferenceDTO;
import org.ghazoui.conferenceservice.entities.Conference;
import org.ghazoui.conferenceservice.mappers.ConferenceMapperImpl;
import org.ghazoui.conferenceservice.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private ConferenceMapperImpl conferenceMapper;

    // 👉 Constructeur ou @Autowired pour l’injection
    public ConferenceServiceImpl(ConferenceRepository conferenceRepository, ConferenceMapperImpl conferenceMapper) {
        this.conferenceRepository = conferenceRepository;
        this.conferenceMapper = conferenceMapper;
    }

    @Override
    public List<ConferenceDTO> getAllConferences() {
        List<Conference> conferences = conferenceRepository.findAll();
        List<ConferenceDTO> conferenceDTOS = conferences.stream()
                .map(conference -> conferenceMapper.fromConference(conference))
                .toList();
        return conferenceDTOS;
    }

    @Override
    public ConferenceDTO getConferenceById(Long id) {
        Conference conference = conferenceRepository.findById(id).orElse(null);
        if (conference != null) {
            return conferenceMapper.fromConference(conference);
        }
        return null;
    }

    @Override
    public ConferenceDTO createConference(ConferenceDTO conferenceDTO) {
        Conference conference = conferenceMapper.fromConferenceDTO(conferenceDTO);
        Conference savedConference = conferenceRepository.save(conference);
        return conferenceMapper.fromConference(savedConference);
    }

    @Override
    public ConferenceDTO updateConference(ConferenceDTO conferenceDTO) {
        Conference existingConference = conferenceRepository.findById(conferenceDTO.getId())
                .orElseThrow(() -> new RuntimeException("Conference not found"));

        Conference conference = conferenceMapper.fromConferenceDTO(conferenceDTO);
        Conference updatedConference = conferenceRepository.save(conference);
        return conferenceMapper.fromConference(updatedConference);
    }

    @Override
    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }
}
