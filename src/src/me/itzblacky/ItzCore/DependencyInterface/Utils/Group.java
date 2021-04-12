package me.itzblacky.ItzCore.DependencyInterface.Utils;

import mindustry.gen.Player;

import java.util.List;

public interface Group {
    boolean hasPermission(String permission);
    boolean givePermission(String permission);
    boolean removePermission(String permission);
    List<String> getPermissions();
    List<Group> getSuperGroups();
    List<Group> getSubGroups();
    List<Player> getMembers();
}
