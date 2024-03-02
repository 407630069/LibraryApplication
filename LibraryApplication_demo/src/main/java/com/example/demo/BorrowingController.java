package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Dao.BookRepository;
import Dao.BorrowingRecordRepository;
import Service.BorrowingService;
import Service.UserService;
import model.Book;
import model.BorrowingRecord;
import model.User;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {

    @Autowired
    private UserService userService;

    @PostMapping("/borrow/{userId}/{isbn}")
    public ResponseEntity<String> borrowBook(@PathVariable int userId, @PathVariable String isbn) {
        try {
            User user = userService.getUserById(userId);
            Book book = userService.getBookByIsbn(isbn);
            userService.borrowBook(user, book);
            return ResponseEntity.ok("借書成功");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/return/{userId}/{isbn}")
    public ResponseEntity<String> returnBook(@PathVariable int userId, @PathVariable String isbn) {
        try {
            User user = userService.getUserById(userId);
            Book book = userService.getBookByIsbn(isbn);
            userService.returnBook(user, book);
            return ResponseEntity.ok("還書成功");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}