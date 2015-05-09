package something;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import static org.kohsuke.args4j.ExampleMode.ALL;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.regex.Pattern;

import java.io.IOException;

public class Main {

    @Option(name="--width",usage="some width")
    private int width = 40;

    @Option(name="-s",usage="some string")
    private String someString = "default text";

    @Option(name="-d",usage="debug string")
    private String debugString = "default text";

    @Option(name="-e",usage="elephantdebug string")
    private String elephantString = "default text";

    @Argument
    private List<String> arguments = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        new Main().doMain(args);
    }

    public void doMain(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            /* if( arguments.isEmpty() ) */
            /*     throw new CmdLineException(parser,"No argument is given"); */
        } catch( CmdLineException e ) {
            System.err.println(e.getMessage());
            System.err.println("java " + this.getClass().getSimpleName() + " [options...] arguments...");
            // print the list of available options
            parser.printUsage(System.err);
            System.err.println();
            // print option sample. This is useful some time
            System.err.println("  Example: java " + this.getClass().getSimpleName() + " " + parser.printExample(ALL));
            return;
        }


        StringBuilder argStringBuilder = new StringBuilder();
        for(String argument : arguments) {
            argStringBuilder.append("arg: ");
            argStringBuilder.append(argument);
            argStringBuilder.append(" --- ");
            argStringBuilder.append(width*100);
            argStringBuilder.append(System.getProperty("line.separator"));
        }
        System.err.println(argStringBuilder.toString());


        JSONArray jsonArray = new JSONArray();
        JSONParser jsonParser = new JSONParser();

        Scanner stdinScanner = new Scanner(System.in);

        while(stdinScanner.hasNextLine()) {

            while (stdinScanner.hasNextInt()) {
                jsonArray.add(stdinScanner.nextInt() * 10);
            }

            String pattern = ">[^<]*<";
            while (stdinScanner.hasNext(pattern)) {
                String matching = stdinScanner.next(pattern); 
                /* jsonArray.add("matched: " + matching); */
                JSONObject matchingPattern = new JSONObject();
                matchingPattern.put("result","matchted");
                matchingPattern.put("content", matching);
                matchingPattern.put("length", matching.length());
                jsonArray.add(matchingPattern);
            }

            if (stdinScanner.hasNextLine()) {
                String line = stdinScanner.nextLine(); 

                if (line.length() > 0) {
                    try {
                        Object parsedObject = jsonParser.parse(line);
                        if (parsedObject instanceof JSONObject) {
                            JSONObject jsonLine = (JSONObject) parsedObject;
                            jsonArray.add("json:" + jsonLine);
                        } else if (parsedObject instanceof JSONArray) {
                            JSONArray jsonLine = (JSONArray) parsedObject;
                            jsonArray.add("jsonarray:" + jsonLine);
                        }
                    } catch (ParseException ex) {
                        jsonArray.add(">" + line + "<");
                        /* ex.printStackTrace(); */
                    }
                }
            }

        }

        /* JSONObject obj=new JSONObject(); */
        /* obj.put("name","foo"); */
        /* obj.put("num",new Integer(100)); */
        /* obj.put("balance",new Double(1000.21)); */
        /* obj.put("is_vip",new Boolean(true)); */
        /* obj.put("nickname",null); */
        /* System.out.print(obj); */

        /* System.out.println(jsonArray); */

        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append(jsonArray);
        /* for( int i=0; i < 20; i ++ ) { */
        /*     stringBuilder.insert(0,i); */
        /*     stringBuilder.append("number: "); */
        /*     stringBuilder.append(i); */
        /*     stringBuilder.append("bla bla "); */
        /*     stringBuilder.append(System.getProperty("line.separator")); */
        /* } */

        System.out.println(stringBuilder.toString());

    }

}
