package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import model.Student;
import model.StudentRowMapper;

@RestController
public class MyController {
    
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
    @RequestMapping("/test")
    public String test() {
        System.out.println("Hi!");
        return "Hello World";
    }
    
    
    @RequestMapping("/insert")
    public String insert(@RequestBody Student student) {
    	String sql = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";
    	Map<String, Object> map = new HashMap<>();
    	
    	map.put("studentId", student.getId());
    	map.put("studentName", student.getName());
    	
    	namedParameterJdbcTemplate.update(sql, map);
    	
    	
        return "SQL insert";
    }
    
    
    
    @RequestMapping(value = "/query")
    public Student query(@RequestParam Integer id ) {
        String sql = "SELECT id, name FROM student WHERE id = :id"; // Corrected SQL syntax
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        List<Student> studentList = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());

        if (studentList.size() > 0) {
            return studentList.get(0);
        } else {
            return null;
        }
    }
    
    @RequestMapping("/queryAll")
    public List<Student> query() {
        String sql = "SELECT id, name FROM student";

        List<Student> students = namedParameterJdbcTemplate.query(sql, new HashMap<>(),
                (rs, rowNum) -> new Student(rs.getInt("id"), rs.getString("name")));


        return students;
    }
    
    
}