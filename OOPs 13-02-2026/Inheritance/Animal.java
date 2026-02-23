package Inheritance;

public class Animal {
    int age;
    String color;

    // public Animal()
    // {
    //     age = 0;
    //     color = null;
    // }

    public Animal( int age, String color )
    {
        this.age = age;
        this.color = color;
    }

    public int getAge()
    {
        return age;
    }

    public String getColor()
    {
        return color;
    }

    public static void getDetails()
    {
        System.out.println("Animal Details : ");
    }
}
