package org.ghazoui.conferenceservice.feign;

import org.ghazoui.conferenceservice.model.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "keynote-service")
public interface KeynoteRestClient {

    @GetMapping("/keynotes")
    List<Keynote> getAllKeynotes();

    @GetMapping("/keynotes/{keynoteId}")
    Keynote getKeynoteById(@PathVariable Long keynoteId);

}
