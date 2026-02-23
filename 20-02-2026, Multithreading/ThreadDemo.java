class ThreadDemo extends Thread
{
    public void run()
    {
        System.out.println("Thread running");
    }

    public static void main(String[] args) {
        ThreadDemo newThred = new ThreadDemo();
        newThred.run();
    }
}