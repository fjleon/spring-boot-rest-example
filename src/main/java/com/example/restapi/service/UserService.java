package com.example.restapi.service;

import com.example.restapi.model.BasicUser;
import com.example.restapi.model.FullUser;

public interface UserService {

    BasicUser getBasicUser(Integer id);
    
    FullUser getFullUser(Integer id);
    void createFullUser(FullUser user);
    void updateFullUser(FullUser user);
    void deleteFullUser(Integer id);
    
}
