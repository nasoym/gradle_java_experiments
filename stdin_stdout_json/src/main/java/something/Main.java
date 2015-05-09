package something;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        JSONArray jsonArray = new JSONArray();
        Scanner stdinScanner = new Scanner(System.in);
        while(stdinScanner.hasNextLine()) {

            while (stdinScanner.hasNextInt()) {
                jsonArray.add(stdinScanner.nextInt() * 10);
            }

            if (stdinScanner.hasNextInt()) {
                jsonArray.add(stdinScanner.nextInt() * 10);
            /* } else if (stdinScanner.hasNext("^$")) { */
            /*     #<{(| String matching = stdinScanner.nextLine();  |)}># */
            /*     jsonArray.add("empty line"); */
            } else if (stdinScanner.hasNext("^>:.*AA")) {
                String matching = stdinScanner.next(); 
                jsonArray.add("matched: " + matching);
            /* } else { */
            /*     jsonArray.add(stdinScanner.nextLine()); */
            }
            /* String line = stdinScanner.nextLine();  */
            /* if (stdinScanner.hasNext()) { */
                String line = stdinScanner.nextLine(); 
                /* String line = stdinScanner.next();  */
                if (line.length() > 0) {
                    jsonArray.add(">" + line + "<");
                }
            /* } */

        }

        /* JSONObject obj=new JSONObject(); */
        /* obj.put("name","foo"); */
        /* obj.put("num",new Integer(100)); */
        /* obj.put("balance",new Double(1000.21)); */
        /* obj.put("is_vip",new Boolean(true)); */
        /* obj.put("nickname",null); */
        /* System.out.print(obj); */

        System.out.println(jsonArray);
    }

}
