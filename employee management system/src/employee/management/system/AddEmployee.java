package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel temp;

    JDateChooser tdob;

    JComboBox boxeducation;

    JButton add,back;


    AddEmployee(){

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(273,26,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(40,130,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(name);

        tname = new JTextField();
        tname.setBounds(170,130,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,130,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(550,130,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(40,190,150,35);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(170,190,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,190,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(550,190,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(40,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(170,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(550,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(40,310,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(email);

        temail = new JTextField();
        temail.setBounds(170,310,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(400,310,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(550,310,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(40,370,250,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(education);

        String items[] = {"BBA","B.TECH","BE","ME","BCA","MCA","MTECH","MSC"};
        boxeducation = new JComboBox(items);
        boxeducation.setBackground(new Color(177,252,197));
        boxeducation.setBounds(210,370,150,30);
        add(boxeducation);

        JLabel emp = new JLabel("Employee ID");
        emp.setBounds(40,430,250,30);
        emp.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(emp);

        temp = new JLabel(""+number);
        temp.setBounds(210,430,150,30);
        temp.setFont(new Font("SAN_SARIF",Font.BOLD,18));
        temp.setForeground(Color.RED);
        add(temp);


        JLabel design = new JLabel("Designation");
        design.setBounds(400,430,150,30);
        design.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(design);

        tdesignation = new JTextField();
        tdesignation.setBounds(550,430,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        add = new JButton("ADD");
        add.setBounds(420,505,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(220,505,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);




        setSize(820,620);
        setLayout(null);
        setLocation(200,45);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String aadhar = taadhar.getText();
            String emp = temp.getText();

            try {
                conn c = new conn();
                String query = "insert into employee values('" + name + "', '" + fname + "', '" + dob + "', '" + salary + "','" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "','" + aadhar + "', '" + emp + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main_class();

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            setVisible(false);
            new Main_class();
        }
    }


    public static void main(String[] args) {
        new AddEmployee();
    }
}
