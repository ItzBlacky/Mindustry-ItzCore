package me.itzblacky.ItzCore.DependencyInterface;

import me.itzblacky.ItzCore.DependencyInterface.Utils.Group;
import mindustry.gen.Player;

import java.util.LinkedList;
import java.util.List;


public interface Permission {
    boolean hasPermission(Player player, String permission);
    boolean givePermission(Player player, String permission);
    List<String> getPermissions(Player player);
    boolean removePermission(Player player, String permission);
    boolean isInGroup(Player player);
    boolean addToGroup(Player player);
    List<String> getGroups(Player player);
    List<Group> getGroupList();
    LinkedList<Group> getOrderedGroupList();
}
