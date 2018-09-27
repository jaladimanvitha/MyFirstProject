package com.hexaware.ftp13.util;
import java.util.Scanner;
import com.hexaware.ftp13.model.Employee;
import com.hexaware.ftp13.model.LeaveStatus;
import com.hexaware.ftp13.model.LeaveType;
import com.hexaware.ftp13.model.LeaveDetails;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply for leave");
    System.out.println("4. Display my Leave Details");
    System.out.println("5. Pending leave applications");
    System.out.println("6. Approve or Deny Leave");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        appLeave();
        break;
      case 4:
        listLeaveDetail();
        break;
      case 5:
        listLeavePendingDetails();
        break;
      case 6:
        approveOrDenyLeave();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2 or 3");
    }
    mainMenu();
  }
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(" Employee id is: " + employee.getEmpId() + " Employee name is: " + employee.getEmpName()
          + " Employee Phone is: " + employee.getEmpPhone() + " Employee email is: " + employee.getEmpEmail()
          + " Employee Department is: " + employee.getEmpDept() + " Employee Manager Id is: "
          + employee.getEmpManagerId() + " Employee Date of Joining " + employee.getEmpDoj()
          + " Sick Leave Balance is" + employee.getSickLeave() + "Parental Leave Balance is "
          + employee.getParentalLeave() + " Earned Leave Balance is " + employee.getEarnedLeave());
    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(" Employee id is: " + e.getEmpId() + " Employee name is: "
            + e.getEmpName() + " Employee Phone is: " + e.getEmpPhone() + " Employee email is: "
            + e.getEmpEmail() + " Employee Department is: " + e.getEmpDept() + " Employee Manager Id is: "
            + e.getEmpManagerId() + " Employee Date of Joining " + e.getEmpDoj()
            + " Sick Leave Balance is" + e.getSickLeave() + "Parental Leave Balance is " + e.getParentalLeave()
            + " Earned Leave Balance is " + e.getEarnedLeave());
    }
  }
  private void approveOrDenyLeave() {
    int pLevApp = listLeavePendingDetails();
    if (pLevApp == 1) {
      System.out.println("Enter the Leave Id");
      int leaveId = option.nextInt();
      System.out.println("Approved or Deny");
      String status = option.next();
      System.out.println("Manager Comments");
      String mgrcom = option.next();
      int res = LeaveDetails.updateRecord(leaveId, status, mgrcom);
      if (res > 0) {
        System.out.println("Updated");
      } else {
        System.out.println("Not Updated");
      }
    }
  }
  private void listLeaveDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee emp = Employee.listById(empId);
    if (emp == null) {
      System.out.println("Sorry, No such employee");
    } else {
      LeaveDetails[] leavedetail = LeaveDetails.listId(empId);
      if (leavedetail.length == 0) {
        System.out.println("No employee has applied for leave");
      } else {
        for (LeaveDetails ld : leavedetail) {
          System.out.println(" Leave_Id is: " + ld.getLeaveId() + "Leave_Type is: " + ld.getLeaveType()
                + "Start_Date is" + ld.getStartDate() + "End_Date is: " + ld.getEndDate()
                + "No_Of_Days is:" + ld.getNoOfDays() + "Leave_Status: " + ld.getLeaveStatus()
                + " Leave_Reason is: " + ld.getLeaveReason() + "Leave_applied_on is: "
                + ld.getLeaveAppliedOn() + " Manager_Comments are: " + ld.getManagerComments()
                + " Emp_Id " + ld.getEmpId());
        }
      }
    }
  }
  /**
   * to insert leave details.
   */
  public final void appLeave() {
    LeaveDetails ld = new LeaveDetails();
    LeaveStatus ls;
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      Date startDate = null;
      Date endDate = null;
      Date leaveAppliedOn = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String ldate = sdf.format(leaveAppliedOn);
      System.out.println("Enter the leave start date(yyyy-MM-dd)");
      String sDate = option.next();
      //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      System.out.println("Enter the leave end date(yyyy-MM-dd)");
      String eDate = option.next();
      System.out.println("Enter the Leave Type (SL,EL,PL)");
      String type = option.next();
      LeaveType lt = LeaveType.valueOf(type.toUpperCase());
      ls = LeaveStatus.PENDING;
      System.out.println("Enter leave reason");
      String leaveReason = option.next();
      try {
        startDate = (Date) sdf.parse(sDate);
        endDate = (Date) sdf.parse(eDate);
        leaveAppliedOn = (Date) sdf.parse(ldate);
      } catch (Exception e) {
        System.out.println(e);
      }
      int noOfDays = (endDate.getDate() - startDate.getDate());
      int res = ld.applyLeave(empId, lt, sDate, eDate, noOfDays, ls, leaveReason, leaveAppliedOn);
      if (res > 0) {
        System.out.println("Record inserted successfully");
        int r = LeaveDetails.updateBalance(empId, lt);
        if (r > 0) {
          System.out.println("Updated Leave Balance");
        } else {
          System.out.println("Not updated");
        }
      } else {
        System.out.println("Record is not inserted");
      }
    }
  }
  private int listLeavePendingDetails() {
    System.out.println("Enter Employee Id as a manager");
    int mgrId = option.nextInt();
    Employee emp = Employee.listById(mgrId);
    if (emp == null) {
      System.out.println("There is no Such employee");
    } else {
      Employee[] employee = LeaveDetails.listById(mgrId);
      if (employee.length == 0) {
        System.out.println("Your'e not a Manager");
      } else {
        for (Employee ee : employee) {
          LeaveDetails[] leavedetails = LeaveDetails.listByMngrId(ee.getEmpId());
          if (leavedetails.length == 0) {
            System.out.println(" ");
            System.out.println("No pending record available");
            return 0;
          } else {
            System.out.println(" ");
            for (LeaveDetails leave : leavedetails) {

              System.out.println("LeaveID : " + leave.getLeaveId() + " EmpId : " + leave.getEmpId()
                  + " LeaveType : " + leave.getLeaveType()
                  + " StartDate : " + leave.getStartDate() + " EndDate : " + leave.getEndDate()
                  + " NoOfDays : " + leave.getNoOfDays() + " LeaveReason : " + leave.getLeaveReason()
                  + " LeaveAppliedOn : " + leave.getLeaveAppliedOn() + " ManagerComments : "
                  + leave.getManagerComments() + " LeaveStatus : " + leave.getLeaveStatus() + " Employee Name : "
                  + ee.getEmpName() + " Sick Leave Balance is" + ee.getSickLeave()
                  + "Parental Leave Balance is " + ee.getParentalLeave()
                  + " Earned Leave Balance is " + ee.getEarnedLeave());
              System.out.println(" ");
            }
          }
        }
      }
    }
    return 1;
  }
    /**
     * the main entry point.
     * @param ar the list of arguments
     */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
