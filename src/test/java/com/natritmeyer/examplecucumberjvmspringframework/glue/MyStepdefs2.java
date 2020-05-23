package com.natritmeyer.examplecucumberjvmspringframework.glue;

import com.natritmeyer.examplecucumberjvmspringframework.aut.implementations.desktop.ScenarioContext;
import io.cucumber.java8.En;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public class MyStepdefs2 implements En {

    @Autowired
    private ScenarioContext context;

    public MyStepdefs2() {
        Given("^perform api test$", () -> {

            RequestSpecification requestSpecification = RestAssured.given();
            requestSpecification.body("{\"username\": \"roopaworld@yahoo.com\",\"password\": \"Meddbaselogin1\"}");
            Response response_post = requestSpecification.contentType(ContentType.JSON).post("https://demo.meddbase.com/patientportalapi/auth/login?Client-key=lgpdev&isOH=False");
            String post_resp_sessionId = response_post.jsonPath().get("result.SessionID");
            System.out.println("***** POST resp SessionId:  "+post_resp_sessionId);

            context.setSaveToMe(post_resp_sessionId);
            System.out.println("*******  Retrievfed sessionID from Context class = " + context.getSaveToMe());

            System.out.println("POST method ----> Time now is: "+ Instant.now());
            Thread.sleep(300);
        });
    }
}
