package me.itzblacky.ItzCore.DependencyInterface.Utils;

import java.util.List;

public interface IGroup {

    boolean hasPermission(String permission);
    void setPermission(String permission);
    void removePermission(String permission);

    void addSubGroup(IGroup group);
    void removeSubGroup(IGroup group);

    String getName();
    List<IGroup> getSubGroups();
}
