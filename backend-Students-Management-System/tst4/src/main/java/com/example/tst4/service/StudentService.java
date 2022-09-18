package com.example.tst4.service;

import com.example.tst4.entity.Student;
import com.example.tst4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void addStudent( Student student){
        studentRepository.save(student);
    }
    public List<Student> getAll(){
        return (List<Student>) studentRepository.findAll();
    }
    public Student getById(int id){
        return studentRepository.findById(id).get();
    }
    public void delete(int id){
        studentRepository.deleteById(id);
    }
    public void edit(Student student,int id){
        Student student1=studentRepository.findById(id).get();
        student1.setPrenom(student.getPrenom());
        student1.setNom(student.getNom());
        student1.setEmail(student.getEmail());
        studentRepository.save(student1);

    }
}
