package com.example.week4hw2.controller;

import com.example.week4hw2.model.user1;
import com.example.week4hw2.sirsveis.UserServies;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user1")
public class Usercontroller {
    private final UserServies userServies;

    @GetMapping("/get")
    public ResponseEntity getAlluser() {
        List<user1> userList = userServies.getAlluser();
        return ResponseEntity.status(200).body(userList);
    }

    @PutMapping("/add")
    public ResponseEntity adduser(@Valid @RequestBody user1 user, Errors errors) {
        if (errors.hasErrors()) {
            String masegge = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(masegge);
        }
        userServies.adduser(user);
        return ResponseEntity.status(200).body("USER adde");
    }

    public ResponseEntity updateuser(@Valid @RequestBody user1 user, Errors errors) {
        if (errors.hasErrors()) {
            String massege = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        boolean isupdated = userServies.updateuser(1, user);
        return ResponseEntity.status(200).body("is updated");
    }

    public ResponseEntity deleteuser(@Valid @RequestBody user1 user, @PathVariable Integer ID) {
        if (userServies.deleteuser(ID)) {
            return ResponseEntity.status(200).body("USER DELETED");
        }
        return ResponseEntity.status(400).body("DELETED");
    }

    @GetMapping("/checkP&U")
    public ResponseEntity getCheckByUsernameAndPassowrd(@PathVariable String passowrd, @Valid @RequestBody String username) {
        user1 users = userServies.getCheckByUsernameAndPassowrd(username, passowrd);
        if (passowrd == username) {
            return ResponseEntity.status(200).body("correct");
        } else {
            return ResponseEntity.status(400).body("not correct");
        }
    }




    @GetMapping("/email")
public ResponseEntity  getuser1sBy(@Valid @RequestBody String username ,String email){
       user1 user1=userServies.getAlluser().get(1);
       return ResponseEntity.status(200).body(username);
}
@GetMapping("/ROLE")
public ResponseEntity getByRole(@Valid @RequestBody String role){
        List<user1>user1s=userServies.getAlluser();
        return ResponseEntity.status(200).body(role);
}
@GetMapping("/age")
public ResponseEntity getuser1sByAge(@PathVariable Integer age){
        List<user1>user1s=userServies.getAlluser();
        return ResponseEntity.status(200).body(age);
}







}
