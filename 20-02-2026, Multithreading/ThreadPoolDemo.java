import java.util.concurrent.*;

public class ThreadPoolDemo
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable runnableTask = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is executing a Runnable task (void)");
        };

        Callable<String> callableTask = () -> {
            String name = Thread.currentThread().getName();
            Thread.sleep(1000); // Simulate some work
            return name + " finished the Callable task and returned this string!";
        };

        //executor.execute(runnableTask);

        Future futureResultRun = executor.submit(runnableTask);
        Future< String > futureResult = executor.submit( callableTask );

        try
        {
            System.out.println("Main thread waiting for Callable result...");
            String result = futureResult.get();
            System.out.println("Result: " + result);
        }
        catch ( InterruptedException | ExecutionException e )
        {
            e.printStackTrace();
        }
        finally
        {
            executor.shutdown();
        }
    }
}