package kz.singularity.bankapp.features.students.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@Builder
public class Student {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}