package co.wide.core.resource;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/resource")
public interface ResourceApi {

    @PostMapping
    Resource save(@RequestBody Resource resource);

    @DeleteMapping("/{resourceId}")
    Resource delete(@PathVariable Long resourceId);

    @PutMapping
    Resource update(@RequestBody Resource resource);

}
