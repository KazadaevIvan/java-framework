package factories;

import dto.User;

import com.github.javafaker.Faker;
import enums.UserStatus;

public class UserFactory {

    public static User createValidUser() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        return User.builder()
                .id(System.currentTimeMillis())
                .username("user_" + faker.number().digits(5))
                .firstName(firstName)
                .lastName(lastName)
                .email(firstName + lastName + "@example.com")
                .password(faker.pokemon().name() + faker.number().randomNumber())
                .phone(faker.phoneNumber().subscriberNumber(9))
                .userStatus(UserStatus.ACTIVE)
                .build();
    }
}
