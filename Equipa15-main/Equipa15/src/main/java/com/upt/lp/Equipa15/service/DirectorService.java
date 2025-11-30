package com.upt.lp.Equipa15.service;

import com.upt.lp.Equipa15.entity.Director;
import com.upt.lp.Equipa15.entity.Media;
import com.upt.lp.Equipa15.repository.DirectorRepository;
import com.upt.lp.Equipa15.repository.MediaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final MediaRepository mediaRepository;

    public DirectorService(DirectorRepository directorRepository, MediaRepository mediaRepository) {
        this.directorRepository = directorRepository;
        this.mediaRepository = mediaRepository;
    }

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Director getDirector(Long id) {
        return directorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Director not found"));
    }

    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director updateDirector(Long id, Director directorDetails) {
        Director director = getDirector(id);
        director.setName(directorDetails.getName());
        director.setAge(directorDetails.getAge());
        return directorRepository.save(director);
    }

    public void deleteDirector(Long id) {
        Director director = getDirector(id);
        directorRepository.delete(director);
    }

    public Director assignMediaDirector(Long directorId, Long mediaId) {
        Director director = getDirector(directorId);
        Media media = mediaRepository.findById(mediaId)
                .orElseThrow(() -> new RuntimeException("Media not found"));
        director.getMedias().add(media);
        return directorRepository.save(director);
    }

    public List<Media> getMediasDirector(Long directorId) {
        Director director = getDirector(directorId);
        return director.getMedias();
    }
}