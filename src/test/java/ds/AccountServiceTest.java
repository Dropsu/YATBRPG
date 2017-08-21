package ds;

import ds.account.Account;
import ds.account.AccountRepository;
import ds.account.AccountService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Damian on 21.08.2017.
 */
public class AccountServiceTest {
    private AccountRepository mockRepository;
    private AccountService service;

    @Before
    public void setUpMocksAndService (){
        mockRepository = mock(AccountRepository.class);
        service = new AccountService(mockRepository);
    }

    @Test
    public void WhenGottenAccountObjectToRegisterShouldInvokeAddingMethodOnRepository () {
        Account accountToRegister = new Account("John","Superkick");
        service.registerAccount(accountToRegister);
        verify(mockRepository,atLeastOnce()).save(accountToRegister);
    }
}
