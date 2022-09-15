//import javax.swing.*;
//import java.awt.*;
//public class testgui{
//    public static void main(String[] args){
//        JFrame jFrame= new JFrame();
//        jFrame.setVisible(true);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        Container myPanel =jFrame.getContentPane();
//        jFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
//        jFrame.setSize(new Dimension(400,400));
//        jFrame.setLocation(300,300);
//        myPanel.setLayout(new FlowLayout());
//        JButton ok= new JButton();
//
//
//    }
//}

import java.awt.*;
import java.io.IOException;
import java.awt.event.*;

import java.util.ArrayList;
import javax.swing.*;

public class GUI {
    Label l1;
    private int pointer = -1;
    private ArrayList<Student> myStudentList;
    private JFrame frame;
    private JTextField searchTF;

    private JTextField stuNameTF;
    private JTextField stuIDTF;
    private JTextField addressTF;
    private JTextField stuDobTF;
    private JButton nextBtn;
    private JButton previousBtn;
    private JButton addBtn;
    private JButton updateBtn;
    private JButton saveBtn;
    private JButton deleteBtn;
    private JButton clearBtn;
    public JButton viewBtn;
    private JButton test;
    private table tb ;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    GUI window = new GUI();
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    /**
     * Create the application.
     */
    public GUI(ArrayList<Student> tempo) {
        myStudentList = tempo;
        tb= new table(myStudentList);
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * Sets all of the components and linked to an action listener that handles the control
     */
    private void initialize() {
        pointer = 0;
        frame = new JFrame();
        frame.setBounds(300, 300, 570, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel seach = new JLabel("Search");
        seach.setBounds(50, 5, 96, 16);
        frame.getContentPane().add(seach);
        seach.setFont(new Font("", Font.BOLD, 20));


        searchTF = new JTextField();
        searchTF.setBounds(140, 1, 376, 30);
        searchTF.setColumns(10);
        searchTF.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(searchTF);

        JLabel stunameLbl = new JLabel("Full Name");
        stunameLbl.setBounds(38, 68, 96, 16);
        frame.getContentPane().add(stunameLbl);

        stuNameTF = new JTextField();
        stuNameTF.setBounds(141, 65, 376, 22);
        stuNameTF.setColumns(10);
        frame.getContentPane().add(stuNameTF);

        JLabel stuIDLbl = new JLabel("Student ID");
        stuIDLbl.setBounds(38, 39, 96, 16);
        frame.getContentPane().add(stuIDLbl);

        stuIDTF = new JTextField();
        stuIDTF.setBounds(141, 36, 376, 22);
        stuIDTF.setColumns(10);
        frame.getContentPane().add(stuIDTF);

        JLabel addressLbl = new JLabel("Address");
        addressLbl.setBounds(38, 97, 96, 16);
        frame.getContentPane().add(addressLbl);

        addressTF = new JTextField();
        addressTF.setBounds(141, 94, 376, 22);
        addressTF.setColumns(10);
        frame.getContentPane().add(addressTF);

        JLabel companyLbl = new JLabel("Day of Birth");
        companyLbl.setBounds(38, 126, 96, 16);
        frame.getContentPane().add(companyLbl);

        stuDobTF = new JTextField();
        stuDobTF.setBounds(141, 123, 376, 22);
        stuDobTF.setColumns(10);
        frame.getContentPane().add(stuDobTF);

        nextBtn = new JButton(">");
        nextBtn.setForeground(Color.BLUE);
        nextBtn.setBounds(289, 191, 125, 25);
        frame.getContentPane().add(nextBtn);

        previousBtn = new JButton("<");
        previousBtn.setForeground(Color.BLUE);
        previousBtn.setBounds(152, 191, 125, 25);
        frame.getContentPane().add(previousBtn);

        addBtn = new JButton("ADD");
        addBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
        addBtn.setBounds(15, 228, 173, 25);
        frame.getContentPane().add(addBtn);

//UPDATE
        updateBtn = new JButton("UPDATE");
        updateBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
        updateBtn.setBounds(200, 228, 166, 25);
        frame.getContentPane().add(updateBtn);
        updateBtn.setEnabled(false);

        saveBtn = new JButton("Save");
        saveBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
        saveBtn.setBounds(200, 228, 166, 25);
        saveBtn.setForeground(Color.decode("#08A84B"));
        frame.getContentPane().add(saveBtn);
        saveBtn.setVisible(false);

//
        deleteBtn = new JButton("DELETE");
        deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
        deleteBtn.setBounds(378, 228, 173, 25);
        deleteBtn.setForeground(Color.red);
        frame.getContentPane().add(deleteBtn);
        deleteBtn.setEnabled(false);


        clearBtn = new JButton("CLEAR");
        clearBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
//        clearBtn.setForeground(Color.BLUE);
        clearBtn.setBounds(15, 191, 125, 25);
        frame.getContentPane().add(clearBtn);

        viewBtn = new JButton("View All");
        viewBtn.setForeground(Color.BLUE);
        viewBtn.setBounds(426, 191, 125, 25);
        frame.getContentPane().add(viewBtn);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Student Management");

        JLabel l1 = new JLabel();
        l1.setBounds(220, 300, 300, 16);
        l1.setForeground(Color.decode("#08A84B"));

        frame.getContentPane().add(l1);
//        addBtn.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e) {
//                custIdLbl.setText("testing");
//            }
//        });
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pointer++;
                if (pointer >= myStudentList.size() || pointer <= -1) pointer = 0;
                Student tempo = myStudentList.get(pointer);
                stuNameTF.setText(tempo.name);
                stuIDTF.setText(String.valueOf(tempo.ID));
                stuDobTF.setText(tempo.dob);
                addressTF.setText(tempo.address);
                stuNameTF.setEditable(false);
                stuIDTF.setEditable(false);
                stuDobTF.setEditable(false);
                addressTF.setEditable(false);
                updateBtn.setEnabled(true);
                addBtn.setEnabled(false);
                deleteBtn.setEnabled(true);

                l1.setText("");
            }

        });

        previousBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pointer--;
                if (pointer <= -1 || pointer >= myStudentList.size()) pointer = myStudentList.size() - 1;
                Student tempo = myStudentList.get(pointer);
                stuNameTF.setText(tempo.name);
                stuIDTF.setText(String.valueOf(tempo.ID));
                stuDobTF.setText(tempo.dob);
                addressTF.setText(tempo.address);
                stuNameTF.setEditable(false);
                stuIDTF.setEditable(false);
                stuDobTF.setEditable(false);
                addressTF.setEditable(false);
                updateBtn.setEnabled(true);
                addBtn.setEnabled(false);
                deleteBtn.setEnabled(true);
                l1.setText("");
            }
        });
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextBtn.setEnabled(true);
                previousBtn.setEnabled(true);
                stuNameTF.setText("");
                stuIDTF.setText("");
                stuDobTF.setText("");
                addressTF.setText("");
                stuNameTF.setEditable(true);
                stuIDTF.setEditable(true);
                stuDobTF.setEditable(true);
                addressTF.setEditable(true);
                updateBtn.setEnabled(false);
                addBtn.setEnabled(true);
                deleteBtn.setEnabled(false);
                searchTF.setText("");
                l1.setText("");
            }
        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l1.setText("");
                Student student = new Student();
                try {
                    student.name = stuNameTF.getText();
                    student.dob = stuDobTF.getText();
                    student.address = addressTF.getText();
                    if (student.address.isEmpty() || student.dob.isEmpty() || student.name.isEmpty())
                        throw new IOException("Please fill in all the fields");
                    student.ID = Integer.parseInt(stuIDTF.getText());
                } catch (IOException a) {
                    // System.out.println(a);
                    JOptionPane.showMessageDialog(
                            null, a.getMessage(),
                            "Oops! Something went wrong.", JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (Exception b) {
                    // System.out.println(a);
                    JOptionPane.showMessageDialog(
                            null, "ID field must be a number",
                            "Oops! Something went wrong.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (myStudentList != null) {
                    for (Student stu : myStudentList) {
                        if (Integer.parseInt(stuIDTF.getText()) == stu.ID) {
                            JOptionPane.showMessageDialog(
                                    null, "ID number already exists",
                                    null, JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
                myStudentList.add(student);
                l1.setText("Added");
                try {
                    file.writeObjectToFile(myStudentList);
                } catch (Exception a) {
                    System.out.println("loi ghi file");
                }
                viewBtn.doClick();
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextBtn.setEnabled(false);
                previousBtn.setEnabled(false);
                updateBtn.setVisible(false);
                saveBtn.setVisible(true);
                stuNameTF.setEditable(true);
                // stuIDTF.setEditable(true);
                stuDobTF.setEditable(true);
                addressTF.setEditable(true);
                updateBtn.setEnabled(false);
                addBtn.setEnabled(false);
                clearBtn.setEnabled(false);
                deleteBtn.setEnabled(false);
                l1.setText("You are in Edit mode!");
                EventQueue.invokeLater( () -> stuNameTF.requestFocusInWindow() );

            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                try {
                    student.name = stuNameTF.getText();
                    student.dob = stuDobTF.getText();
                    student.address = addressTF.getText();
                    if (student.address.isEmpty() || student.dob.isEmpty() || student.name.isEmpty())
                        throw new IOException("Please fill in all the fields");
                    student.ID = myStudentList.get(pointer).ID;
                } catch (IOException a) {
                    // System.out.println(a);
                    JOptionPane.showMessageDialog(
                            null, a.getMessage(),
                            "Oops! Something went wrong.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                myStudentList.set(pointer, student);
                try {
                    file.writeObjectToFile(myStudentList);
                } catch (Exception a) {
                    System.out.println("loi ghi file");
                }
                nextBtn.setEnabled(true);
                previousBtn.setEnabled(true);
                updateBtn.setVisible(true);
                saveBtn.setVisible(false);
                stuNameTF.setEditable(false);
                // stuIDTF.setEditable(true);
                stuDobTF.setEditable(false);
                addressTF.setEditable(false);
                updateBtn.setEnabled(true);
                addBtn.setEnabled(false);
                clearBtn.setEnabled(true);
                deleteBtn.setEnabled(true);
                l1.setText("Edited");
                viewBtn.doClick();
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // stuIDTF.setEditable(true);

                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete?", "Select an Option...",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (input == 0) {
                    myStudentList.remove(pointer);
                    try {
                        file.writeObjectToFile(myStudentList);
                    } catch (Exception a) {
                        System.out.println("loi ghi file");
                    }
                    pointer--;
                    nextBtn.doClick();
                    viewBtn.doClick();
                }
            }
        });

        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tb.dispose();
                tb = new table(myStudentList);
            }
        });
        searchTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempo= searchTF.getText();
                clearBtn.doClick();
             //   System.out.println(tempo);
                try {

                    if (tempo.isEmpty() )
                        throw new IOException("Please enter Student ID or Student's Name");
                } catch (IOException a) {
                    // System.out.println(a);
                    JOptionPane.showMessageDialog(
                            null, a.getMessage(),
                            "Oops! Something went wrong.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                for (int i = 0; i < myStudentList.size(); i++)
//                    if(tempo.equalsIgnoreCase(myStudentList.get(i).name) || tempo.equalsIgnoreCase(String.valueOf(myStudentList.get(i).ID)))
                    if(myStudentList.get(i).name.toLowerCase().contains(tempo.toLowerCase()) || String.valueOf(myStudentList.get(i).ID).toLowerCase().contains(tempo.toLowerCase()))
                    {
                        pointer=i-1;
                        nextBtn.doClick();
                        return;
                    }
                l1.setText("NOTHING FOUND");
            }
        });
        // nextBtn.doClick();
        frame.setVisible(true);


    }

}
