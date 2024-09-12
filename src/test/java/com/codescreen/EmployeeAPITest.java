package com.codescreen;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.patch;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;

/**
 * Add your test cases here to test that the Employee API endpoints are all working properly.
 *
 * We provide one test case below to show you how to authenticate with the API and use the Rest Asssured library.
 */

@Order(1) //Do not edit the value of this Order annotation.
public class EmployeeAPITest {

  private static final String API_KEY = "e5854134-3a6f-44f8-ae96-434748e943f4";
  

  @BeforeAll
  static void setup() {
    RestAssured.baseURI = "https://assessments.codescreen.com/api/employees";
  }

  @Test
  public void testCreate() {
    String email = "jon.smith" + UUID.randomUUID() + "@example.com";
    with().body(new Employee(email, "Jon Smith", "Software Developer"))
            .header("X-API-KEY", API_KEY)
            .when()
            .request("POST")
            .then()
            .statusCode(201);
  }

  @Test
  public void testGetEmployees()
  {
     with().header("X-API-KEY", API_KEY)
     .request("GET")
     .then()
     .statusCode(200);
  }

  @Test
  public void testGetEmployeewithId()
  {
     with().param("Id","820678ae-0ec3-479d-80f8-9cc36666e4f8")
     .header("X-API-KEY", API_KEY)
     .request("GET")
     .then()
     .statusCode(200);
  }

  @Test
  public void testPatchEmployeewithId()
  {

    given()
            .contentType(ContentType.JSON)
            .header("X-API-KEY", API_KEY)
            .body("{\"name\": \"Jon Smith\"}")
            .when()
            .patch("/employees/7a304310-a689-4d50-90f6-7f1887f6d755")
            .then()
            .statusCode(200)
            .body("name", equalTo("Cate"));
  
  }

  @Test
  public void testDeleteEmployeewithId()
  {
    RestAssured.baseURI = "https://assessments.codescreen.com/api/";
        
    given()

        .when()
        .header("X-API-KEY", API_KEY)
        .delete("/employees/c1636511-5b8b-437c-86cb-4052fe173533")
        .then()
        .statusCode(200);
  }

  private static class Employee {
    private String email;
    private String name;
    private String title;

    public Employee(String email, String name, String title) {
      this.email = email;
      this.name = name;
      this.title = title;
    }

    public String getEmail() {
      return email;
    }

    public String getName() {
      return name;
    }

    public String getTitle() {
      return title;
    }

  }
  private static class UpdateEmployee {
    private String name;
    private String title;

    public UpdateEmployee(String name, String title) {
      this.name = name;
      this.title = title;
    }

    public String getName() {
      return name;
    }

    public String getTitle() {
      return title;
    }

  }
}
