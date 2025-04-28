package apiTests;

import controllers.UserController;
import dto.User;
import dto.UserResponse;
import factories.UserFactory;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static constants.CommonConstants.SKIP_CLEANUP_TAG;

public class PetUserTests {

    private static final UserController userController = new UserController();
    private User user;

    @BeforeEach
    void setup() {
        user = UserFactory.createValidUser();
        Response response = userController.createUser(user);
        Assertions.assertEquals(200, response.statusCode());
    }

    @AfterEach
    void cleanup(TestInfo testInfo) {
        if(testInfo.getTags().contains(SKIP_CLEANUP_TAG)) {
            return;
        }
        userController.deleteUserByUsername(user.getUsername());
    }

    @Test
    void checkUserCanBeUpdated() {
        user.setFirstName("Petr");

        Response updateResponse = userController.updateUser(user);
        UserResponse updateUser = updateResponse.as(UserResponse.class);

        Assertions.assertEquals(200, updateResponse.statusCode());
        Assertions.assertEquals(200, updateUser.getCode());
        Assertions.assertEquals("unknown", updateUser.getType());
        Assertions.assertFalse(updateUser.getMessage().isEmpty());

        Response fetchResponse = userController.getUserByUsername(user.getUsername());
        Assertions.assertEquals(user, fetchResponse.body().as(User.class));
    }

    @Test
    void checkUserCanBeFetchedByUsername() {
        Response fetchResponse = userController.getUserByUsername(user.getUsername());

        Assertions.assertEquals(200, fetchResponse.statusCode());
        Assertions.assertEquals(user, fetchResponse.body().as(User.class));
    }

    @Test
    @Tag(SKIP_CLEANUP_TAG)
    void checkUserCanBeDeleted() {
        Response deleteResponse = userController.deleteUserByUsername(user.getUsername());
        UserResponse deletedUser = deleteResponse.as(UserResponse.class);

        Assertions.assertEquals(200, deleteResponse.statusCode());
        Assertions.assertEquals(200, deletedUser.getCode());
        Assertions.assertEquals("unknown", deletedUser.getType());
        Assertions.assertEquals(user.getUsername(), deletedUser.getMessage());

        Response fetchAfterDeleteResponse = userController.getUserByUsername(user.getUsername());
        Assertions.assertEquals(404, fetchAfterDeleteResponse.statusCode());
    }
}
