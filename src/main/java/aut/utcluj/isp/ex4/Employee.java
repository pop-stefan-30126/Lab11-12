package aut.utcluj.isp.ex4;

/**
 * @author stefan
 */
public class Employee implements IdentityManager{
    private String firstName;
    private String lastName;
    private String cnp;
    private SalaryInfo employeeSalaryInfo;

    public Employee(String firstName, String lastName, String cnp, Double monthlyRevenue) throws NegativeAmountException{
        this.firstName=firstName;
        this.lastName=lastName;
        this.cnp=cnp;
        employeeSalaryInfo=new SalaryInfo(monthlyRevenue);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCnp() {
        return cnp;
    }

    /**
     * Add salary to the employee
     */
    public void addSalary() {
        this.employeeSalaryInfo.addSalary();
    }

    /**
     * Add money as bonus to the employee
     * Value added should be positive
     *
     * @param money - money to be added
     */
    public void addMoney(final Double money) throws NegativeAmountException {
        this.employeeSalaryInfo.addMoney(money);
    }

    /**
     * Pay tax from salary
     *
     * @param tax - tax to be paid
     */
    public void payTax(final Double tax) throws NegativeAmountException,NegativeBalanceException{
        this.employeeSalaryInfo.payTax(tax);
    }

    /**
     * Get salary info
     *
     * @return salary info
     */
    public SalaryInfo getSalaryInfo() {
        return this.employeeSalaryInfo;
    }

    @Override
    public String getIdentity() {
        return this.firstName+"_"+this.lastName+"_"+this.cnp;
    }
}
