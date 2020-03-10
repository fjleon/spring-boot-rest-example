package com.example.restapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.BasicUser;
import com.example.restapi.model.FullUser;
import com.example.restapi.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/full", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FullUser> getFullUser(@RequestParam Integer id) {
	return ResponseEntity.ok(userService.getFullUser(id));
    }

    @GetMapping(value = "/basic", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicUser> getBasicUser(@RequestParam Integer id) {
	return ResponseEntity.ok(userService.getBasicUser(id));
    }
    
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicUser> createUser(@RequestBody FullUser user) {
	userService.createFullUser(user);
	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicUser> updateUser(@RequestBody FullUser user) {
	userService.updateFullUser(user);
	return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @DeleteMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicUser> deleteUser(@RequestParam Integer id) {
	userService.deleteFullUser(id);
	return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}
