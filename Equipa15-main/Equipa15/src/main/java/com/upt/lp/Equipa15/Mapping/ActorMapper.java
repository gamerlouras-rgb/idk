package com.upt.lp.Equipa15.Mapping;

import com.upt.lp.Equipa15.DTO.ActorDTO;
import com.upt.lp.Equipa15.entity.Actor;

public class ActorMapper {
    public static ActorDTO toDTO(Actor actor) {
        if (actor == null) return null;
        return new ActorDTO(
                actor.getId(),
                actor.getName(),
                actor.getAge()
        );
    }

    public static Actor toEntity(ActorDTO actorDTO) {
        if (actorDTO == null) return null;
        Actor actor = new Actor();
        actor.setId(actorDTO.getId());
        actor.setName(actorDTO.getName());
        actor.setAge(actorDTO.getAge());
        return actor;
    }
}
