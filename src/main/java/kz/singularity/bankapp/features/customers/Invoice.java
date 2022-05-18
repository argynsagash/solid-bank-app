package kz.singularity.bankapp.features.customers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Invoice {
    private @Id
    Long invoiceId;
    private Date invoiceDate;
}