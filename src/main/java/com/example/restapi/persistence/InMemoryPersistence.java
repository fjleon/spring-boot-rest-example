package com.example.restapi.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Object to manage persistence information.
 */
@Repository
public class InMemoryPersistence {

    private List<UserVO> userList;

    /**
     * Constructor to load persistence information.
     */
    public InMemoryPersistence() {
	userList = new ArrayList<>();
	userList.add(UserVO.builder().id(1).name("John").email("johnsmith@gmail.com").score(8).build());
	userList.add(UserVO.builder().id(2).name("Sara").email("sarasmith@gmail.com").score(9).build());
	userList.add(UserVO.builder().id(3).name("Peter").email("peterlenon@gmail.com").score(6).build());
    }

    public List<UserVO> findAllUsers() {
	return userList;
    }

    public UserVO findUserById(Integer id) {
	return this.userList.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
    
    public void saveUser(UserVO userVO) {
	userList.add(userVO);
    }
    
    public void updateUser(UserVO userVO) {
	UserVO userVOForUpdate = findUserById(userVO.getId());
	userVOForUpdate.setName(userVO.getName());
	userVOForUpdate.setEmail(userVO.getEmail());
    }

    public void deleteUser(Integer id) {
	userList.remove(findUserById(id));
    }
    
}
