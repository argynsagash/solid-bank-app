package kz.singularity.bankapp.features.students.presentation.controller;

import kz.singularity.bankapp.features.students.data.entities.Student;
import kz.singularity.bankapp.features.students.data.services.StudentService;
import kz.singularity.bankapp.features.students.domain.models.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //указывает, что данные, возвращаемые каждым методом, будут записаны прямо в текст ответа вместо отображения шаблона.
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}") // указывает, что в аргументах ожидается id - /student/2.
    public Student getStudentById(@PathVariable Long id) { //указывает на считываемое значение из URI.
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Long createUser(@RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody StudentRequest studentRequest, @PathVariable Long id) {
        return studentService.updateStudent(studentRequest, id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return true;
    }
}