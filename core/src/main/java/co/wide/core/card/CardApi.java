package co.wide.core.card;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/card")
public interface CardApi {

    @GetMapping("/{id}")
    Card getCard(@PathVariable Long id);

    @PostMapping
    Card saveCard(@RequestBody Card card);

}
