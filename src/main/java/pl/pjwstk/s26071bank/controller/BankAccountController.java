package pl.pjwstk.s26071bank.controller;


import org.springframework.web.bind.annotation.*;
import pl.pjwstk.s26071bank.model.BankAccount;
import pl.pjwstk.s26071bank.model.TransacionRequest;
import pl.pjwstk.s26071bank.servis.BankAccountServis;

import java.util.List;

@RestController
@RequestMapping("/BankAccount")
public class BankAccountController {

    public final BankAccountServis bankAccountServis;

    public BankAccountController(BankAccountServis bankAccountServis) {
        this.bankAccountServis = bankAccountServis;
    }

    @PostMapping("/RegisterNewAccount")
    public void addNewBankAccount(@RequestBody BankAccount bankAccount){
    bankAccountServis.save(bankAccount);
    }

    @GetMapping("/FindAllBankAccounts")
    public List<BankAccount> showAllBankAccounts(){
        return this.bankAccountServis.getAllBankAccounts();
    }

    @GetMapping("/FindBankAccountById")
    public BankAccount findById(@RequestParam long id){
    return this.bankAccountServis.findBankAccountById(id);
    }

    @PostMapping("/WithdrawFromBankAccount")
    public BankAccount withdrawFromAccount(@RequestParam long id, @RequestParam double balance){
        return bankAccountServis.withdrawFromBankAccount(id, balance);
    }

    @PostMapping("/DepositFromAccount")
    public BankAccount depositToAccount(@RequestParam long id,@RequestParam double amount ){
        return bankAccountServis.depositToAccount(id, amount);
    }


}
