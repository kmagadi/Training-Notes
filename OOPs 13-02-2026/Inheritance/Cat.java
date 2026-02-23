package Inheritance;

public class Cat extends Animal {
    // Default constructor will be added by compiler( no-arguements )

    int age;
    String color;
    
    public Cat( int age, String color)
    {
        super( age, color );
    }

    // Method hiding
    public static void getDetails()
    {
        System.out.println("Cat Details: ");
    }
}