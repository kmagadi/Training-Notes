class SharedResourse
{
    private int data;
    provate boolean available = false;

    synchronized void produce( int vlaue ) throws InterruptedEception
    {
        while( available )
        {
            wait();
        }
        data = value;
        available = true;
        System.out.println("Produced: " + data );
        notify();
    }

    synchronized void consume() throws InterruptedException
    {
        while( !available )
        {
            wait();
        }
        System.out.println("Consumed: " + data );
        available = false;
        notify();
    }
}