package com.upt.lp.Equipa15.DTO;

import java.util.*;


public class UserDTO {
    private long id;
    private String username;
    private String email;
    private String userType;
    private String password;
    private List<Long> reviewIds;
    private List<Long> watchedMovieIds;
    private List<Long> watchedSeriesIds;

    public UserDTO(){} //

    public UserDTO(Long id, String username, String email, String userType, String password,List<Long> reviewIds, List<Long> watchedMovieIds, List<Long> watchedSeriesIds){
        this.id = id;
        this.username = username;
        this.email = email;
        this.userType = userType;
        this.password = password;
        this.reviewIds = reviewIds;
        this.watchedMovieIds = watchedMovieIds;
        this.watchedSeriesIds = watchedSeriesIds;

    }
    //Getters and Setters
    public Long getId(){
        return id;

    }
    public void setId(Long id){
        this.id = id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getUserType(){
        return userType;
    }
    public void setUserType(String userType){
        this.userType = userType;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public List<Long> getReviewIds(){
        return reviewIds;
    }
    public void setReviewIds(List<Long> reviewIds){
        this.reviewIds = reviewIds;
    }
    public List<Long> getWatchedMovieIds(){
        return watchedMovieIds;
    }
    public void setWatchedMovieIds(List<Long> watchedMovieIds){
        this.watchedMovieIds = watchedMovieIds;
    }
    public List<Long> getWatchedSeriesIds(){
        return watchedSeriesIds;
    }
    public void setWatchedSeriesIds(List<Long> watchedSeriesIds){
        this.watchedSeriesIds = watchedSeriesIds;
    }


}

