package co.wide.core.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/resource")
public interface ResourceApi {

    @PostMapping("/{cardId}")
    Resource addToCard(
            @PathVariable Long cardId,
            @RequestBody Resource resource
    );

}
