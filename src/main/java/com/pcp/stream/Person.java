package com.pcp.stream;

public class Person {

    private String name;
    private int age;
    private String gender;
    private double income;
    private String city;

    public Person(String name, int age, String gender, double income, String city) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.income = income;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getIncome() {
        return income;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", income=" + income +
                ", city='" + city + '\'' +
                '}';
    }
}
