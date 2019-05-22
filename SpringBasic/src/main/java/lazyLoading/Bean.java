package lazyLoading;

public class Bean {
    private String name;
    public Bean(String name){
        this.name = name;
        System.out.println(name+" is being loaded.");
    }
}
