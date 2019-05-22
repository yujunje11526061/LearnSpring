package initAndDestroy;

public class Bean2 {

    public void onInit(){
        System.out.println("Initializing");
    }

    public void onInit2(){
        System.out.println("Initializing by onInit2 method");
    }

    public void onDestroy(){
        System.out.println("Destroying");
    }

    public void onDestroy2(){
        System.out.println("Destroying by onDestroy2 method");
    }
}
