package dynamicProxy;

public class ProxyObject implements IObject {
    private IObject realObject;

    public ProxyObject(IObject realObject) {
        this.realObject = realObject;
    }

    @Override
    public void doSomething() {
        System.out.println("Before...");
        realObject.doSomething();
        System.out.println("After...");
    }
}
