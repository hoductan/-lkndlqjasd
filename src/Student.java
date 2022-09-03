import java.io.*;

class Student implements Serializable{
    public String name;
    public int ID;
    public String dob;
    public String address;
    public Student(String name, int ID, String dob, String address) {
        this.name = name;
        this.ID = ID;
        this.dob = dob;
        this.address = address;
    }
    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

