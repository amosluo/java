package com.amos.returnJson;

public class Permission {
    private String permissionId;

    public Permission(String module) {
        this.permissionId = module;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }


    @Override
    public String toString() {
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                '}';
    }
}
