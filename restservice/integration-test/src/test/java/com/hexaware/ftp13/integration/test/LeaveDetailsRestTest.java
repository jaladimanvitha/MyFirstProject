package com.hexaware.ftp13.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.net.URISyntaxException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;
public class LeaveDetailsRestTest {
    @Test
	public void testgetEmpText() {
		String res = given().accept(ContentType.TEXT).when()
				.get("http://localhost:8080/ftp13-0.0.1-SNAPSHOT/api/leavedetails/applyleave/2000/2018-02-14/2018-02-16/sick").getBody().asString();
		assertEquals("record inserted successfully", res);
    }
    @Test
    public void testLeaveDetailsListId() throws AssertionError, URISyntaxException, ParseException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/leaveapp/2000"))
                .getBody().as(LeaveDetails[].class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LeaveDetails ld = res[0];        
        assertEquals(1, ld.getLeaveId());
        assertEquals(sdf.parse("2017-08-10"), ld.getStartDate());
        assertEquals(1, ld.getLeaveId());
        assertEquals(2, res.length);
        assertEquals(2000, ld.getEmpId());
        assertNotEquals(25, ld.getLeaveId());
	}
    @Test
	public void testLeaveDetailsListByMngrId() throws AssertionError, URISyntaxException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //Date sdate = null;
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
            .get(CommonUtil.getURI("/api/leavedetails/pending/1000")).getBody().as(LeaveDetails[].class);
		assertEquals(1, res.length);
        LeaveDetails ld1 = res[0];
        assertEquals(13,ld1.getLeaveId());
        assertEquals(3, ld1.getNoOfDays());
        assertEquals("sick",ld1.getLeaveReason());
        assertNotEquals(sdf.parse("2018-02-15"), ld1.getStartDate());
        assertNotEquals(sdf.parse("2018-02-18"), ld1.getEndDate());
        assertNotEquals(sdf.parse("2018-01-31"), ld1.getLeaveAppliedOn());
        assertNull(ld1.getManagerComments());
        assertEquals(2001, ld1.getEmpId());
  }
   @Test
	public void testLeaveDetailsListByMngrId404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/pending/8888")).then().assertThat().statusCode(404);
	}
   /**
   * Tests that a fetch of a specific LeaveDetails works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testManager(@Mocked final LeaveDetailsDAO dao) {
    final LeaveDetails l100 = new LeaveDetails(100);
    new Expectations() {
      {
        dao.findManager(100); result = l100;
        dao.findManager(-1); result = null;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] l = LeaveDetails.manager(100);
    assertEquals(l100, l[0]);
    try {
      assertNull(LeaveDetails.manager(-1));
    } catch (Exception e) {
    }
  }
   @Test
    public void testApproveOrDeny() throws URISyntaxException {
        String str = given().accept(ContentType.TEXT).when()
				.get("http://localhost:8080/ftp13-0.0.1-SNAPSHOT/api/leavedetails/approveordeny/1/APPROVED/ok").getBody().asString();
        assertEquals("Updated the leave Application", str);
    }
  @Test
	public void testleaveDetailsListById() throws AssertionError, URISyntaxException, ParseException{
		Employee[] e = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/listbyid/2000")).getBody().as(Employee[].class);
		Employee e1 = e[0];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(3000, e1.getEmpId());
		assertNotEquals(3001, e1.getEmpId());
		assertEquals(2000, e1.getEmpManagerId());
		assertEquals("GayathriG@hexaware.com", e1.getEmpEmail());
		assertNotEquals(sdf.parse("2017-12-19"), e1.getEmpDoj());
		assertEquals("GAYATHRI", e1.getEmpName());
		assertEquals(1234567899, e1.getEmpPhone());
		assertEquals("EMPLOYEE", e1.getEmpDept());
		assertEquals(4, e1.getEmpLeaveBalance());
	}

   @Test
	public void testLeaveDetailsById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/9999")).then().assertThat().statusCode(404);
	}
}
