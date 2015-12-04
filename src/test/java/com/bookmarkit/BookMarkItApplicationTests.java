package com.bookmarkit;

import com.bookmarkit.controller.UserController;
import com.bookmarkit.domain.Role;
import com.bookmarkit.domain.User;
import com.bookmarkit.form.UserCreateForm;
import com.bookmarkit.repository.UserRepository;
import com.bookmarkit.service.BookmarkSerivce;
import com.bookmarkit.service.UserService;
import com.bookmarkit.validator.UserCreateFormValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookMarkItApplication.class)
@WebAppConfiguration
@Transactional
@ActiveProfiles("testing")
public class BookMarkItApplicationTests {

    private final String BASE_URL = "http://localhost:8080/";

	@Autowired
	private UserService userService;

    @Autowired
    private UserCreateFormValidator userCreateFormValidator;

    @Autowired
    private BookmarkSerivce bookmarkSerivce;

    private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setup() {
        this.mockMvc = standaloneSetup(new UserController(userService, userCreateFormValidator, bookmarkSerivce)).build();

        UserCreateForm user = new UserCreateForm();
        user.setUsername("douglas");
        user.setEmail("dougamanzelmann@gmail.com");
        user.setPassword("password");
        user.setPasswordConfirmation("password");
        user.setRole(Role.USER);
        userService.create(user);
	}

    @Test
    public void canGetCreatedUser() throws Exception {
        this.mockMvc.perform(get("/users/1"))
                .andExpect(view().name("user/dashboard"));
                //.andExpect(model().attributeExists(""));
    }



}
