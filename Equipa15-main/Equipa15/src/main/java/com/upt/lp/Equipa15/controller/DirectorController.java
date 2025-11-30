package com.upt.lp.Equipa15.controller;

import com.upt.lp.Equipa15.entity.Director;
import com.upt.lp.Equipa15.entity.Media;
import com.upt.lp.Equipa15.service.DirectorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public List<Director> getAll() {
        return directorService.getAllDirectors();
    }

    @GetMapping("/{id}")
    public Director getById(@PathVariable Long id) {
        return directorService.getDirector(id);
    }

    @PostMapping
    public Director create(@RequestBody Director director) {
        return directorService.createDirector(director);
    }

    @PutMapping("/{id}")
    public Director update(@PathVariable Long id, @RequestBody Director director) {
        return directorService.updateDirector(id, director);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        directorService.deleteDirector(id);
    }

    @PostMapping("/{directorId}/medias/{mediaId}")
    public Director assignMedia(@PathVariable Long directorId, @PathVariable Long mediaId) {
        return directorService.assignMediaDirector(directorId, mediaId);
    }

    @GetMapping("/{directorId}/medias")
    public List<Media> getMediasOfDirector(@PathVariable Long directorId) {
        return directorService.getMediasDirector(directorId);
    }
}
