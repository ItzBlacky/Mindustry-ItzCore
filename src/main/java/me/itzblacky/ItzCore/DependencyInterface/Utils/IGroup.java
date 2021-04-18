package me.itzblacky.ItzCore.DependencyInterface.Utils;

import mindustry.gen.Player;

import java.util.List;

public interface IGroup {

    boolean hasPermission(String permission);
    void givePermission(String permission);
    void removePermission(String permission);
    void addSubGroups(IGroup group);

    List<String> getPermissions();
    List<IGroup> getSubGroups();
    List<Player> getMembers();
}
