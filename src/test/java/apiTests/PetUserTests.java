package apiTests;

import controllers.UserController;
import dto.UserResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constants.CommonConstants.DEFAULT_USER;

public class PetUserTests {
    UserController userController = new UserController();

    @Test
    void createUser() {
        Response response = userController.createUser(DEFAULT_USER);

        response.body().prettyPrint();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void checkUserResponseBody() {
        Response response = userController.createUser(DEFAULT_USER);

        response.body().prettyPrint();

        UserResponse createdUser = response.as(UserResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, createdUser.getCode());
        Assertions.assertEquals("unknown", createdUser.getType());
        Assertions.assertFalse(createdUser.getMessage().isEmpty());
    }

    //TODO:
    // tests for
    // *PUT - update user
    // *GET - fetch user by username
    // *DELETE - remove user from system
}
