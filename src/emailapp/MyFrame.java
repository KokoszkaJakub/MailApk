package emailapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private JButton btnInsert = new JButton("insert");


    private JTextField txtA = new JTextField();
    private JTextField txtB = new JTextField();
    private JTextField txtC = new JTextField();

    private JLabel lblA = new JLabel("first name :");
    private JLabel lblB = new JLabel("last name :");
    private JLabel lblC = new JLabel("phone number :");


    public MyFrame() {
        setTitle("Mail data insert");
        setSize(400, 200);
        setLocation(new Point(300, 200));
        setLayout(null);
        setResizable(false);

        initComponent();
        initEvent();
    }

    private void initComponent() {
        btnInsert.setBounds(300, 130, 80, 25);


        txtA.setBounds(140, 10, 150, 20);
        txtB.setBounds(140, 35, 150, 20);
        txtC.setBounds(140, 65, 150, 20);

        lblA.setBounds(20, 10, 100, 20);
        lblB.setBounds(20, 35, 100, 20);
        lblC.setBounds(20, 65, 100, 20);


        add(btnInsert);


        add(lblA);
        add(lblB);
        add(lblC);

        add(txtA);
        add(txtB);
        add(txtC);
    }

    private void initEvent() {

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                System.out.println("POWTÓRZ - podaj dane i nacinij insert");
                System.exit(1);
            }
        });

        btnInsert.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            firstName = txtA.getText();
                                            lastName = txtB.getText();
                                            phoneNumber = txtC.getText();
                                            System.exit(0);
                                        }


                                    }

        );


    }


}


