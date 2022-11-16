package ua.kiev.prog.shared;

import ua.kiev.prog.case2.ClientDAOImpl2;

import java.util.Date;

public class Client {
    @Id
    private int id;

    private String name;
    private int age;
    private Date date;
    private double a;


    public Client(String name, int age, Date date, double a) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.a = a;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", a=" + a +
                '}';
    }


}
