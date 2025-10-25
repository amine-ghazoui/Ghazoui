package org.ghazoui.keynoteservice.services;

import lombok.AllArgsConstructor;
import org.ghazoui.keynoteservice.dtos.KeynoteDTO;
import org.ghazoui.keynoteservice.entities.Keynote;
import org.ghazoui.keynoteservice.mappers.KeynoteMapperImpl;
import org.ghazoui.keynoteservice.repositories.KeynoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class KeynoteServiceImpl implements KeynoteService {


    private KeynoteRepository keynoteRepository;
    private KeynoteMapperImpl keynoteMapper;


    @Override
    public List<KeynoteDTO> getAllKeynotes() {
        List<Keynote> keynotes = keynoteRepository.findAll();
        List<KeynoteDTO> keynoteDTOS = keynotes.stream()
                .map(keynote -> keynoteMapper.fromKeynote(keynote)).toList();
        return keynoteDTOS;
    }

    @Override
    public KeynoteDTO getKeynoteById(Long id) {
        Keynote keynote = keynoteRepository.findById(id).orElse(null);
        if(keynote != null){
            return keynoteMapper.fromKeynote(keynote);
        }
        return null;
    }

    @Override
    public KeynoteDTO createKeynote(KeynoteDTO keynoteDTO) {

        Keynote keynote = keynoteMapper.fromKeynoteDTO(keynoteDTO);
        Keynote saveKeynote = keynoteRepository.save(keynote);
        return keynoteMapper.fromKeynote(saveKeynote);
    }

    @Override
    public KeynoteDTO updateKeynote(KeynoteDTO keynoteDTO) {

        Keynote existingKeynote = keynoteRepository.findById(keynoteDTO.getId())
                .orElseThrow(() -> new RuntimeException("Keynote not found"));

        Keynote keynote = keynoteMapper.fromKeynoteDTO(keynoteDTO);
        Keynote updatedKeynote = keynoteRepository.save(keynote);
        return keynoteMapper.fromKeynote(updatedKeynote);
    }

    @Override
    public void deleteKeynote(Long id) {
        keynoteRepository.deleteById(id);
    }
}
