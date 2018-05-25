import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static AdjacencyMatrixGraph graph;

    public static void main(String[] args) {
        Reader reader = new Reader();

        graph = reader.createGraph();
        System.out.println();
        dialogue();
    }

    static void menu() {
        System.out.println(
                "1. Display airport information\n" +
                        "2. Find a cheapest flight from one airport to another airport\n" +
                        "3. Add a flight from one airport to another airport\n" +
                        "4. Delete a flight from one airport to another airport\n" +
                        "5. Find a cheapest roundtrip from one airport to another airport"
        );
    }

    static void dialogue() {

        char choice;
        boolean on = true;

        while (on) {
            menu();
            try {
                choice = in.next().charAt(0);
                switchMenu(choice);
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
        in.close();
    }

    public static void switchMenu(char c) {
        String a, b;
        switch (c) {
            case '1':
                System.out.println("Enter the airport code: ");
                a = in.next();
                graph.displayAirportInfo(a.toUpperCase()); //<--- not triggering
                break;
            case '2':
                System.out.println("Enter the airport codes: ");
                a = in.next().toUpperCase();
                b = in.next().toUpperCase();
                graph.cheapestRoute(a, b);
                break;
            case '3':
                System.out.println("Enter the airport codes and the price of the flight: ");
                a = in.next().toUpperCase();
                b = in.next().toUpperCase();
                double v = in.nextDouble();
                graph.addFlight(a, b, v);
                break;
            case '4':
                System.out.println("Enter airport codes to remove: ");
                a = in.next();
                b = in.next();
                graph.removeEdge(a, b);
                break;
            case '5':
                System.out.println("Enter airport codes: ");
                a = in.next();
                b = in.next();
                graph.cheapestRoundTrip(a, b);
                break;
            case '6':
                graph.displayGraph();
                break;

            case 'q':
                System.exit(0);
            case 'Q':
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input - or option not available.\n");
        }
    }
}
