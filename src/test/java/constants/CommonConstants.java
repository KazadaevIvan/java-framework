package constants;

import dto.User;
import enums.UserStatus;

public class CommonConstants {
    public static final String BASE_URI = "https://petstore.swagger.io/v2/";

    //test data
    public final static User DEFAULT_USER = User.builder()
            .username("username")
            .firstName("firstName")
            .lastName("lastName")
            .email("email")
            .password("password")
            .phone("phone")
            .userStatus(UserStatus.ACTIVE)
            .build();

    public static final User INVALID_USER = User.builder().build();
}
