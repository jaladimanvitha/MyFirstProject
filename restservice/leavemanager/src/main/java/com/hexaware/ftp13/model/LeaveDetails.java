package com.hexaware.ftp13.model;

import com.hexaware.ftp13.persistence.LeaveDetailsDAO;
import com.hexaware.ftp13.persistence.DbConnection;
import java.util.Objects;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Iterator;

/**
 * LeaveDetails class to store Employee Leave Details.
 * @author Manvitha
 */
public class LeaveDetails {
   /**
   * leaveId to store Leave id.
   */
  private int leaveId;
  private Date startDate;
  private Date endDate;
  private int noOfDays;
  private String leaveReason;
  private Date leaveAppliedOn;
  private String managerComments;
  private int empId;
  /**
   * Enumerated type.
   */
  private LeaveType leaveType;
   /**
   * Enumerated type.
   */
  private LeaveStatus leaveStatus;
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails ldetails = (LeaveDetails) obj;
    if (Objects.equals(leaveId, ldetails.leaveId)
        && Objects.equals(leaveType, ldetails.leaveType)
        && Objects.equals(startDate, ldetails.startDate)
        && Objects.equals(endDate, ldetails.endDate)
        && Objects.equals(noOfDays, ldetails.noOfDays)
        && Objects.equals(leaveReason, ldetails.leaveReason)
        && Objects.equals(leaveAppliedOn, ldetails.leaveAppliedOn)
        && Objects.equals(managerComments, ldetails.managerComments)
        && Objects.equals(empId, ldetails.empId)) {
      return true;
    }
    return false;
  }
  /**
   * @param argLeaveId to initialize leave id.
   * @param argLeaveType to initialize leave type.
   * @param argStartDate to initialize start date.
   * @param argEndDate to initialize end date.
   * @param argNoOfDays to initialize No of days.
   * @param argLeaveStatus to initialize leave status.
   * @param argLeaveReason to initialize leave reason.
   * @param argLeaveAppliedOn to initialize leave applied on.
   * @param argManagerComments to initialize manager comments.
   * @param argEmpId to initialize employee id.
   */
  public LeaveDetails(final int argLeaveId, final LeaveType argLeaveType,
      final Date argStartDate,
      final Date argEndDate,
      final int argNoOfDays, final LeaveStatus argLeaveStatus,
      final String argLeaveReason,
      final Date argLeaveAppliedOn,
      final String argManagerComments,
      final int argEmpId) {
    this.leaveId = argLeaveId;
    this.leaveType = argLeaveType;
    this.startDate = argStartDate;
    this.endDate = argEndDate;
    this.noOfDays = argNoOfDays;
    this.leaveStatus = argLeaveStatus;
    this.leaveReason = argLeaveReason;
    this.leaveAppliedOn = argLeaveAppliedOn;
    this.managerComments = argManagerComments;
    this.empId = argEmpId;
  }
  /**
   * @param argLeaveId to initialize leave id.
   * @param argEmpId to initialize employee id.
   */
  public LeaveDetails(final int argLeaveId, final int argEmpId) {
    this.leaveId = argLeaveId;
    this.empId = argEmpId;
  }
  /**
   * Default constructor.
   */
  public LeaveDetails() {
  }
  /**
  * @param argLeaveId to set leaveId.
  */
  public LeaveDetails(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(leaveId, leaveType, startDate, endDate, noOfDays, leaveReason, leaveAppliedOn, managerComments,
      empId);
  }
  /**
   * Gets the LeaveId.
   * @return this Leave ID.
   */
  public final int getLeaveId() {
    return leaveId;
  }

