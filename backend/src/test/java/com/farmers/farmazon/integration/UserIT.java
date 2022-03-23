//package com.farmers.farmazon.integration;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.farmers.farmazon.Models.User;
//import com.farmers.farmazon.Repos.UserRepo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//// Tells spring boot which profile to use.
//@TestPropertySource (
//    locations = "classpath:application-it.properties"
//)
//// Needed to get everything configured correctly.
//@AutoConfigureMockMvc
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//// This will tell hibernate to remove your database between EACH test.
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//@ActiveProfiles("test") // This means our test is using the Test profile.
//public class UserIT {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  @Autowired
//  private UserRepo UserRepo;
//
//  @Autowired
//  private ObjectMapper objectMapper;
//
//  @BeforeEach
//  public void setup() {
//    User newUser = new User();
//    newUser.setName("Paddington");
//    newUser.setPlatformCount(16);
//    newUser.setDateOpened(LocalDate.parse("1954-05-29"));
//
//    User newUser2 = new User();
//    newUser2.setName("Oxford Circus");
//    newUser2.setPlatformCount(16);
//    newUser2.setDateOpened(LocalDate.parse("1954-05-29"));
//
//    UserRepo.saveAll(List.of(newUser, newUser2));
//  }
//
//
//  // Hello world junit
//  @Test
//  public void helloWorld_ReturnString_Success() throws Exception {
//    // ! when (given some conditions / we have a particular request)
//    // Request builder lets you build requests.
//    RequestBuilder request = MockMvcRequestBuilders.get("/hello");
//
//    // ! given (we take some action / make that request)
//    ResultActions resultActions = mockMvc.perform(request);
//
//    // ! then (whats the result)
//    // The result variable contains our content (Hello World!)
//    MvcResult result = resultActions
//        .andExpect(status().isOk()) // Check is the response ok (a 200)
//        .andReturn();
//
//    String actual = result.getResponse().getContentAsString();
//    String expected = "Hello World!";
//    assertEquals(expected, actual);
//  }
//
//  @Test
//  public void getUsers_ReturnsUsers_Success() throws Exception {
//    RequestBuilder request = MockMvcRequestBuilders.get("/Users");
//
//    ResultActions resultActions = mockMvc.perform(request);
//
//    MvcResult result = resultActions
//        .andExpect(status().isOk())
//        // ! jsonPath lets you query json data.
//        // ! The $ symbol starts from the top of our json response.
//        .andExpect(jsonPath("$[0].id").value(1))
//        .andExpect(jsonPath("$[0].name").value("Paddington"))
//        .andExpect(jsonPath("$[1].id").value(2))
//        .andReturn();
//
//    System.out.println(result.getResponse().getContentAsString());
//  }
//
//  @Test
//  public void postUser_ReturnsUser_Success() throws Exception {
//    // given
//    User User = new User();
//    User.setName("Angel");
//    User.setDateOpened(LocalDate.parse("1901-11-17"));
//    User.setPlatformCount(2);
//
//    RequestBuilder request = MockMvcRequestBuilders
//        .post("/Users")
//        // Say its json data:
//        .contentType(MediaType.APPLICATION_JSON)
//        // Turn my User into a json string:
//        .content(objectMapper.writeValueAsString(User));
//
//    // when
//    ResultActions resultActions = mockMvc.perform(request);
//
//    // then
//    resultActions
//        .andExpect(status().isOk())
//        .andExpect(jsonPath("$.id").value(3));
//
//    // We could also check the repo too..
//    List<User> Users = (List<User>) UserRepo.findAll();
//    assertEquals(3, Users.size());
//  }
//
//  @Test
//  public void getUser_ReturnsException_NotFound() throws Exception {
//    // given
//    RequestBuilder request = MockMvcRequestBuilders
//        .get("/Users/3");
//
//    // when
//    ResultActions resultActions = mockMvc.perform(request);
//
//    // then
//    resultActions
//        .andExpect(status().isNotFound());
//
//    // ? We will use this when it comes to unit testing.
//    // assertThrows(
//    //   // ! then
//    //   // First argument: exception class
//    //   ResponseStatusException.class,
//    //   // ! when
//    //   // Second argument: lambda to run some code
//    //     () -> {
//    //
//    //     }
//    // );
//  }
//
//
//
//
//}
