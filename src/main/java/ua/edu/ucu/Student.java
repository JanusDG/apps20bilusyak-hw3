package ua.edu.ucu;


import java.util.Arrays;

class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object other){
        if (!(other instanceof Student)){return false;}
        Object[] st1 = {this.getName(), this.getSurname(), this.getGPA(), this.getYear()};
        Object[] st2 = {((Student)other).getName(), ((Student)other).getSurname(), ((Student)other).getGPA(), ((Student)other).getYear()};
        return (Arrays.equals(st1, st2));

    }
}
