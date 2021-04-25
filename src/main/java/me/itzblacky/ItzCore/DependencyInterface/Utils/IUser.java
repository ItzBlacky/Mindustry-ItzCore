package me.itzblacky.ItzCore.DependencyInterface.Utils;



public interface IUser {

    void setUUID(String uuid);
    void setGroup(IGroup group);
    void setGroup(String name);

    void setPermission(String permission);
    void removePermission(String permission);
    boolean hasPermission(String permission);

    String getUUID();
    IGroup getGroup();
}
