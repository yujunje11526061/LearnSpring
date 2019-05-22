package injection;

public class Bean {

    private AnotherBean anotherBean1;
    private AnotherBean anotherBean2;
    private String string1;
    private String string2;

    public Bean(AnotherBean anotherBean1, String string1) {
        this.anotherBean1 = anotherBean1;
        this.string1 = string1;
    }

    public String toString1(){
        return anotherBean1+"------>"+string1;
    }

    public String toString2(){
        return anotherBean2+"------>"+string2;
    }


    public void setAnotherBean2(AnotherBean anotherBean2) {
        this.anotherBean2 = anotherBean2;
    }

    public AnotherBean getAnotherBean2(){
        return this.anotherBean2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getString2(){
        return string2;
    }

    public String toString3() {
        return null;
    }
}
