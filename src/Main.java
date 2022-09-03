import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> myStudentList =new ArrayList<>();
        try{
            myStudentList=file.readObjectFromFile();
            //file.writeObjectToFile(myStudentList);
        }catch(IOException e){
            System.out.println(e.getClass()+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getClass()+e.getMessage());
        }
        //aa
     GUI a = new GUI(myStudentList);
    return;

    }
}