package com.hexaware.ftp13.model;

import com.hexaware.ftp13.persistence.EmployeeDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Date;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testEmployee() {
    Employee e100 = new Employee(100);
    Employee e101 = new Employee(101);
    assertNotEquals(e100, null);
    assertNotEquals(e100, new Integer(100));
    assertEquals(e100, new Employee(100));
    assertNotEquals(e101, new Employee(100));
    assertEquals(e100.hashCode(), new Employee(100).hashCode());
    assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
    e101.setEmpId(100);
    assertEquals(e101, new Employee(100));
  }
  /**
   * Tests for toString.
   */
  @Test
  public final void testToString() {
    Employee e = new Employee();
    String s1 = " Emp_Id: " + e.getEmpId() + " Emp_Name: " + e.getEmpName() + " EmpPhone " + e.getEmpPhone()
        + " Emp_Email " + e.getEmpEmail() + " Emp_Dept " + e.getEmpDept() + " Emp_Manager_Id " + e.getEmpManagerId()
        + " Emp_Doj " + e.getEmpDoj() + " Sick_Leave " + e.getSickLeave() + " Parental_Leave " + e.getParentalLeave()
        + " Earned_Leave " + e.getEarnedLeave();
    assertNotEquals(s1, e.toString());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }
  /**
   * Tests the set and get methods.
   */
  @Test
  public final void testSetGet() {
    Employee e = new Employee(3001);
    e.setEmpId(2001);
    e.setEmpName("RAGUL");
    e.setEmpPhone(457892);
    e.setEmpEmail("RagulK@GMAIL.COM");
    e.setEmpDept("FTP");
    e.setEmpManagerId(1000);
    //e.setEmpLeaveBalance(12);
    e.setEmpDoj(new Date(2017, 05, 29));
    int id = e.getEmpId();
    String name = e.getEmpName();
    long phoneno = e.getEmpPhone();
    String email = e.getEmpEmail();
    String dept = e.getEmpDept();
    int mgrId = e.getEmpManagerId();
    //int lbal = e.getEmpLeaveBalance();
    Date d = e.getEmpDoj();
    assertEquals(2001, id);
    assertNotEquals(id, "ss");
    assertNotEquals(id, 3000);
    assertEquals("RAGUL", name);
    assertNotEquals(10, name);
    assertEquals(457892, phoneno);
    assertNotEquals("457892", phoneno);
    assertEquals("RagulK@GMAIL.COM", email);
    assertNotEquals(20, email);
    assertEquals("FTP", dept);
    assertNotEquals(57.5, dept);
    assertEquals(1000, mgrId);
    assertNotNull(mgrId);
    //assertEquals(12, lbal);
    //assertNotEquals("1", lbal);
    assertEquals(new Date(2017, 05, 29), d);
    assertNotEquals(new Date(2020, 05, 29), d);
  }
  /**
   * tests that empty employee list is handled correctly.
   */
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1));
        es.add(new Employee(10));
        es.add(new Employee(100));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1), es[0]);
    assertEquals(new Employee(10), es[1]);
    assertEquals(new Employee(100), es[2]);
  }

    /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }
}

