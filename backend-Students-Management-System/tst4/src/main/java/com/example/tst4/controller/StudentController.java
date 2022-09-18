package com.example.tst4.controller;

import com.example.tst4.entity.Student;
import com.example.tst4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);

    }

    @GetMapping("/all")
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @GetMapping("/{id}/view")
    public Student getById(@PathVariable("id") int id){
       return studentService.getById(id);
    }
    @GetMapping("/{id}/delete")
    public void deleteStudent(@PathVariable("id") int id){
        studentService.delete(id);

    }
    @PutMapping("/{id}/edit")
    public void editStudent(@PathVariable("id") int id,@RequestBody Student student){
        studentService.edit(student,id);

    }

}
