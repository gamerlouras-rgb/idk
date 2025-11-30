package com.upt.lp.Equipa15.service;

import com.upt.lp.Equipa15.entity.Actor;
import com.upt.lp.Equipa15.entity.Media;
import com.upt.lp.Equipa15.repository.ActorRepository;
import com.upt.lp.Equipa15.repository.MediaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final MediaRepository mediaRepository;

    public ActorService(ActorRepository actorRepository, MediaRepository mediaRepository) {
        this.actorRepository = actorRepository;
        this.mediaRepository = mediaRepository;
    }

    // CRUD
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActor(Long id) {
        return actorRepository.findById(id).orElseThrow(() -> new RuntimeException("Actor not found"));
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor updateActor(Long id, Actor actorDetails) {
        Actor actor = getActor(id);
        actor.setName(actorDetails.getName());
        actor.setAge(actorDetails.getAge());
        return actorRepository.save(actor);
    }

    public void deleteActor(Long id) {
        Actor actor = getActor(id);
        actorRepository.delete(actor);
    }

    public Actor assignMediaActor(Long actorId, Long mediaId) {
        Actor actor = getActor(actorId);
        Media media = mediaRepository.findById(mediaId)
                .orElseThrow(() -> new RuntimeException("Media not found"));
        actor.getMedias().add(media);
        return actorRepository.save(actor);
    }

    public List<Media> getMediasActor(Long actorId) {
        Actor actor = getActor(actorId);
        return actor.getMedias();
    }
}
