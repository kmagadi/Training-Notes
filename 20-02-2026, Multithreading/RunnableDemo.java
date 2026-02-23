class RunnableDemo implements Runnable
{
    public void run()
    {
        System.out.println("Runnable running");
    }

    public static void main(String[] args) {
        RunnableDemo newRunnableThread = new RunnableDemo();
        newRunnableThread.run();
    }
}