package com.upt.lp.Equipa15.Mapping;

import com.upt.lp.Equipa15.DTO.DirectorDTO;
import com.upt.lp.Equipa15.entity.Director;

public class DirectorMapper {

    public static DirectorDTO toDTO(Director director) {
        if (director == null) return null;
        return new 
        		DirectorDTO(director.getId(), 
        		director.getName(), 
        		director.getAge());
    }

    public static Director toEntity(DirectorDTO directorDTO) {
        if (directorDTO == null) return null;
        Director director = new Director();
        director.setId(directorDTO.getId());
        director.setName(directorDTO.getName());
        director.setAge(directorDTO.getAge());
        return director;
    }
}
