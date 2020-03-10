package com.example.restapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.BasicUser;
import com.example.restapi.model.FullUser;
import com.example.restapi.persistence.InMemoryPersistence;
import com.example.restapi.persistence.UserVO;
import com.example.restapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private InMemoryPersistence repository;
    
    @Override
    public BasicUser getBasicUser(Integer id) {
	return transformUserVOToBasicUser(repository.findUserById(id));
    }
    
    @Override
    public FullUser getFullUser(Integer id) {
	return transformUserVOToFullUser(repository.findUserById(id));
    }

    @Override
    public void createFullUser(FullUser user) {
	repository.saveUser(transformFullUserToUserVO(user));
    }

    @Override
    public void updateFullUser(FullUser user) {
	repository.updateUser(transformFullUserToUserVO(user));
    }

    @Override
    public void deleteFullUser(Integer id) {
	repository.deleteUser(id);
    }
    
    private FullUser transformUserVOToFullUser(UserVO userVO) {
	FullUser full = null;
	if(userVO != null) {
	    full = FullUser.builder()
                	    	.id(userVO.getId())
                	    	.name(userVO.getName())
                	    	.email(userVO.getEmail())
                	    	.score(userVO.getScore())
                	    	.build();
	}
	return full;
    }
    
    private BasicUser transformUserVOToBasicUser(UserVO userVO) {
	BasicUser basic = null;
	if(userVO != null) {
	    basic = BasicUser.builder()
	    	.id(userVO.getId())
	    	.name(userVO.getName())
	    	.email(userVO.getEmail())
	    	.build();
	}
	return basic;
    }
    
    private UserVO transformFullUserToUserVO(FullUser fullUser) {
	UserVO userVO = null;
	if(fullUser != null) {
	    userVO = UserVO.builder()
	    	.id(fullUser.getId())
	    	.name(fullUser.getName())
	    	.email(fullUser.getEmail())
	    	.score(fullUser.getScore())
	    	.build();
	}
	return userVO;
    }

}
