package kz.singularity.bankapp.features.students.data.repositories;

import kz.singularity.bankapp.features.students.data.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
