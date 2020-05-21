package aut.utcluj.isp;

import aut.utcluj.isp.ex3.Employee;
import aut.utcluj.isp.ex3.EmployeeController;

import javax.swing.*;

public class Interface extends JFrame {
    private JFrame frame;
    private JPanel panel01;
    private EmployeeController employeeController;

    public Interface(EmployeeController employeeController) {
        this.employeeController = employeeController;

        frame = new JFrame("Employee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);

        createUI();

        frame.setVisible(true);
    }

    private void createUI() {
        panel01 = new JPanel();
        panel01.setLayout(null);

        JButton addEmployee = new JButton("Add employee");
        addEmployee.setBounds(280, 100, 150, 50);

        JButton getEmployee = new JButton("Get employee");
        getEmployee.setBounds(280, 170, 150, 50);

        JButton updateSlarry = new JButton("Update");
        updateSlarry.setBounds(280, 240, 150, 50);

        JButton deleteEmployee = new JButton("Delete");
        deleteEmployee.setBounds(280, 310, 150, 50);


        panel01.add(deleteEmployee);
        panel01.add(updateSlarry);
        panel01.add(addEmployee);
        panel01.add(getEmployee);
        frame.add(panel01);

        addEmployee.addActionListener(e -> buttonAddFunction());
        getEmployee.addActionListener(e -> buttonGetFunction());
        updateSlarry.addActionListener(e -> buttonUpdateFunctioN());
        deleteEmployee.addActionListener(e -> buttonDeleteFunction());
    }

    private void buttonAddFunction() {
        panel01.setVisible(false);

        JPanel panel02 = new JPanel();
        panel02.setLayout(null);

        JLabel textFristName = new JLabel("First name: ");
        textFristName.setBounds(230, 50, 150, 50);

        JTextField firstNameTF = new JTextField();
        firstNameTF.setBounds(330, 67, 150, 20);

        JLabel textLastName = new JLabel("Last name: ");
        textLastName.setBounds(230, 100, 150, 50);

        JTextField lastNameTF = new JTextField();
        lastNameTF.setBounds(330, 117, 150, 20);

        JLabel textCnp = new JLabel("Cnp: ");
        textCnp.setBounds(230, 150, 150, 50);

        JTextField cnpTF = new JTextField();
        cnpTF.setBounds(330, 167, 150, 20);

        JLabel textSalary = new JLabel("Salary: ");
        textSalary.setBounds(230, 200, 150, 50);

        JTextField salaryTF = new JTextField();
        salaryTF.setBounds(330, 217, 150, 20);

        JButton addEmployee = new JButton("Add");
        addEmployee.setBounds(315, 267, 100, 25);

        JButton backButton = new JButton("Back");
        backButton.setBounds(315, 317, 100, 25);

        panel02.add(backButton);
        panel02.add(addEmployee);
        panel02.add(salaryTF);
        panel02.add(textSalary);
        panel02.add(textCnp);
        panel02.add(cnpTF);
        panel02.add(textLastName);
        panel02.add(lastNameTF);
        panel02.add(firstNameTF);
        panel02.add(textFristName);
        panel02.setVisible(true);

        frame.add(panel02);

        addEmployee.addActionListener(e -> {
            if (lastNameTF.getText().isEmpty() || firstNameTF.getText().isEmpty() || cnpTF.getText().isEmpty() || salaryTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Each field must be completed!");
            } else {
                String firsName = firstNameTF.getText();
                String lastName = lastNameTF.getText();
                String cnp = cnpTF.getText();
                double salary = Double.parseDouble(salaryTF.getText());

                Employee employee = new Employee(firsName, lastName, salary, cnp);
                this.employeeController.addEmployee(employee);
                JOptionPane.showMessageDialog(null, "Employee add with success!");

                firstNameTF.setText("");
                lastNameTF.setText("");
                cnpTF.setText("");
                salaryTF.setText("");
            }
        });

        backButton.addActionListener(e -> {
            panel02.setVisible(false);
            panel01.setVisible(true);
        });
    }

    private void buttonGetFunction() {
        panel01.setVisible(false);

        JPanel panel03 = new JPanel();
        panel03.setLayout(null);
        panel03.setVisible(true);

        JLabel textCnp = new JLabel("Insert cnp: ");
        textCnp.setBounds(230, 200, 150, 50);

        JTextField cnpTF = new JTextField();
        cnpTF.setBounds(330, 217, 150, 20);

        JButton getEmployee = new JButton("View");
        getEmployee.setBounds(315, 267, 100, 25);

        JButton backButton = new JButton("Back");
        backButton.setBounds(315, 317, 100, 25);

        panel03.add(textCnp);
        panel03.add(cnpTF);
        panel03.add(getEmployee);
        panel03.add(backButton);
        frame.add(panel03);

        getEmployee.addActionListener(e -> {
            if (cnpTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Insert employee cnp!");
            } else {
                String cnp = cnpTF.getText();
                Employee employee = this.employeeController.getEmployeeByCnp(cnp);
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "FirstName: " + employee.getFirstName() + ", LastName: " + employee.getLastName() + ", Cnp: " + employee.getCnp() + ", Salary: " + employee.getSalary());
                } else {
                    JOptionPane.showMessageDialog(null, "Employee with cnp: " + cnp + " not found!");
                }
            }
            cnpTF.setText("");
        });

