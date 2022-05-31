package kz.singularity.bankapp.features.students.data.services;

import kz.singularity.bankapp.features.students.data.entities.Student;
import kz.singularity.bankapp.features.students.data.repositories.StudentRepository;
import kz.singularity.bankapp.features.students.domain.errors.StudentNotFound;
import kz.singularity.bankapp.features.students.domain.models.StudentRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository; // 1 Объявляем переменную для репозитория с CRUD методами в бд;

    public Long createStudent(StudentRequest userRequest) { // 2 Создаем метод для создания студента, в аргументах принимаем DTO - Data Transfer Object. Эти данные будет отправлять пользователь. В нем нет id.
        Student user = Student.builder(). // 3 .builder() - это метод из lombok, который позволяет функционально создавать объект класса Student
                email(userRequest.getEmail()).
                firstName(userRequest.getFirstName()).
                lastName(userRequest.getLastName()).
                build();
        Student createdUser = studentRepository.save(user); // 4 Сохраняем студента в бд.
        return createdUser.getId(); // 5 Возвращаем id нового студента.
    }

    public void deleteStudent(Long id) { // 6 Метод для удаления будет принимать id студента.
        studentRepository.findById(id).orElseThrow(() -> new StudentNotFound(id)); // 7 Проверяем наличие студента в, базе либо выбрасываем Exception.
        studentRepository.deleteById(id); // 8 Вызов метода для удаления студента из бд.
    }

    public Student updateStudent(StudentRequest userRequest, Long id) { // 9 При обновлении мы принимаем DTO объект и id студента.
        studentRepository.findById(id).orElseThrow(() -> new StudentNotFound(id));
        Student user = Student.builder().
                email(userRequest.getEmail()).
                firstName(userRequest.getFirstName()).
                lastName(userRequest.getLastName()).
                id(id).
                build();
        return studentRepository.save(user);
    }

    public List<Student> getStudents() { // 10 Получение всех студентов.
        Iterable<Student> iterable = studentRepository.findAll();
        return Streamable.of(iterable).toList();
    }
    public Student getStudentById(Long id){ // 11 Получение студента по id
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFound(id));
    }
}