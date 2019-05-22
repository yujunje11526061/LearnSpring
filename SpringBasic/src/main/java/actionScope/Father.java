package actionScope;

public class Father {
    private Son son;

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    @Override
    public String toString() {
        return "self=" +super.toString()+
                "----> son=" + son;
    }
}