        backButton.addActionListener(e -> {
            panel03.setVisible(false);
            panel01.setVisible(true);
        });
    }

    private void buttonUpdateFunctioN() {
        panel01.setVisible(false);

        JPanel panel04 = new JPanel();
        panel04.setLayout(null);
        panel04.setVisible(true);

        JLabel textCnp = new JLabel("Cnp: ");
        textCnp.setBounds(230, 150, 150, 50);

        JTextField cnpTF = new JTextField();
        cnpTF.setBounds(330, 167, 150, 20);

        JLabel textSalary = new JLabel("Insert cnp: ");
        textSalary.setBounds(230, 200, 150, 50);

        JTextField salrayTF = new JTextField();
        salrayTF.setBounds(330, 217, 150, 20);

        JButton updateSalary = new JButton("Update");
        updateSalary.setBounds(315, 267, 100, 25);

        JButton backButton = new JButton("Back");
        backButton.setBounds(315, 317, 100, 25);

        panel04.add(textSalary);
        panel04.add(salrayTF);
        panel04.add(textCnp);
        panel04.add(cnpTF);
        panel04.add(updateSalary);
        panel04.add(backButton);
        frame.add(panel04);

        updateSalary.addActionListener(e -> {
            if (salrayTF.getText().isEmpty() || cnpTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Complet all field!");
            } else {
                String cnp = cnpTF.getText();
                double salary = Double.parseDouble(salrayTF.getText());

                Employee employee = this.employeeController.updateEmployeeSalaryByCnp(cnp, salary);

                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Salary update!");
                } else {
                    JOptionPane.showMessageDialog(null, "Employee not found!");
                }
            }
            salrayTF.setText("");
            cnpTF.setText("");
        });

        backButton.addActionListener(e -> {
            panel04.setVisible(false);
            panel01.setVisible(true);
        });

    }

    private void buttonDeleteFunction() {
        panel01.setVisible(false);

        JPanel panel04 = new JPanel();
        panel04.setLayout(null);
        panel04.setVisible(true);

        JLabel textCnp = new JLabel("Insert cnp: ");
        textCnp.setBounds(230, 200, 150, 50);

        JTextField cnpTF = new JTextField();
        cnpTF.setBounds(330, 217, 150, 20);

        JButton deleteEmployee = new JButton("Delete");
        deleteEmployee.setBounds(315, 267, 100, 25);

        JButton backButton = new JButton("Back");
        backButton.setBounds(315, 317, 100, 25);

        panel04.add(textCnp);
        panel04.add(cnpTF);
        panel04.add(deleteEmployee);
        panel04.add(backButton);
        frame.add(panel04);

        deleteEmployee.addActionListener(e -> {
            if (cnpTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Insert employee cnp!");
            } else {
                String cnp = cnpTF.getText();
                Employee employee = this.employeeController.deleteEmployeeByCnp(cnp);
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Employee delete!");
                } else {
                    JOptionPane.showMessageDialog(null, "Employee with cnp: " + cnp + " not found!");
                }
            }
            cnpTF.setText("");
        });

        backButton.addActionListener(e -> {
            panel04.setVisible(false);
            panel01.setVisible(true);
        });
    }

    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        Interface i = new Interface(employeeController);
    }
}
