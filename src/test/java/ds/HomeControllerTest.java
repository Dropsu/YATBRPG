package ds;

import ds.account.AccountRepository;
import ds.config.Session;
import ds.home.HomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



/**
 * Created by Damian on 18.08.2017.
 */

@Configuration
public class HomeControllerTest {


    @Test
    public void homeControllerOnGetShouldReturnHomePage () throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    /*@Test
    public void homeControllerOnGetToLoginPageShouldReturnLoginPage () throws Exception {
       //TODO: Circular path problem with view resolver... to resolve
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/login")).andExpect(view().name("login"));
    }*/
}
