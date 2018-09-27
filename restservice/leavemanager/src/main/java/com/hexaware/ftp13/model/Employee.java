package com.hexaware.ftp13.model;
import com.hexaware.ftp13.persistence.DbConnection;
import com.hexaware.ftp13.persistence.EmployeeDAO;
import java.util.Objects;
import java.util.List;
import java.util.Date;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   */
  private int empId;
  private String empName;
  private long empPhone;
  private String empEmail;
  private String empDept;
  private int empManagerId;
  private Date empDoj;
  private int sickLeave;
  private int parentalLeave;
  private int earnedLeave;
  /**
   * initialize employee.
   */
  public Employee() {
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empName, emp.empName)
        && Objects.equals(empPhone, emp.empPhone)
        && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empManagerId, emp.empManagerId)
        && Objects.equals(sickLeave, emp.sickLeave)
        && Objects.equals(parentalLeave, emp.parentalLeave)
        && Objects.equals(earnedLeave, emp.earnedLeave)
        && Objects.equals(empDoj, emp.empDoj)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empPhone, empEmail, empDept, empManagerId, empDoj, sickLeave, parentalLeave,
    earnedLeave);
  }

  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * @param argEmpId to initialize employee id.
   * @param argEmpName to initialize employee name.
   * @param argEmpPhone to initialize employee phone.
   * @param argEmpEmail to initialize employee email.
   * @param argEmpDept to initialize employee dept.
   * @param argEmpManagerId to initialize employee managerId.
   * @param argEmpDoj to initialize employee doj.
   * @param argSickLeave to initialize sick leave.
   * @param argParentalLeave to initialize parental Leave.
   * @param argEarnedLeave to initialize earned leave.
   */
  public Employee(final int argEmpId, final String argEmpName, final long argEmpPhone,
      final String argEmpEmail, final String argEmpDept, final int argEmpManagerId, final Date argEmpDoj,
      final int argSickLeave, final int argParentalLeave, final int argEarnedLeave) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empPhone = argEmpPhone;
    this.empEmail = argEmpEmail;
    this.empDept = argEmpDept;
    this.empManagerId = argEmpManagerId;
    this.empDoj = argEmpDoj;
    this.sickLeave = argSickLeave;
    this.parentalLeave = argParentalLeave;
    this.earnedLeave = argEarnedLeave;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   * Gets the EmployeePhone.
   * @return this Employee's Phone.
   */
  public final long getEmpPhone() {
    return empPhone;
  }

  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }

  /**
   * Gets the EmployeeDept.
   * @return this Employee's Department.
   */
  public final String getEmpDept() {
    return empDept;
  }

  /**
   * Gets the EmployeeManagerId.
   * @return this Employee's ManagerID.
   */
  public final int getEmpManagerId() {
    return empManagerId;
  }

  /**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final Date getEmpDoj() {
    return empDoj;
  }

/**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final int getSickLeave() {
    return sickLeave;
  }

/**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final int getParentalLeave() {
    return parentalLeave;
  }

  /**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final int getEarnedLeave() {
    return earnedLeave;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }

  /**
   *
   * @param argEmpPhone to set employee phone.
   */
  public final void setEmpPhone(final long argEmpPhone) {
    this.empPhone = argEmpPhone;
  }

  /**
   *
   * @param argEmpEmail to set employee email.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }

  /**
   *
   * @param argEmpDept to set employee department.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }

  /**
   *
   * @param argEmpManagerId to set employee ManagerId.
   */
  public final void setEmpManagerId(final int argEmpManagerId) {
    this.empManagerId = argEmpManagerId;
  }

  /**
   *
   * @param argEmpDoj to set employee date of joining.
   */
  public final void setEmpDoj(final Date argEmpDoj) {
    this.empDoj = argEmpDoj;
  }

  /**
   *
   * @param argSickLeave to set employee Sick leave balance.
   */
  public final void setSickLeave(final int argSickLeave) {
    this.sickLeave = argSickLeave;
  }

  /**
   *
   * @param argParentalLeave to set employee Parental leave balance.
   */
  public final void setParentalLeave(final int argParentalLeave) {
    this.parentalLeave = argParentalLeave;
  }

  /**
   *
   * @param argEarnedLeave to set employee Earned leave balance.
   */
  public final void setEarnedLeave(final int argEarnedLeave) {
    this.earnedLeave = argEarnedLeave;
  }

  @Override
  public final String toString() {
    return " Emp_Id: " + empId + " Emp_Name: " + empName + " EmpPhone " + empPhone + " Emp_Email "
      + empEmail + " Emp_Dept " + empDept + " Emp_Manager_Id " + empManagerId + " Emp_Doj " + empDoj + " Sick_Leave "
      + sickLeave + " Parental_Leave " + parentalLeave + "Earned_Leave " + earnedLeave;
  }


  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }
}
