package com.hexaware.ftp13.model;
import com.hexaware.ftp13.persistence.LeaveDetailsDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.Before;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Test class for LeaveDetails.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {
/**
 * setup method.
 */
  @Before
  public void initInput() {
  }
  /**
   * tests that leave details with one parameter is handled correctly.
   */
  @Test
  public final void testLeaveDetails3() {
    LeaveDetails ld = new LeaveDetails(100, 3000);
    LeaveDetails ld1 = new LeaveDetails(200, 2001);
    assertEquals(ld, new LeaveDetails(100, 3000));
    assertNotEquals(ld, null);
    assertNotEquals(ld1, null);
    assertEquals(ld1, new LeaveDetails(200, 2001));
    assertEquals(ld.hashCode(), new LeaveDetails(100, 3000).hashCode());
  }
  /**
   * Tests for toString.
   */
  @Test
  public final void testToString() {
    LeaveDetails l = new LeaveDetails();
    String s1 = " Leave_Id: " + l.getLeaveId() + " Leave_Type: " + l.getLeaveType() + " Start_Date: " + l.getStartDate()
        + " End_Date " + l.getEndDate() + " No_Of_Days " + l.getNoOfDays() + " Leave_Reason " + l.getLeaveReason()
        + " Leave_Applied_On " + l.getLeaveAppliedOn() + " Manager_Comments " + l.getManagerComments()
        + " Emp_Id " + l.getEmpId();
    assertEquals(s1, l.toString());
  }
  /**
   * Tests whether the start date is less than End date.
   */
  @Test
  public final void testLeaveDetails() {
    LeaveDetails ld1 = new LeaveDetails();
  }
  /**
 * Tests whether the start date is less than End date.
 */
  @Test
  public final void testUpdateRecord() {
    int lid = 1;
    String status = "approved";
    String mgrcom = "ok";
    int res = LeaveDetails.updateRecord(lid, status, mgrcom);
    assertEquals(res, 0);
  }
  /**
   * tests that leave details with two parameters is handled correctly.
   */
  @Test
  public final void testLeaveDetails4() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date lAppliedOn = new Date();
    Date startDate = null;
    Date endDate = null;
    LeaveType lt = LeaveType.EL;
    String sdate = "2018-03-19";
    LeaveStatus ls = LeaveStatus.APPROVED;
    String edate = "2018-03-22";
    try {
      startDate = sdf.parse(sdate);
      endDate = sdf.parse(edate);
    } catch (Exception e) {
    }
    LeaveDetails ld = new LeaveDetails(100, lt, startDate, endDate, 4, ls,
        "Sick", lAppliedOn, null, 2001);
    assertEquals(ld, new LeaveDetails(100, LeaveType.EL, startDate,
        endDate, 4, LeaveStatus.APPROVED,
        "Sick", lAppliedOn, null, 2001));
  }
