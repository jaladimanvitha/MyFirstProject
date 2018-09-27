package com.hexaware.ftp13.util;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.hexaware.ftp13.model.LeaveType;
import com.hexaware.ftp13.model.LeaveStatus;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.hexaware.ftp13.model.LeaveDetails;
import com.hexaware.ftp13.model.Employee;

/**
 * This class provides a REST interface for the LeaveDetails entity.
 */
@Path("/leavedetails")
public class LeaveDetailsRest {
    /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("listbyid/{mngrId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employee[] leaveDetailsListById(@PathParam("mngrId") final int id) {
    final Employee[] empl = LeaveDetails.listById(id);
    if (empl == null) {
      throw new NotFoundException("Not a Manager");
    }
    return empl;
  }
   /**
   * Returns pending leavedetails of the employees.
   * @param mgId the id of the employee.
   * @return the pending leave details.
   */
  @GET
  @Path("pending/{mgrId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Map leaveDetailslistByMngrId(@PathParam("mgrId") final int mgId) {
    List<LeaveDetails> ld = new ArrayList();
    Map map = new HashMap();
    Employee emp = Employee.listById(mgId);
    if (emp == null) {
      throw new NotFoundException("There is no Such employee");
    } else {
      Employee[] employee = LeaveDetails.listById(mgId);
      map.put("Employee", employee);
      if (employee.length == 0) {
        throw new NotFoundException("Your'e not a Manager");
      } else {
        for (Employee ee : employee) {
          LeaveDetails[] l = LeaveDetails.listByMngrId(ee.getEmpId());
          if (l.length == 0) {
            throw new NotFoundException("No pending records available" + mgId);
          } else {
            for (LeaveDetails leave : l) {
              ld.add(leave);
            }
          }
        }
      }
      map.put("Leave", ld);
      return map;
    }
  }
/**
* Returns a specific employee's details.
* @param id the id of the employee
* @return the employee details
*/
  @GET
  @Path("leaveapp/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveDetailsListId(@PathParam("id") final int id) {
    Employee emp = Employee.listById(id);
    if (emp == null) {
      throw new NotFoundException("No such Employee" + id);
    } else {
      LeaveDetails[] lmp = LeaveDetails.listId(id);
      if (lmp.length == 0) {
        throw new NotFoundException("No pending leave applications" + id);
      }
      return lmp;
    }
  }
  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @param status the id of the employee
   * @param mgrcom the id of the employee
   * @return the employee details
   */
  @POST
  @Path("approveordeny/{id}/{status}/{mgrcom}")
  @Produces(MediaType.TEXT_PLAIN)
  public final String approveOrDeny(@PathParam("id") final int id,
      @PathParam("status") final String status, @PathParam("mgrcom") final String mgrcom) {
    int res = LeaveDetails.updateRecord(id, status, mgrcom);
    if (res > 0) {
      return "Updated the leave Application";
    } else {
      return "Not Updated";
    }
  }
  /**
   * apply leave.
   * @param id to take leave Id.
   * @param startDate to take start Date.
   * @param endDate to take end Date.
   * @param leaveReason to take leave Reason.
   * @param leaveType to take Leave Type.
   */
  @POST
  @Path("applyleave/{id}/{sdate}/{edate}/{leavetype}/{leavereason}")
  @Produces(MediaType.TEXT_PLAIN)
    public final void getEmpText(@PathParam("id") final int id,
           @PathParam("sdate") final String startDate, @PathParam("edate") final String endDate,
      @PathParam("leavetype") final String leaveType, @PathParam("leavereason") final String leaveReason) {
    LeaveDetails ld = new LeaveDetails();
    LeaveType lt = LeaveType.valueOf(leaveType.toUpperCase());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date lAppliedOn = new Date();
    String ldate = sdf.format(lAppliedOn);
    LeaveStatus ls = LeaveStatus.PENDING;
    Date sdate = null;
    Date edate = null;
    try {
      sdate = sdf.parse(startDate);
      edate = sdf.parse(endDate);
      lAppliedOn = (Date) sdf.parse(ldate);
    } catch (Exception e) {
      System.out.println("Date cannot be null");
    }
    int noOfDays = (edate.getDate() - sdate.getDate());
    LeaveDetails.updateBalance(id, lt);
    int res = ld.applyLeave(id, lt, startDate, endDate, noOfDays, ls, leaveReason, lAppliedOn);
    if (res > 0) {
      System.out.println("record inserted successfully");
    } else {
      System.out.println("Failed to insert record");
    }
  }
}
