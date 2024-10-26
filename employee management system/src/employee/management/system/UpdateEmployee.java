package employee.management.system;

import com.sun.tools.javac.Main;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField teducation, tfname, taddress,tphone, taadhar, temail, tsalary,tdesignation;
    JLabel temp;
    JButton add,back;
    String number;

    UpdateEmployee(String number){

        this.number = number;
        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(273,26,500,50);
        heading.setFont(new Font("serif", Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(40,125,150,30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(170,125,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,125,150,30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(550,125,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(40,170,150,30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(170,170,150,30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,170,150,30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(550,170,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(40,220,150,30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(address);

        taddress= new JTextField();
        taddress.setBounds(170,220,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);


        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,220,150,30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(phone);

        tphone= new JTextField();
        tphone.setBounds(550,220,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(40,290,150,30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(email);

        temail= new JTextField();
        temail.setBounds(170,290,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(40,350,200,30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(education);

        teducation= new JTextField();
        teducation.setBounds(250,350,150,30);
        teducation.setBackground(new Color(177,252,197));
        add(teducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(40,455,150,30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(aadhar);

        JLabel taadhar= new JLabel();
        taadhar.setBounds(210,455,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);


        JLabel emp = new JLabel("Employee ID");
        emp.setBounds(40,410,150,30);
        emp.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(emp);

        temp= new JLabel();
        temp.setBounds(210,410,150,30);
        temp.setFont(new Font("SAN_SARIF", Font.BOLD,17));
        temp.setForeground(Color.RED);
        add(temp);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(400,410,150,30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD,17));
        add(designation);

        tdesignation= new JTextField();
        tdesignation.setBounds(550,410,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        try {
            conn c = new conn();
            String query = "select * from employee where emp = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadhar.setText(resultSet.getString("aadhar"));
                temp.setText(resultSet.getString("emp"));
                tdesignation.setText(resultSet.getString("designation"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        add = new JButton("UPDATE");
        add.setBounds(420,505,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(220,505,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(820,620);
        setLayout(null);
        setLocation(200,45);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try {
                conn c = new conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where emp = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Main_class();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
