package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Dao.UserRepository;
import model.User;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        
        if(userRepository.findByPhoneNumber(user.getPhoneNumber()) != null) {
            return ResponseEntity.badRequest().body("手機號碼已被註冊");
        }
        // 加密處理
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return ResponseEntity.ok("註冊成功");
    }

    private String hashPassword(String password) {
        
        return password;
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginUser) {
        User user = userRepository.findByPhoneNumber(loginUser.getPhoneNumber());
        if(user == null) {
            return ResponseEntity.badRequest().body("使用者不存在");
        }
        
        if(!validatePassword(loginUser.getPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body("密碼錯誤");
        }
        return ResponseEntity.ok("登入成功");
    }

    private boolean validatePassword(String inputPassword, String hashedPassword) {
        // 密碼驗證處理
        return inputPassword.equals(hashedPassword);
    }
}