/**
   * Gets the Leavetype.
   * @return this Leave type.
   */
  public final LeaveType getLeaveType() {
    return leaveType;
  }

  /**
   * Gets the StartDate.
   * @return this StartDate.
   */
  public final Date getStartDate() {
    return startDate;
  }

  /**
   * Gets the EndDate.
   * @return this EndDate.
   */
  public final Date getEndDate() {
    return endDate;
  }

  /**
   * Gets the NoOfDays.
   * @return this NoOfDays.
   */
  public final int getNoOfDays() {
    return noOfDays;
  }

  /**
   * Gets the LeaveStatus.
   * @return LeaveStatus.
   */
  public final LeaveStatus getLeaveStatus() {
    return leaveStatus;
  }

  /**
   * Gets the LeaveReason.
   * @return this LeaveReason.
   */
  public final String getLeaveReason() {
    return leaveReason;
  }
  /**
   * Gets the LeaveAppliedOn.
   * @return this LeaveAppliedOn.
   */
  public final Date getLeaveAppliedOn() {
    return leaveAppliedOn;
  }

  /**
   * Gets the ManagerComments.
   * @return this ManagerComments.
   */
  public final String getManagerComments() {
    return managerComments;
  }

  /**
   * Gets the EmpId.
   * @return this EmpId.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argLeaveId to set leave id.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }

  /**
   *
   * @param argStartDate to set start date.
   */
  public final void setStartDate(final Date argStartDate) {
    this.startDate = argStartDate;
  }

  /**
   *
   * @param argEndDate to set end date.
   */
  public final void setEndDate(final Date argEndDate) {
    this.endDate = argEndDate;
  }

  /**
   *
   * @param argNoOfDays to set no of days.
   */
  public final void setNoOfDays(final int argNoOfDays) {
    this.noOfDays = argNoOfDays;
  }

  /**
   *
   * @param argLeaveReason to set leave reason.
   */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }

  /**
   *
   * @param argLeaveAppliedOn to set leave applied on.
   */
  public final void setLeaveAppliedOn(final Date argLeaveAppliedOn) {
    this.leaveAppliedOn = argLeaveAppliedOn;
  }

  /**
   *
   * @param argManagerComments to set manager comments.
   */
  public final void setManagerComments(final String argManagerComments) {
    this.managerComments = argManagerComments;
  }

  /**
   *
   * @param argEmpId to set Employee Id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  @Override
  public final String toString() {
    return " Leave_Id: " + leaveId + " Leave_Type: " + leaveType + " Start_Date: " + startDate + " End_Date " + endDate
      + " No_Of_Days " + noOfDays + " Leave_Reason " + leaveReason + " Leave_Applied_On "
      + leaveAppliedOn + " Manager_Comments " + managerComments + " Emp_Id " + empId;
  }
  /**
   * The dao for leaveDetails.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }
  /**
   * list leave details by id.
   * @param empId id to get leave details.
   * @return LeaveDetails
   */
  public static LeaveDetails[] listId(final int empId) {
    List<LeaveDetails> ld = dao().find(empId);
    return ld.toArray(new LeaveDetails[ld.size()]);
  }
  /**
   * inserting leave details.
   * @param leaveID id to insert leave details.
   * @return LeaveDetails
   */
  /**
   * to insert leave details.
   * @param empId id of employee.
   * @param lt leaveType of leave.
   * @param startDate of leave.
   * @param endDate of leave.
   * @param noOfDays of leave.
   * @param ls leaveStatus of leave.
   * @param leaveReason leaveReason of leave.
   * @param leaveAppliedOn leaveAppliedOn of leave.
   * @return res no. of records.
   */
  public static int applyLeave(final int empId, final LeaveType lt, final String startDate, final String endDate,
      final int noOfDays, final LeaveStatus ls, final String leaveReason, final Date leaveAppliedOn) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date sDate = null;
    Date eDate = null;
    try {
      sDate = (Date) sdf.parse(startDate);
      eDate = (Date) sdf.parse(endDate);
    } catch (Exception e) {
      System.out.println(e);
    }
    LeaveDetailsDAO ld = LeaveDetails.dao();
    int res = 0;
    if (comparison(leaveAppliedOn, sDate, eDate) > 0) {
      res = ld.insertRecord(lt, sDate, eDate, noOfDays, ls, leaveReason, leaveAppliedOn,
            empId);
      return res;
    } else {
      System.out.println("Sorry, start date should be >= today and end date should be >= start date");
    }
    return res;
  }
  /**
   * comparing dates.
   * @param currentDate is current date.
   * @param sd is start date.
   * @param ed is end date.
   * @return integer value
   */
  public static final int comparison(final Date currentDate, final Date sd, final Date ed) {
    if (ed.compareTo(currentDate) >= 0 && sd.compareTo(currentDate) >= 0) {
      if (ed.compareTo(sd) >= 0) {
        return 1;
      } else {
        return 0;
      }
    } else {
      return 0;
    }
  }
  /**
   * list employee details by id.
   * @param mngrId id to get employee details.
   * @return Employee
   */
  public static Employee[] listById(final int mngrId) {
    List<Employee> ls = dao().findId(mngrId);
    return ls.toArray(new Employee[ls.size()]);
  }
  /**
   * @return feedback.
   * @param leaveId to set LeaveId.
   * @param status to set LeaveStatus.
   * @param mgrcom to set manager comments.
   */
  public static int updateRecord(final int leaveId, final String status, final String mgrcom) {
    Locale locale = Locale.ENGLISH;
    String lStatus = status.toUpperCase(locale);
    System.out.println(lStatus);
    LeaveStatus ls;
    if (lStatus.equalsIgnoreCase("APPROVED")) {
      ls = LeaveStatus.APPROVED;
      //String managerComments = option.next();
      LeaveDetails.updateStatus(leaveId, ls, mgrcom);
    } else {
      ls = LeaveStatus.DENIED;
      LeaveDetails ld = dao().findLeaveId(leaveId);
      if (ld.getLeaveType() == LeaveType.EL) {
        dao().incrementBal(leaveId, mgrcom);
      } else {
        if (ld.getLeaveType() == LeaveType.SL) {
          dao().incrementBal1(leaveId, mgrcom);
        } else {
          dao().incrementBal2(leaveId, mgrcom);
        }
      }
      //String managerComments = option.next();
    }
    return updateStatus(leaveId, ls, mgrcom);
  }
  /**
   * @return feedback.
   * @param leaveId to set LeaveId.
   * @param leaveStatus to set LeaveStatus.
   * @param mgrcom to set manager comments.
   */
  public static int updateStatus(final int leaveId, final LeaveStatus leaveStatus, final String mgrcom) {
    return dao().find(leaveId, leaveStatus, mgrcom);
  }
  /**
   * list employee details by id.
   * @return feedback.
   * @param empId to set leave Id.
   * @param leaveType to set leave Type.
  */
  public static int updateBalance(final int empId, final LeaveType leaveType) {
    Employee emp = Employee.listById(empId);
    System.out.println(emp.getSickLeave());
    List<LeaveDetails> leave = dao().findEmpId(empId);
    int count = 0;
    Iterator<LeaveDetails> ir = leave.iterator();
    if (leaveType == LeaveType.SL) {
      while (ir.hasNext()) {
        LeaveDetails ld = ir.next();
        if (emp.getSickLeave() < ld.noOfDays) {
          System.out.println("Insufficent Leave Balance");
        } else {
          System.out.println("***********" + ld.noOfDays);
          dao().leavebalUpdateDao(ld.getLeaveId());
          count++;
        }
      }
    } else {
      if (leaveType == LeaveType.PL) {
        while (ir.hasNext()) {
          LeaveDetails ld = ir.next();
          System.out.println("***********" + ld.noOfDays);
          dao().parentalbalUpdateDao(ld.getLeaveId());
          count++;
        }
      } else {
        if (leaveType == LeaveType.EL) {
          while (ir.hasNext()) {
            LeaveDetails ld = ir.next();
            System.out.println("***********" + ld.noOfDays);
            dao().earnedbalUpdateDao(ld.getLeaveId());
            count++;
          }
        }
      }
    }
    return count;
  }
  /**
   * list leave details by Id.
   * @param mgrId to set Employee Id.
   * @return LeaveDetails
   */
  public static LeaveDetails[] listByMngrId(final int mgrId) {
    List<LeaveDetails> es = dao().listPending(mgrId);
    return es.toArray(new LeaveDetails[es.size()]);
  }
}
