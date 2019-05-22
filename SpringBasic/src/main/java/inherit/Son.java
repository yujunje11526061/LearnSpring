package inherit;

public class Son extends Father {
    private String sonAttr1;
    private String sonAttr2;
    private String commonAttr1;
    private String commonAttr2;

    @Override
    public String toString() {
        return "Son{" +
                "sonAttr1='" + sonAttr1 + '\'' +
                ", sonAttr2='" + sonAttr2 + '\'' +
                ", fatherAttr1='" + getFatherAttr1() + '\'' +
                ", fatherAttr2='" + getFatherAttr2() + '\'' +
                ", commonAttr1='" + commonAttr1 + '\'' +
                ", commonAttr2='" + commonAttr2 + '\'' +
                '}';
    }

    public String getSonAttr1() {
        return sonAttr1;
    }

    public void setSonAttr1(String sonAttr1) {
        this.sonAttr1 = sonAttr1;
    }

    public String getSonAttr2() {
        return sonAttr2;
    }

    public void setSonAttr2(String sonAttr2) {
        this.sonAttr2 = sonAttr2;
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
