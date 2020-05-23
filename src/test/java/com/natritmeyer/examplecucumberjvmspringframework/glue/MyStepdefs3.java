package com.natritmeyer.examplecucumberjvmspringframework.glue;

import com.natritmeyer.examplecucumberjvmspringframework.aut.implementations.desktop.ScenarioContext;
import io.cucumber.java8.En;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.requestSpecification;

public class MyStepdefs3 implements En {

    @Autowired
    private ScenarioContext context;

    public MyStepdefs3() {
        Given("^perform another api testing$", () -> {

            RequestSpecification requestSpecification = RestAssured.given();
            System.out.println(" Frmawork **** SessionID value received: "+ context.getSaveToMe());
//        System.out.println(" Frmawork **** SessionID value received: "+scenarioContextClass.getSenarioContext("SessionID"));
            requestSpecification.cookie("ASP.NET_SessionId", context.getSaveToMe());
            Response response_authValidate = requestSpecification.get("https://demo.meddbase.com/patientportalapi/auth/validate?Client-key=api-lgpdev");
            System.out.println("***** GET response [response_authValidate]:  "+response_authValidate.jsonPath().prettyPrint());

        });
    }
}
