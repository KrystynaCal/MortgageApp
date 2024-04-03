package com.Bank;

import com.Bank.Model.Mortgage;
import com.Bank.Service.MortgageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BankApplicationTests {

    private final MortgageService service = new MortgageService();


    @Test
    void shouldReturnMonthlyPayment() {
        //given
        Mortgage monthlyPayment = new Mortgage(200000, 2.0, 20);
        //when
        double result = service.calculateMonthlyPayment(monthlyPayment);
        //then
        assertEquals(Math.floor((200000 * 2.0 / 12 / 100) /
                (1 - Math.pow(1 + 2.0 / 12, -20 * 12))), 333);
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenAmountIsZero() {
        ///given
        Mortgage amountzero = new Mortgage(0, 2.0, 20);
        //when //then
        assertThrows(IllegalArgumentException.class, () -> service.calculateMonthlyPayment(amountzero));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenInterestIsZero() {
        //given
        Mortgage interestZero = new Mortgage(200000, 0, 20);
        //when //then
        assertThrows(IllegalArgumentException.class, () -> service.calculateMonthlyPayment(interestZero));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenLengthIsZero() {
        //given
        Mortgage lengthZero = new Mortgage(200000, 2.0, 0);
        //when //then
        assertThrows(IllegalArgumentException.class, () -> service.calculateMonthlyPayment(lengthZero));

    }

}
