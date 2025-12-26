package work015;

import java.util.UUID;

public class Student {
    private String firstName;
    private String lastName;
    private String city;
    private String course;
    private int age;
    private final UUID id;

    public Student(String firstName, String lastName, String city, String course, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.course = course;
        this.age = age;
        this.id = UUID.randomUUID();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getCourse() {
        return course;
    }

    public int getAge() {
        return age;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", course='" + course + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}