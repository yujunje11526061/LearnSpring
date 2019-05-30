package dynamicProxy;

public class RealObject implements IObject {
    @Override
    public void doSomething() {
        System.out.println("Real Object is doing something.");
    }
}
