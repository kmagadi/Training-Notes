public class Animal implements Notification {
    public static void main(String[] args) {
 
        System.out.println("Animal class main method");
 
        Animal a = new Animal();
        a.smsNotification();
 
        a.count();//calling the default method
        // a.config is not possible as it is static and can be called by the interface name only
        Notification.config();
        a.config();
        Cat c = new Cat(0, null);
        c.walk();
 
    }
 
    void config(){
        System.out.println("config of animial");
    }
 
    public void count(){
        System.out.println("overriding the df mthd");
    }
 
    // @Override
    public void smsNotification() {
        System.out.println("implementation of the smsNotification method");
    }
}