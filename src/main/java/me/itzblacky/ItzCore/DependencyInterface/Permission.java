package me.itzblacky.ItzCore.DependencyInterface;

import me.itzblacky.ItzCore.DependencyInterface.Utils.IGroup;
import me.itzblacky.ItzCore.DependencyInterface.Utils.IUser;
import mindustry.gen.Player;

import java.util.LinkedList;
import java.util.List;


public interface Permission {

    IUser getUser(Player player);
    IUser getUser(String uuid);

    IGroup getGroup(String name);
    IGroup getGroup(int id);

    void addUser(IUser user);
    void addGroup(IGroup group);

    void reload();
    void save();
}
