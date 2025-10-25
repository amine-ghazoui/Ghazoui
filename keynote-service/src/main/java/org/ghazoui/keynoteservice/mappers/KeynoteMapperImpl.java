package org.ghazoui.keynoteservice.mappers;

import org.ghazoui.keynoteservice.dtos.KeynoteDTO;
import org.ghazoui.keynoteservice.entities.Keynote;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class KeynoteMapperImpl {

    public KeynoteDTO fromKeynote(Keynote keynote) {
        KeynoteDTO keynoteDTO = new KeynoteDTO();
        BeanUtils.copyProperties(keynote, keynoteDTO);
        return keynoteDTO;
    }

    public Keynote fromKeynoteDTO(KeynoteDTO keynoteDTO) {
        Keynote keynote = new Keynote();
        BeanUtils.copyProperties(keynoteDTO, keynote);
        return keynote;
    }
}
