package me.itzblacky.ItzCore.DependencyInterface.Utils;


import java.util.List;

public interface IUser {
    void setUUID(String uuid);
    void setGroup(IGroup group);
    void setPermission(String permission);
    void removePermission(String permission);

    String getUUID();
    IGroup getGroup();
    List<String> getPermissions();
}
