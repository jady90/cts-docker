package com.myi.testutils;

import com.myi.enums.ConfigProperties;
import com.myi.utils.PropertyUtils;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public final class ElkUtils {

    public static void sendDetailsToElk(String testcasename, String status) {
        if (PropertyUtils.getConfigValue(ConfigProperties.SENDRESULTSTOELK)
                .equalsIgnoreCase("yes")) {
            Map<String, String> map = new HashMap<>();
            map.put("testcasename", testcasename);
            map.put("status", status);
            map.put("executiontime", LocalDateTime.now().toString());

            Response response = given().header("Content-Type", "application/json")
                    .log()
                    .all()
                    .body(map)
                    .post("http://localhost:9200/suite/tests");
            Assert.assertEquals(response.statusCode(), 201);
            response.prettyPrint();
        }
    }

    public static void resetElkData() {
        if (PropertyUtils.getConfigValue(ConfigProperties.SENDRESULTSTOELK)
                .equalsIgnoreCase("yes")) {
            Response response = given()
                    .log()
                    .all()
                    .delete("http://localhost:9200/suite");
            Assert.assertEquals(response.statusCode(), 200);
            response.prettyPrint();
        }
    }
}
