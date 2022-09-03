import javax.swing.*;
import java.util.ArrayList;

public class table {
    JFrame f;
    table(ArrayList<Student> myStudentList){
        f=new JFrame();
        String[][] data= new String[myStudentList.size()][4];
        for (int i = 0; i < myStudentList.size(); i++) {
            data[i][0]=String.valueOf(myStudentList.get(i).ID);
            data[i][1]=myStudentList.get(i).name;
            data[i][2]=myStudentList.get(i).address;
            data[i][3]=myStudentList.get(i).dob;
        }
        String column[]={"ID","Full Name","Address","Day of Birth"};
        JTable jt=new JTable(data,column);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(500,700);
        f.setVisible(true);
        f.setTitle("List of Students");

    }

}  