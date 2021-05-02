package me.itzblacky.ItzCore.DependencyInterface.Utils;

import java.util.List;

public interface IGroup {

    boolean hasPermission(String permission);
    void setPermission(String permission);
    void removePermission(String permission);

    void setSubGroup(IGroup group);

    String getName();
    IGroup getSubGroup();
    List<String> getPermissions();
}
