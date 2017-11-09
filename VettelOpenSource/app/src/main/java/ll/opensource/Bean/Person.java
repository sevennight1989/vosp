package ll.opensource.Bean;

/**
 * Created by Percy on 11-2 0002.
 */

public class Person {
    private String name;
    private String age;

    @Override
    public String toString() {
        return "Person{" +
        "name='" + name + '\'' +
        ", age='" + age + '\'' +
        '}';
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
