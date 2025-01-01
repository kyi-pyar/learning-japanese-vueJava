package com.jwt.Test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.Test.entiites.MemorizedKanji;
import com.jwt.Test.entiites.User;

import com.jwt.Test.services.MemorizedKanjiImpl;

import com.jwt.Test.services.UserService;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
	
	
    private  UserService userService;
    
    @Autowired
    private  MemorizedKanjiImpl memorizedKanjiServiceImpl;
    

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();
        System.out.println(currentUser);

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
        List <User> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }
    
    
    @PostMapping("/saveMemo")
    public ResponseEntity<MemorizedKanji> saveMemo(@RequestBody MemorizedKanji word){
    	System.out.println(word);
    	MemorizedKanji MemorizedKanji=memorizedKanjiServiceImpl.save(word);
    	return ResponseEntity.ok(MemorizedKanji);
    }
    
    @GetMapping("/getAll/{id}")
    public ResponseEntity<List<MemorizedKanji>> getAll(@PathVariable int id){
    	List<MemorizedKanji> MemorizedKanjis=memorizedKanjiServiceImpl.getAll(id);    	
    	return ResponseEntity.ok(MemorizedKanjis);
    }
    
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deletyMemorizedKanji(@PathVariable int id){
    	memorizedKanjiServiceImpl.delete(id);    	
    	return ResponseEntity.ok("deleted");
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<MemorizedKanji> get(@PathVariable int id){    	
    	MemorizedKanji memorizedKanjis=memorizedKanjiServiceImpl.getById(id);    	
    	return ResponseEntity.ok(memorizedKanjis);
    }
    
    @PutMapping("/edit/")
    public ResponseEntity<MemorizedKanji> eit(@RequestBody MemorizedKanji kanji){  
    	System.out.println("kanji to update"+ kanji);
    	MemorizedKanji updated=memorizedKanjiServiceImpl.editMemo(kanji.getId(), kanji);
    	return ResponseEntity.ok(updated);
    }
    
    
    
}
