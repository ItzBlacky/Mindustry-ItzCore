package me.itzblacky.ItzCore.DependencyInterface.Utils;



public interface IUser {

    void setGroup(IGroup group);

    void setPermission(String permission);
    void removePermission(String permission);
    boolean hasPermission(String permission);

    String getUUID();
    IGroup getGroup();
}
