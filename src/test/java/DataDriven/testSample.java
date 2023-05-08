package DataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {
    public static void main(String []args) throws IOException {
        datadriven d=new datadriven();
        ArrayList<String> data=d.getData("Rest","Sheet1");
        System.out.println(data.get(0));
        System.out.println(data.get(1));

     //   System.out.println(data.get(1));



    }
}
