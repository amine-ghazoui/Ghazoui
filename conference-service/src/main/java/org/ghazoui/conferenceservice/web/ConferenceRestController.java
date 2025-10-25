package org.ghazoui.conferenceservice.web;

import org.ghazoui.conferenceservice.dtos.ConferenceDTO;
import org.ghazoui.conferenceservice.services.ConferenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConferenceRestController {

    private final ConferenceService conferenceService;

    // 👉 Injection par constructeur (bonne pratique)
    public ConferenceRestController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/conferences")
    public List<ConferenceDTO> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    @GetMapping("/conferences/{conferenceId}")
    public ConferenceDTO getConference(@PathVariable Long conferenceId) {
        return conferenceService.getConferenceById(conferenceId);
    }

    @PostMapping("/conferences")
    public ConferenceDTO saveConference(@RequestBody ConferenceDTO conferenceDTO) {
        return conferenceService.createConference(conferenceDTO);
    }

    @PutMapping("/conferences/{conferenceId}")
    public ConferenceDTO updateConference(@PathVariable Long conferenceId, @RequestBody ConferenceDTO conferenceDTO) {
        conferenceDTO.setId(conferenceId);
        return conferenceService.updateConference(conferenceDTO);
    }

    @DeleteMapping("/conferences/{conferenceId}")
    public void deleteConference(@PathVariable Long conferenceId) {
        conferenceService.deleteConference(conferenceId);
    }
}
