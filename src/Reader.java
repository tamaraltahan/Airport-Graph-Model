import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader {



    private static final String AIRPORTS = "C:\\Users\\Tamar\\Downloads\\P4Airports.txt";
    private static final String FLIGHTS = "C:\\Users\\Tamar\\Downloads\\P4Flights.txt";




    public static void read(String FILENAME) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            int lines = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                lines++;
            }

            List<Node> nodeList = new ArrayList<>();

            while ((sCurrentLine = br.readLine()) != null) {
                String[] line = sCurrentLine.split("\\s+");
                for (int i = 0; i < line.length; i++) {
                    nodeList.add(new Node(Integer.parseInt(line[0]),line[1],line[2]));
                }
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}