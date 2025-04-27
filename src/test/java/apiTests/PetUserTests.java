package apiTests;

import controllers.UserController;
import dto.User;
import dto.UserResponse;
import enums.UserStatus;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PetUserTests {
    @Test
    void createUser() {
        User user = new User(0, "string", "string", "string", "string", "string", "string", UserStatus.ACTIVE);

        UserController userController = new UserController();
        Response response = userController.createUser(user);

        response.body().prettyPrint();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void checkUserResponseBody() {
        User user = new User(0, "string", "string", "string", "string", "string", "string", UserStatus.ACTIVE);

        UserController userController = new UserController();
        Response response = userController.createUser(user);

        response.body().prettyPrint();

        UserResponse createdUser = response.as(UserResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, createdUser.getCode());
        Assertions.assertEquals("unknown", createdUser.getType());
        Assertions.assertTrue(Long.parseLong(createdUser.getMessage()) > 1713978314113L);
    }

    //TODO:
    // tests for
    // *PUT - update user
    // *GET - fetch user by username
    // *DELETE - remove user from system
}
