package me.itzblacky.ItzCore.DependencyInterface.Utils;


import java.util.List;

public interface User {
    void setUUID(String uuid);
    void setGroup(IGroup group);
    void setPermission(String permission);
    void removePermission(String permission);

    String getUUID();
    List<String> getPermissions();
    List<IGroup> getGroups();
}
