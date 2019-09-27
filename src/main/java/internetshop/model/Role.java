package internetshop.model;

import internetshop.idstorage.RoleIdGenerator;

public class Role {
    private final Long id;
    private RoleName roleName;

    public Role(RoleName roleName) {
        this();
        this.roleName = roleName;
    }

    public static Role of(String roleName) {
        return new Role(RoleName.valueOf(roleName));
    }

    public Long getId() {
        return id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public Role() {
        id = RoleIdGenerator.generateId();
    }

    public enum RoleName {

        USER, ADMIN
    }
}
