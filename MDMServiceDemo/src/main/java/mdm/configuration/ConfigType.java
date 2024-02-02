package mdm.configuration;

import lombok.Getter;

@Getter
public enum ConfigType {
    MeshConfig("mesh_conf"),
    Features("features"),
    DebugConfig("debug_conf");

    private final String value;

    ConfigType(String value) {
        this.value = value;
    }
}
