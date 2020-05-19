package aut.utcluj.isp.ex3;

import java.util.Objects;

/**
 * @author stefan
 */
public class Employee {
    private String firstName;
    private String lastName;
    private Double salary;
    private String cnp;

    public Employee(String firstName, String lastName, Double salary, String cnp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public String getCnp() {
        return cnp;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee e = (Employee) o;
        return Objects.equals(this.firstName, e.firstName) &&
                Objects.equals(this.lastName, e.lastName) &&
                Objects.equals(this.salary, e.salary) &&
                Objects.equals(this.cnp, e.cnp);

    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, cnp);
    }
}
