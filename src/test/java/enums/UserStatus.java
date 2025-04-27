package enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStatus {
    ACTIVE(0),
    INACTIVE(1),
    SUSPENDED(2),
    ;

    private final int code;

    UserStatus(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
