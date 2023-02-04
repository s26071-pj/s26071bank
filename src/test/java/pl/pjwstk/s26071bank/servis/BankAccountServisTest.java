package pl.pjwstk.s26071bank.servis;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.pjwstk.s26071bank.controller.BankAccountController;
import pl.pjwstk.s26071bank.model.BankAccount;
import pl.pjwstk.s26071bank.model.TransacionRequest;
import pl.pjwstk.s26071bank.model.TransactionStatus;
import pl.pjwstk.s26071bank.repository.BankAccountRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BankAccountServisTest {

    private final BankAccountRepository bankAccountRepository = Mockito.mock(BankAccountRepository.class);
    private final BankAccountServis bankAccountServis = new BankAccountServis(bankAccountRepository);

    private BankAccount bankAccount1, bankAccount2, bankAccount3;
    private List<BankAccount> accountList;


    @BeforeEach
    //given
    void setUpBankAccounts(){
        bankAccount1 = new BankAccount(1,"Tomasz","Chick",2000.00,TransactionStatus.ACCEPTED);
        bankAccount2 = new BankAccount(2,"Andrzej","Nowak",3000.00,TransactionStatus.ACCEPTED);
        bankAccount3 = new BankAccount(3,"Krzysztof","Narciarz",5500.00,TransactionStatus.REJECTED);
    }

    @Test
    void shouldSaveNewBankAccount() {
        assertDoesNotThrow( ()-> bankAccountServis.save(bankAccount2));

        when(bankAccountRepository.findById(2)).thenReturn(Optional.of(bankAccount2));
        Optional<BankAccount> foundCar = bankAccountRepository.findById(2);

        assertTrue(foundCar.isPresent());
        assertEquals(foundCar.get(), bankAccount2);
    }

    @Test
    void shouldReturnAllCreatedBankAccounts() {
        //when
        Mockito.when(bankAccountServis.getAllBankAccounts()).thenReturn(accountList);
        List<BankAccount> query = bankAccountServis.getAllBankAccounts();
        //then
        Assertions.assertEquals(query, accountList);
    }

    @Test
    void ShouldFindBankAccountById() {
        //when
        Mockito.when(bankAccountRepository.findById(2)).thenReturn(Optional.of(bankAccount2));
        BankAccount result = bankAccountServis.findBankAccountById(2);
        //then
        Assertions.assertEquals(result, bankAccount2);
    }

    @Test
    void withdrawFromBankAccount() {
//
//        //given
//        long id = 1;
//        double amount = 200.00;
//        TransacionRequest transacionRequest = new TransacionRequest();
//
//        //when
//        Mockito.when(bankAccountRepository.findById(id)).thenReturn(Optional.ofNullable(bankAccount1));
//        transacionRequest = bankAccountServis.withdrawFromBankAccount(id,
//                transacionRequest.getNewAmount());
//
//        //then
//        Assertions.assertEquals(TransactionStatus.ACCEPTED, transacionRequest.getTransactionStatus());
//

    }
}