package pl.pjwstk.s26071bank.repository;

import org.springframework.stereotype.Repository;
import pl.pjwstk.s26071bank.model.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class BankAccountRepository {

    private List<BankAccount> bankAccountList = new ArrayList<>();

    public BankAccountRepository(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public void save(BankAccount bankAccount){
        bankAccountList.add(bankAccount);
    }

    public List<BankAccount> getAll(){
        return this.bankAccountList;
    }

    public Optional<BankAccount> findById(long id){
        return bankAccountList.stream()
                .filter(bankAccount -> bankAccount.getId() == id)
                .findFirst();
    }

    public BankAccount depositToAccount(long id, double amount){
        BankAccount bankAccount = findById(id).get();
        bankAccount.setAmount(bankAccount.getAmount() + amount);
        return bankAccount;
    }

    public BankAccount withdraw(long id, double amount){
        BankAccount bankAccount = findById(id).get();
        bankAccount.setAmount(bankAccount.getAmount() - amount);
        return bankAccount;
    }

}
