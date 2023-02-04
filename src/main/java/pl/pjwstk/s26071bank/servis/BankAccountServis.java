package pl.pjwstk.s26071bank.servis;


import org.springframework.stereotype.Service;
import pl.pjwstk.s26071bank.model.BankAccount;
import pl.pjwstk.s26071bank.model.TransacionRequest;
import pl.pjwstk.s26071bank.repository.BankAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountServis{

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServis(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public void save(BankAccount bankAccount){
        bankAccountRepository.save(bankAccount);
    }

    public List<BankAccount> getAllBankAccounts(){
    return bankAccountRepository.getAll();
    }

    public BankAccount findBankAccountById(long id){
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(id);
        if (optionalBankAccount.isPresent()){
            return optionalBankAccount.get();
        } else {
            throw new RuntimeException();
        }
    }

    public BankAccount depositToAccount(long id,double amount){
        return bankAccountRepository.depositToAccount(id, amount);
    }

    public BankAccount withdrawFromBankAccount(long id, double balance){
        if (balance > bankAccountRepository.findById(id).get().getAmount()){
            throw new RuntimeException();
        }
        return bankAccountRepository.withdraw(id, balance);
        }
    }
