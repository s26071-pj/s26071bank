package pl.pjwstk.s26071bank.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacionRequest {
    private TransactionStatus transactionStatus;
    private double newAmount;
}
