package Inheritance;

public class Main extends Temp{
    public static void main(String[] args) {
        Animal newAnimal = new Animal( 0, "orange" );

        System.out.println( newAnimal.getAge() );
        System.out.println( newAnimal.getColor() );
        newAnimal.getDetails();

        Cat cat = new Cat( 4, "orange" );

        System.out.println(cat.getAge());
        System.out.println(cat.getClass());
        System.out.println(cat.getColor());
        cat.getDetails(); // Static method inherited
        // Static methods cannot be overridden
        // Static methods do not follow runtime polymorphism( Method Overriding, 
        //      they always use reference type and it decides which method is called! )
        

    }
    Main()
    {
        super();
    }
}   

abstract class Temp
{

}