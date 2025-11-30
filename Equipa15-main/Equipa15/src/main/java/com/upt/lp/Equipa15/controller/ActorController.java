package com.upt.lp.Equipa15.controller;

import com.upt.lp.Equipa15.entity.Actor;
import com.upt.lp.Equipa15.entity.Media;
import com.upt.lp.Equipa15.service.ActorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAll() {
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public Actor getById(@PathVariable Long id) {
        return actorService.getActor(id);
    }

    @PostMapping
    public Actor create(@RequestBody Actor actor) {
        return actorService.createActor(actor);
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable Long id, @RequestBody Actor actor) {
        return actorService.updateActor(id, actor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        actorService.deleteActor(id);
    }

    @PostMapping("/{actorId}/medias/{mediaId}")
    public Actor assignMedia(@PathVariable Long actorId, @PathVariable Long mediaId) {
        return actorService.assignMediaActor(actorId, mediaId);
    }

    @GetMapping("/{actorId}/medias")
    public List<Media> getMediasOfActor(@PathVariable Long actorId) {
        return actorService.getMediasActor(actorId);
    }
}
