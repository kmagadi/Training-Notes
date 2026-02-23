public interface Notification {
    public void smsNotification();
 
    // concerte mthds also posdsible in interface
    default void count(){
        System.out.println("inside the default mthd");
    };
 
    static void config(){
        System.out.println("inside the static mthd");
    }  
}