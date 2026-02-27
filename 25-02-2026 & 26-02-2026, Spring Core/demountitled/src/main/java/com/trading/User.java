package com.trading;

public class User
{
    private String name;
    private String id;
    private String location;

    User(String name, String id, String location )
    {
        this.name = name;
        this.id = id;
        this.location = location;
    }
    //User(){}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
