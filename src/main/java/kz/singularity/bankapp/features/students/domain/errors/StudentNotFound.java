package kz.singularity.bankapp.features.students.domain.errors;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(Long id) {
        super(String.format("Could not find student %d", id));
    }
}