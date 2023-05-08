package DataDriven;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.InputStream;

public class ReUsableMethods {
    public static JsonPath rawToJson(Response r)
    {
        String respon=r.asString();
        JsonPath x=new JsonPath(respon);
        System.out.println(respon);
        return x;
    }
}
