package aut.utcluj.isp.ex3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stefan
 */
public class EmployeeController {
    private List<Employee> employees;

    public EmployeeController() {
        employees = new ArrayList<>();
    }

    /**
     * Add new employee to the list of employees
     *
     * @param employee - employee information
     */

    public void addEmployee(final Employee employee) {
        if (employee != null)
            if (!this.employees.contains(employee)) {
                employees.add(employee);
                System.out.println("Employee was added!");
            } else {
                System.out.println("Employee already exists!");
            }
    }

    /**
     * Get employee by cnp
     *
     * @param cnp - unique cnp
     * @return found employee or null if not found
     */
    public Employee getEmployeeByCnp(final String cnp) {
        if (cnp != null) {
            for (Employee e : this.employees) {
                if (e.getCnp().equals(cnp))
                    return e;
            }
        }
        System.out.println("Operation failed!");
        return null;
    }


    /**
     * Update employee salary by cnp
     *
     * @param cnp    - unique cnp
     * @param salary - salary
     * @return updated employee
     */
    public Employee updateEmployeeSalaryByCnp(final String cnp, final Double salary) {
        if (cnp != null && salary != null) {
            for (int i = 0; i < this.employees.size(); i++) {
                if (this.employees.get(i).getCnp().equals(cnp)) {
                    this.employees.get(i).setSalary(salary);
                    return this.employees.get(i);
                }
            }
        }
        System.out.println("Operation failed!");
        return null;


    }

    /**
     * Delete employee by cnp
     *
     * @param cnp - unique cnp
     * @return deleted employee or null if not found
     */
    public Employee deleteEmployeeByCnp(final String cnp) {
        if (cnp != null) {
            for (Employee e : this.employees) {
                if (e.getCnp().equals(cnp)) {
                    this.employees.remove(e);
                    return e;
                }
            }
        }

        System.out.println("Operation failed!");
        return null;
    }

    /**
     * Return current list of employees
     *
     * @return current list of employees
     */
    public List<Employee> getEmployees() {
        return this.employees;
    }

    /**
     * Get number of employees
     *
     * @return - number of registered employees
     */
    public int getNumberOfEmployees() {
        return this.employees.size();
    }
}
