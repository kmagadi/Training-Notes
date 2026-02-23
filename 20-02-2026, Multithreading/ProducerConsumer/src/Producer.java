public class Producer extends Thread
{
    private SharedResource resource;

    Producer( SharedResource resource )
    {
        this.resource = resource;
    }
    @Override
    public void run()
    {
        try
        {
            for( int i = 0; i <= 5; i++ )
            {
                resource.produce( i );
                Thread.sleep( 500 );
            }
        }
        catch ( InterruptedException e )
        {
            Thread.currentThread().interrupt();
        }
    }
}