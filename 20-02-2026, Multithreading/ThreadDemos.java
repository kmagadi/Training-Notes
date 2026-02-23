public class ThreadDemos
{
    public static void main(String[] args)
    {
        A obj = new A();
        A obj1 = new A();

        Thread t1 = new Thread(() -> obj.show(), "Worker-Thread");
        Thread t2 = new Thread(() -> obj.show(), "Second-Worker-Thread");


        t1.start();
        obj.show();
//        t2.start();
//        obj1.show();
    }
}

class A
{
    public static void show()
    {
        for( int i = 0; i < 5; i++ )
        {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is printing: " + i);
        }
    }
}