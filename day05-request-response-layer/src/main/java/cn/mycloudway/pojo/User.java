package cn.mycloudway.pojo;

import java.util.List;

public class User {
    private String name;
    private Integer age;
    private Address address;
    private List<String> hobby;

    public User() {
    }

    public User(String name, Integer age, Address address, List<String> hobby) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", hobby=" + hobby +
                '}';
    }
}
