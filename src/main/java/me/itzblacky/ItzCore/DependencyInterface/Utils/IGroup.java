package me.itzblacky.ItzCore.DependencyInterface.Utils;

import mindustry.gen.Player;

import java.util.List;

public interface IGroup {

    boolean hasPermission(String permission);
    void givePermission(String permission);
    void removePermission(String permission);
    void addSubGroup(IGroup group);
    void removeSubGroup(IGroup group);

    List<String> getPermissions();
    List<IGroup> getSubGroups();
}
