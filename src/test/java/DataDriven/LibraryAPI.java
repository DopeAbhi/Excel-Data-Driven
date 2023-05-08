package DataDriven;
import io.restassured.RestAssured;
import com.google.common.annotations.VisibleForTesting;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.config.LogConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class LibraryAPI {
    @Test
    public void addBook() throws IOException
    {
        HashMap <String, Object> map=new HashMap<>();
        datadriven d=new datadriven();
        ArrayList data=d.getData("Rest","Sheet1");

        map.put("name",data.get(1));
        map.put("isbn",data.get(2));
        map.put("aisle",data.get(3));
        map.put("author",data.get(4));




       /* map.put("name","abhay");                                              //Hashmap Method
        map.put("isbn","aksfhhhay");
        map.put("aisle","12345ujk6");
        map.put("author","Raju Singh");
        /*
        /*
        HashMap<String, Object> map2=new HashMap<>();
        map2.put("lat","32");                                      //For Nested Json
        map2.put("lng","34");
        map.put("location",map2);

         */

        RestAssured.baseURI="http://216.10.245.166";
     Response resp=  given().header("Content-Type","application/json").
                /*body("{\n" +
                        "\n" +                                                          //Normal Method
                        "\"name\":\"Learn Appium Automation with Java\",\n" +
                        "\"isbn\":\"bcd6355\",\n" +
                        "\"aisle\":\"227\",\n" +
                        "\"author\":\"John foe\"\n" +
                        "}")*/

              body(map).when().post("/Library/Addbook.php").then().assertThat().extract().response();
        System.out.println(resp);
        JsonPath js=ReUsableMethods.rawToJson(resp);
        String id=js.get("ID");
        System.out.println(id);


    }
}
