package kz.singularity.bankapp.features.transactions.data.entities;


import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
public class Transaction {
    @NonNull
    @Id
    @Generated
    private Long id;
    private String transactionInfo;


}
