package org.ghazoui.keynoteservice.services;

import org.ghazoui.keynoteservice.dtos.KeynoteDTO;
import org.ghazoui.keynoteservice.repositories.KeynoteRepository;

import java.util.List;

public interface KeynoteService {

    List<KeynoteDTO> getAllKeynotes();
    KeynoteDTO getKeynoteById(Long id);
    KeynoteDTO createKeynote(KeynoteDTO keynoteDTO);
    KeynoteDTO updateKeynote(KeynoteDTO keynoteDTO);
    void deleteKeynote(Long id);
}
