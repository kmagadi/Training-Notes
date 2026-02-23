class Animal
{
    public static void main(String[] args) {
        System.out.println("Animal class main method");
    }
    public void makeSound()
    {
        System.out.println("Animal makes sound!!" );
    }
}    

class Cat extends Animal
{
    int age;
    String color;

    Cat( int age, String color )
    {
        this.age = age;
        this.color = color;
    }

    private void meow()
    {
        System.out.println("meow");
    }

    public void walk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'walk'");
    }
}

public class Main extends Animal
{
    public static void main(String[] args) 
    {
        Animal.main( args );
        System.out.println("Hello World");
        Cat cat = new Cat( 2, "Orange" );
        cat.makeSound();
        // cat.meow();
    }
}