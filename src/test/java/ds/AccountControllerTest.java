package ds;

import ds.account.Account;
import ds.account.AccountContoller;
import ds.account.AccountControllerImpl;
import ds.account.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * Created by Damian on 21.08.2017.
 */
public class AccountControllerTest {

    private AccountServiceImpl mockService;
    private AccountContoller accountController;
    private MockMvc mockMvc;

    @Before
    public void setUpMocksAndController() {
        mockService = mock(AccountServiceImpl.class);
        accountController = new AccountControllerImpl(mockService);
        mockMvc = standaloneSetup(accountController).build();
    }

    @Test
    public void OnRegisteringNewAccountShouldRedirectAccountObjectToAccountService () throws Exception {
        mockMvc.perform(post("/account/register")
                .param("username","John")
                .param("password","superKick"));

        Account expectedAccCreated = new Account("John","superKick");

        verify(mockService, atLeastOnce()).registerAccount(expectedAccCreated);
    }

    @Test
    public void OnRegisteringNewAccountShouldReturnHomeView () throws Exception {
        mockMvc.perform(post("/account/register")
                .param("username","whatever")
                .param("password","some")).andExpect(view().name("login"));
    }
}
