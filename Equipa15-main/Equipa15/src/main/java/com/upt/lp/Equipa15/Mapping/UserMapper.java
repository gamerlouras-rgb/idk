package com.upt.lp.Equipa15.Mapping;

import com.upt.lp.Equipa15.DTO.UserDTO;
import com.upt.lp.Equipa15.entity.User;
import com.upt.lp.Equipa15.entity.UserType;
import java.util.*;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO toDTO(User user){
        if( user == null) return null;

        return new UserDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getUserType().name(),
            user.getPassword(),
            user.getReviews().stream().map(r -> r.getId()).collect(Collectors.toList()),
            user.getWatched_movies().stream().map(movies -> movies.getId()).collect(Collectors.toList()),
            user.getWatched_series().stream().map(series -> series.getId()).collect(Collectors.toList())
        );
    }

    public static User toEntity(UserDTO dto){
        if (dto == null) {
            return null;
        }else{ 
            User user = new User();

            if(dto.getId() != 0){
                user.setId(dto.getId());
            }

            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setUserType(UserType.valueOf(dto.getUserType()));
            return user;
        }
        
    }
}

