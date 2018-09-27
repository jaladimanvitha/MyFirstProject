package com.hexaware.ftp13.persistence;

import com.hexaware.ftp13.model.LeaveDetails;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import com.hexaware.ftp13.model.LeaveType;
import com.hexaware.ftp13.model.LeaveStatus;
import com.hexaware.ftp13.model.Employee;
import java.util.Date;

import java.util.List;
/**
 * The DAO class for LeaveDetails.
 */
public interface LeaveDetailsDAO  {
    /**
   * return all the  leave details of the selected employee.
   * @param empId the id of the employee
   * @return the leave object
   */
  @SqlQuery("select * from leave_details where emp_id=:empId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> find(@Bind("empId") int empId);
  /**
   * insert  all the details to leave_history.
   * @param leaveType the type of leave.
   * @param startDate the start date.
   * @param endDate the end date.
   * @param noOfDays of leave.
   * @param leaveStatus the leave status.
   * @param leaveReason the leave reason for employee.
   * @param leaveAppliedOn the applied date.
   * @param empId the employee id.
   * @return integer
   */
  @SqlUpdate("INSERT INTO LEAVE_DETAILS(LEAVE_TYPE, START_DATE, END_DATE, NO_OF_DAYS,"
       + " LEAVE_STATUS, LEAVE_REASON, LEAVE_APPLIED_ON,"
       + " EMP_ID) VALUES(:leaveType,:startDate,:endDate,:noOfDays,:leaveStatus,:leaveReason,"
       + " :leaveAppliedOn,:empId)")
  int insertRecord(@Bind("leaveType") LeaveType leaveType, @Bind("startDate") Date startDate,
      @Bind("endDate") Date endDate, @Bind("noOfDays") int noOfDays, @Bind("leaveStatus") LeaveStatus leaveStatus,
      @Bind("leaveReason") String leaveReason, @Bind("leaveAppliedOn") Date leaveAppliedOn,
      @Bind("empId") int empId);
  /**
   * return all the leave details of the selected employee.
   * @param empID the id of the LeaveDetails
   * @return the LeaveDetails object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empID")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> findEmpId(@Bind("empID") int empID);
  /**
   * return all the leave details of the selected employee.
   * @param leaveId the id of the LeaveDetails
   * @return the LeaveDetails object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_ID = :leaveId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails findLeaveId(@Bind("leaveId") int leaveId);
  /**
   * return all the details of the selected employee.
   * @param mngrId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE  WHERE EMP_MANAGER_ID = :mngrID")
  @Mapper(EmployeeMapper.class)
  List<Employee> findId(@Bind("mngrID") int mngrId);
  /**
  * Updates the leave status.
  */
  /**
   * @return leaveId and index.
   * @param leaveId to set LeaveId.
   * @param leaveStatus to set leaveStatus.
   * @param mgrcom to set manager comments.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS = :leaveStatus, MANAGER_COMMENTS = :mgrcom WHERE LEAVE_ID ="
      + ":leaveId")
  int find(@Bind("leaveId") int leaveId, @Bind("leaveStatus") LeaveStatus leaveStatus, @Bind("mgrcom") String mgrcom);
  /**
   * @param leaveId to set LeaveId.
   * @param mgrcom to set manager comments.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS l,EMPLOYEE e SET e.earned_leave ="
      + "e.earned_leave + l.NO_OF_DAYS, l.MANAGER_COMMENTS = :mgrcom "
      + " WHERE l.EMP_ID = e.EMP_ID AND LEAVE_ID = :leaveId")
  void incrementBal(@Bind("leaveId") int leaveId, @Bind("mgrcom") String mgrcom);
  /**
   * @param leaveId to set LeaveId.
   * @param mgrcom to set manager comments.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS l,EMPLOYEE e SET e.sick_leave ="
      + "e.sick_leave + l.NO_OF_DAYS, l.MANAGER_COMMENTS = :mgrcom "
      + " WHERE l.EMP_ID = e.EMP_ID AND LEAVE_ID = :leaveId")
  void incrementBal1(@Bind("leaveId") int leaveId, @Bind("mgrcom") String mgrcom);
  /**
   * @param leaveId to set LeaveId.
   * @param mgrcom to set manager comments.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS l,EMPLOYEE e SET e.parental_leave ="
      + "e.parental_leave + l.NO_OF_DAYS, l.MANAGER_COMMENTS = :mgrcom "
      + " WHERE l.EMP_ID = e.EMP_ID AND LEAVE_ID = :leaveId")
  void incrementBal2(@Bind("leaveId") int leaveId, @Bind("mgrcom") String mgrcom);
  /**
  * Updating leave balance.
  * @param leaveId leaveid.
  */
  @SqlUpdate("update employee e, leave_details l set e.sick_leave="
      + "e.sick_leave-l.NO_OF_DAYS where e.emp_id = l.emp_id and l.leave_id = :leaveId")
  void leavebalUpdateDao(@Bind("leaveId") int leaveId);
  /**
  * Updating leave balance.
  * @param leaveId leaveid.
  */
  @SqlUpdate("update employee e, leave_details l set e.parental_leave="
      + "e.parental_leave-l.NO_OF_DAYS where e.emp_id = l.emp_id and l.leave_id = :leaveId")
  void parentalbalUpdateDao(@Bind("leaveId") int leaveId);
  /**
  * Updating leave balance.
  * @param leaveId leaveid.
  */
  @SqlUpdate("update employee e, leave_details l set e.earned_leave="
      + "e.earned_leave-l.no_of_days where e.emp_id = l.emp_id and l.leave_id = :leaveId")
  void earnedbalUpdateDao(@Bind("leaveId") int leaveId);
  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @return the LeaveDetails object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_STATUS LIKE 'PENDING' AND EMP_ID = :empId ")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> listPending(@Bind("empId") int empId);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
