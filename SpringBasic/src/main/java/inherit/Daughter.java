package inherit;

public class Daughter extends Father{
    private String daughterAttr1;
    private String daughterAttr2;
    private String commonAttr1;
    private String commonAttr2;

    @Override
    public String toString() {
        return "Daughter{" +
                "daughterAttr1='" + daughterAttr1 + '\'' +
                ", daughterAttr2='" + daughterAttr2 + '\'' +
                ", fatherAttr1='" + getFatherAttr1() + '\'' +
                ", fatherAttr2='" + getFatherAttr2() + '\'' +
                ", commonAttr1='" + commonAttr1 + '\'' +
                ", commonAttr2='" + commonAttr2 + '\'' +
                '}';
    }

    public String getDaughterAttr1() {
        return daughterAttr1;
    }

    public void setDaughterAttr1(String daughterAttr1) {
        this.daughterAttr1 = daughterAttr1;
    }

    public String getDaughterAttr2() {
        return daughterAttr2;
    }

    public void setDaughterAttr2(String daughterAttr2) {
        this.daughterAttr2 = daughterAttr2;
    }

    public String getCommonAttr1() {
        return commonAttr1;
    }

    public void setCommonAttr1(String commonAttr1) {
        this.commonAttr1 = commonAttr1;
    }

    public String getCommonAttr2() {
        return commonAttr2;
    }

    public void setCommonAttr2(String commonAttr2) {
        this.commonAttr2 = commonAttr2;
    }
}
