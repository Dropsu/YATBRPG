package ds;

import ds.account.Account;
import ds.account.AccountRepository;
import ds.account.AccountServiceImpl;
import ds.account.MageCreator;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Damian on 21.08.2017.
 */
public class AccountServiceTest {
    private AccountRepository mockAccountRepository;
    private MageCreator mockMageCreator;
    private AccountServiceImpl service;

    @Before
    public void setUpMocksAndService (){
        mockAccountRepository = mock(AccountRepository.class);
        mockMageCreator = mock(MageCreator.class);
        service = new AccountServiceImpl(mockAccountRepository, mockMageCreator);
    }

    @Test
    public void WhenGottenAccountObjectToRegisterShouldInvokeAddingMethodOnAccountRepository () {
        Account accountToRegister = new Account("John","Superkick");
        service.registerAccount(accountToRegister);
        verify(mockAccountRepository,atLeastOnce()).save(accountToRegister);
    }
}