/**
 * Test for setter and getter methods.
 */
  @Test
    public final void testSetGet() {
    int leaveId = 1;
    LeaveDetails ld = new LeaveDetails();
    ld.setLeaveId(leaveId);
    assertEquals(ld.getLeaveId(), leaveId);
    assertNotEquals(ld.getLeaveId(), "ABC");
    assertNotEquals(ld.getLeaveId(), 10.5);
    String leavereason = "sick";
    ld.setLeaveReason(leavereason);
    assertEquals(ld.getLeaveReason(), leavereason);
    assertNotEquals(ld.getLeaveReason(), 55.67);
    assertNotEquals(ld.getLeaveReason(), 16);
    int no = 5;
    ld.setNoOfDays(no);
    assertEquals(ld.getNoOfDays(), no);
    assertNotEquals(ld.getNoOfDays(), "ABCD");
    assertNotEquals(ld.getNoOfDays(), 28.55);
    ld.setManagerComments("ok");
    assertEquals(ld.getManagerComments(), "ok");
    assertNotEquals(ld.getManagerComments(), 43.7);
    assertNotEquals(ld.getManagerComments(), 50);
    int empid = 1000;
    ld.setEmpId(empid);
    assertEquals(ld.getEmpId(), empid);
    assertNotEquals(ld.getEmpId(), "pqr");
    assertNotEquals(ld.getEmpId(), 67.5);
    ld.setStartDate(new java.util.Date(2018, 02, 02));
    Date sDate = ld.getStartDate();
    assertEquals(new java.util.Date(2018, 02, 02), sDate);
    ld.setEndDate(new java.util.Date(2018, 02, 06));
    Date eDate = ld.getEndDate();
    assertEquals(new java.util.Date(2018, 02, 06), eDate);
    LeaveType lt = LeaveType.valueOf("EL");
    assertEquals(ld.getLeaveType(), null);
    ld.setLeaveAppliedOn(new java.util.Date(2018, 02, 05));
    Date lappdate = ld.getLeaveAppliedOn();
    assertEquals(new java.util.Date(2018, 02, 05), lappdate);
    LeaveStatus ls = LeaveStatus.PENDING;
    assertNotEquals(ld.getLeaveStatus(), ls);
  }
 /**
  * Tests whether the start date is less than End date.
  */
  @Test
  public final void testComparison() {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      //Date lAppliedOn = new Date();
      String lDate = "2018-02-06";
      String sDate = "2018-02-05";
      String eDate = "2018-02-10";
      Date lAppliedOn = (Date) sdf.parse(lDate);
      Date startDate = (Date) sdf.parse(sDate);
      Date endDate = (Date) sdf.parse(eDate);
      int result = LeaveDetails.comparison(startDate, endDate, lAppliedOn);
      assertEquals(0, result);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  /**
   * Tests whether the start date is less than End date.
   */
  @Test
  public final void testLeaveDetails2() {
    LeaveDetails ld = new LeaveDetails(100);
    LeaveDetails ld1 = new LeaveDetails(200);
    assertEquals(ld, new LeaveDetails(100));
    assertNotEquals(ld, null);
    assertNotEquals(ld1, null);
    assertEquals(ld1, new LeaveDetails(200));
  }
  /**
   * Tests whether the start date is less than End date.
   * @param dao to pass dao
   */
  @Test
  public final void testupdateBalance(@Mocked final LeaveDetailsDAO dao) {
    final LeaveDetails l1 = new LeaveDetails();
    new Expectations() {
      {
        dao.findEmpId(1000);
        result = l1;
        //dao.findEmpId(-1);
        //result = null;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int res = LeaveDetails.updateBalance(1000, LeaveType.EL);
    assertEquals(res, 1);
    assertNotEquals(res, 10001);
    try {
      int r = LeaveDetails.updateBalance(-1, null);
      assertNull(r);
    } catch (Exception e) {
    }
  }
  /**
   * Tests that a fetch of a list of employees work correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(2000));
        es.add(new Employee(2001));
        es.add(new Employee(3000));
        dao.findId(3000); result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    Employee[] es = LeaveDetails.listById(3000);
    assertEquals(3, es.length);
    assertEquals(new Employee(2000), es[0]);
    assertEquals(new Employee(2001), es[1]);
    assertEquals(new Employee(3000), es[2]);
  }
/**
* Tests that a fetch of a specific employee works correctly.
* @param dao mocking the dao class
*/
  @Test
  public final void testlistId(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        ArrayList<LeaveDetails> ld = new ArrayList<LeaveDetails>();
        ld.add(new LeaveDetails(1, 1000));
        ld.add(new LeaveDetails(2, 2000));
        ld.add(new LeaveDetails(3, 3000));
        dao.find(1000); result = ld;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ld = LeaveDetails.listId(1000);
    assertEquals(3, ld.length);
    assertEquals(new LeaveDetails(1, 1000), ld[0]);
    assertNotEquals(new LeaveDetails(2, 100), ld[1]);
    assertEquals(new LeaveDetails(3, 3000), ld[2]);
  }
  /**
   * Tests that a fetch of a list of leavedetails work correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testManager(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        ArrayList<LeaveDetails> ls = new ArrayList<LeaveDetails>();
        ls.add(new LeaveDetails(2000));
        ls.add(new LeaveDetails(2001));
        ls.add(new LeaveDetails(3000));
        dao.listPending(3000); result = ls;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ls = LeaveDetails.listByMngrId(3000);
    assertEquals(3, ls.length);
    assertEquals(new LeaveDetails(2000), ls[0]);
    assertEquals(new LeaveDetails(2001), ls[1]);
    assertEquals(new LeaveDetails(3000), ls[2]);
  }
/**
 * Tests that a fetch of a specific employee works correctly.
 * @param dao mocking the dao class
 */
  @Test
  public final void testApplyLeave(@Mocked final LeaveDetailsDAO dao) {
    Date lAppliedOn1 = null;
    //final String adate = "2018-02-02";
    //Date lAppliedOn = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d1 = new Date();
    String adate = sdf.format(d1);
    try {
      lAppliedOn1 = sdf.parse(adate);
    } catch (Exception e) {
    }
    new Expectations() {
      {
        LeaveType lt = LeaveType.EL;
        LeaveStatus ls = LeaveStatus.PENDING;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String sdate1 = "2018-04-10";
        String edate1 = "2018-04-12";
        Date d1 = new Date();
        String adate1 = sdf1.format(d1);
        Date startDate1 = null;
        Date endDate1 = null;
        Date lAppliedOn1 = null;
        try {
          startDate1 = sdf1.parse(sdate1);
          endDate1 = sdf1.parse(edate1);
          lAppliedOn1 = sdf1.parse(adate1);
        } catch (Exception e) {
        }
        int res = dao.insertRecord(lt, startDate1, endDate1, 2, ls, "sick", lAppliedOn1, 1000);
        result = res;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int r = LeaveDetails.applyLeave(1000, LeaveType.EL, "2018-04-10",
        "2018-04-12", 2, LeaveStatus.PENDING,
        "sick", lAppliedOn1);
    assertEquals(0, r);
    assertNotEquals(1, r);
  }
}
