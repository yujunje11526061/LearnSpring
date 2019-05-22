package dataBinding;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlRoot")
public class XMLRoot {


    private String name;


    private int age;

    @Override
    public String toString() {
        return "XMLRoot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
