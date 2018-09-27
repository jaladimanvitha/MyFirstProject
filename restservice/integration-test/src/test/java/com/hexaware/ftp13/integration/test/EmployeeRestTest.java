package com.hexaware.ftp13.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.ParseException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class EmployeeRestTest {
	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException {
		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
		for (Employee e: res) {
			switch (e.empId) {
				case 1000:
					assertEquals(new Employee(1000), e);
					break;
				case 2000:
					assertEquals(new Employee(2000), e);
					break;				
				case 2001:
					assertEquals(new Employee(2001), e);
					break;				
				case 3000:
					assertEquals(new Employee(3000), e); 
					break;				
				case 3001:
					assertEquals(new Employee(3001), e);
					break;			
				default:
					fail("Unknown employee with id:" + e);	
			}
		}
	}

	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException, ParseException {
		Employee res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/2001")).getBody().as(Employee.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(new Employee(2001,"SHRADDHA",82977201,"ShraddhaG@hexaware.com","MANAGER",1000,9,sdf.parse("2017-12-20")), res);
  }
    @Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);

	}
}
