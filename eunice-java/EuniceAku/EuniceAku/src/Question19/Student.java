package Question19;

public class Student {
    public String name;
    public int age;
    public String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
        setName("unknown");
        setAge(0);
        setAddress("not available");
    }

    public void setInfo(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setInfo(String name, int age, String address) {
        setName(name);
        setAge(age);
        setAddress(address);
    }
}
