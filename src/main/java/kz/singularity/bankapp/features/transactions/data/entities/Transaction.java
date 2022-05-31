package kz.singularity.bankapp.features.transactions.data.entities;


import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
public class Transaction {

    @Id
    private Long id;
    private String transactionInfo;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private String accountID;


}
