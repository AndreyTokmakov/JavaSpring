package mongodb_tests.devices;

import lombok.Getter;

@Getter
public enum RoleType
{
    Drone("drone"),
    GSM("gsm"),
    Sleeve("sleeve");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }
}
