import java.io.*;
import java.util.ArrayList;

public class file {
    public static void main(String[] args) {
    }

    public static  ArrayList<Student> readObjectFromFile() throws IOException, ClassNotFoundException {
        File inFile = new File("input.txt");
        FileInputStream inputStream = new FileInputStream(inFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ArrayList<Student> myStudentList = new ArrayList<>();
        boolean keepReading = true;
        try {
            while(keepReading) {
                Student myStudent = (Student)objectInputStream.readObject();
                myStudentList.add(myStudent);
            }
        }catch(EOFException e) {
            keepReading = false;
        }
        return myStudentList;
    }
    public static void writeObjectToFile(ArrayList<Student> myStudentList)throws IOException {
        File outFile = new File("input.txt");
        FileOutputStream outputStream = new FileOutputStream(outFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        for (Student student:myStudentList) {
             objectOutputStream.writeObject(student);
        }
        outputStream.close();
    }
};

//        myStudent = (Student)objectInputStream.readObject();
//        myStudentList.add(myStudent);
//        myStudent = (Student)objectInputStream.readObject();
//        myStudentList.add(myStudent);

//        for(Student student:myStudentList){
//            System.out.println(student.toString());
//        }
//        Student myStudent1 = new Student("Arthur", 2019 , "02/05/2002", "New York");
//
//        myStudentList.set(0,myStudent1);
//        Student myStudent2 = new Student("Tan", 201912 , "02/05/2001", "Mexico");
//        Student myStudent3 = new Student("Simon", 201919 , "02/05/2000", "Tel Aviv");
//        objectOutputStream.writeObject(myStudent1);
//        objectOutputStream.writeObject(myStudent2);
//        objectOutputStream.writeObject(myStudent3);