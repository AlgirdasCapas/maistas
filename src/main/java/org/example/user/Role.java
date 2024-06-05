package org.example.user;

public class Role {
    private int rolesId;
    private String role;

    public Role(int rolesId, String role) {
        this.rolesId = rolesId;
        this.role = role;
    }

    public Role(String role) {
        this.role = role;
    }

    public Role() {}

    public int getRolesId() {
        return rolesId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return "RoleImpl{" +
                "rolesId=" + rolesId +
                ", role='" + role + '\'' +
                '}';
    }
}
