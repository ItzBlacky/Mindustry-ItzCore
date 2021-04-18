package me.itzblacky.ItzCore.DependencyInterface.Utils;

import mindustry.gen.Player;

import java.util.List;

public interface IGroup {

    boolean hasPermission(String permission);
    void givePermission(String permission);
    boolean removePermission(String permission);
    void addSubGroups();

    List<String> getPermissions();
    List<IGroup> getSubGroups();
    List<Player> getMembers();
}
