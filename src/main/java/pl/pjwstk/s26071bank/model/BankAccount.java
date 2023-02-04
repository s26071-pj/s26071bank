package pl.pjwstk.s26071bank.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount{
    private long id;
    private String name;
    private String surname;
    private double amount;
    private TransactionStatus transactionStatus;
}
