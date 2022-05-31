package kz.singularity.bankapp.features.students.presentation.controller;

import kz.singularity.bankapp.features.students.data.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students") // Обрабатываем запросы по `URL` - localhost:8080/students
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public String hello() {
        return "Hello World!";
    }
}
