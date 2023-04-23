import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Simulator {
	
    public static void main(String[] args) {

        final String USAGE = "java Simulator numTrash numCollector rounds [randSeed]";

        boolean DEBUG = false;
        
        //parse arguments
        if(args.length < 3){
            System.out.println("ERROR: missing arguments");
            System.out.println(USAGE);
            System.exit(1);
        }
        int numTrash = Integer.parseInt(args[0]);
        int numCollector = Integer.parseInt(args[1]);
        int rounds = Integer.parseInt(args[2]);

        Random rand;
        if(args.length > 3)
            rand = new Random(Integer.parseInt(args[3]));
        else
            rand = new Random(100);

        if(args.length > 4 && args[4].equals("--DEBUG")){
            DEBUG=true;
        }

        // Populate city with Collectos and trash
        City city= new City(rand, numTrash, numCollector);
        int count = 0;

        //TODO ...
        int N = 100;
        int M = 25;
        //END TODO

        while (count < rounds) {
            count++;

            //TODO...
            //
            // Every N rounds, add trash
            if(count % N == 0){
                city.addTrash();
            }
            
            //Every M rounds, add a collector
            if(count % M == 0){
                city.addCollector();
            }
            //END TODO
            
            city.simulate();
            System.out.println("done "+count);
            System.out.flush();

            if(DEBUG){
                System.err.print("Enter anything to continue: ");
                try{
                    (new BufferedReader(new InputStreamReader(System.in))).readLine();
                }catch(Exception e){
                    System.exit(1);
                }
            }
            
        }
    }
}
