package org.ghazoui.keynoteservice.web;

import org.ghazoui.keynoteservice.dtos.KeynoteDTO;
import org.ghazoui.keynoteservice.services.KeynoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeynoteRestController {

    @Autowired
    private KeynoteService keynoteService;

    @GetMapping("/keynotes")
    public List<KeynoteDTO> getAllKeynotes() {
        return keynoteService.getAllKeynotes();
    }

    @GetMapping("/keynotes/{keynoteId}")
    public KeynoteDTO getKeynote(@PathVariable Long keynoteId) {
        return keynoteService.getKeynoteById(keynoteId);
    }

    @PostMapping("/keynotes")
    public KeynoteDTO saveKeynote(@RequestBody KeynoteDTO keynoteDTO) {
        return keynoteService.createKeynote(keynoteDTO);
    }

    @PutMapping("/keynotes/{keynoteId}")
    public KeynoteDTO updateKeynote(@PathVariable Long keynoteId, @RequestBody KeynoteDTO keynoteDTO) {
        keynoteDTO.setId(keynoteId);
        return keynoteService.updateKeynote(keynoteDTO);
    }

    @DeleteMapping("/keynotes/{keynoteId}")
    public void deleteKeynote(@PathVariable Long keynoteId) {
        keynoteService.deleteKeynote(keynoteId);
    }
}
