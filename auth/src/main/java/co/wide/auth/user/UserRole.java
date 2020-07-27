package co.wide.auth.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {

    PERSON("PERSON"),
    VIP("VIP"),
    TESTER("TESTER");

    private final String role;

}
