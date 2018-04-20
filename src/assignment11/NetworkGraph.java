package assignment11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * <p>
 * This class represents a graph of flights and airports along with specific data about those
 * flights. It is recommended to create an airport class and a flight class to represent nodes and
 * edges respectively. There are other ways to accomplish this and you are free to explore those.
 * </p>
 * <p>
 * <p>
 * Testing will be done with different criteria for the "best" path so be sure to keep all
 * information from the given file. Also, before implementing this class (or any other) draw a
 * diagram of how each class will work in relation to the others. Creating such a diagram will help
 * avoid headache and confusion later.
 * </p>
 * <p>
 * <p>
 * Be aware also that you are free to add any member variables or methods needed to completed the
 * task at hand
 * </p>
 *
 * @author CS2420 Teaching Staff - Spring 2018
 */
public class NetworkGraph {
    // Represents Priority Queue that will be used to find best path

    public HashMap<Airport, HashSet<Flight>> airports = new HashMap<>();

    /**
     * <p>
     * Constructs a NetworkGraph object and populates it with the information contained in the given
     * file. See the sample files or a randomly generated one for the proper file format.
     * </p>
     * <p>
     * <p>
     * You will notice that in the given files there are duplicate flights with some differing
     * information. That information should be averaged and stored properly. For example some times
     * flights are canceled and that is represented with a 1 if it is and a 0 if it is not. When
     * several of the same flights are reported totals should be added up and then reported as an
     * average or a probability (value between 0-1 inclusive).
     * </p>
     *
     * @param flightInfo - The inputstream to the flight data. The format is a *.csv(comma separated
     *                   value) file
     */
    public NetworkGraph(InputStream flightInfo) {
        InputStreamReader flightArg = new InputStreamReader(flightInfo);
        BufferedReader bufferedReader = new BufferedReader(flightArg);
        String line;
        try {
            bufferedReader.readLine(); // Get Rid of header
            while ((line = bufferedReader.readLine()) != null) {
                String[] row = line.split(",");

                Airport originAirport = new Airport(row[0]);//the first airport we see in regards to origin

                Flight flight = new Flight(row[0], row[1], row[2], row[3], row[4],
                        row[5], row[6], row[7]);

                HashSet<Flight> flights = new HashSet<>();

                flights.add(flight);

                // If the airport is not in the HashMap, put the flight at the value
                if (!airports.containsKey(originAirport)) {
                    airports.put(originAirport, flights);
                }

                // If we encounter a duplicate flight
                else if (airports.get(originAirport).contains(flight)) {

                    HashSet<Flight> tempAverageFlights = airports.get(originAirport);

                    for (Flight f : tempAverageFlights) {
                        if (f.equals(flight)) {
                            // Calculates the average values for the given flight in relation to the number of vertices
                            f.addToEdgeWeight(flight);
                            break;
                        }
                    }
                } else {
                    airports.get(originAirport).add(flight);
                }
            }
            bufferedReader.close();
            for (Airport airport : airports.keySet()) {
                for (Flight flight : airports.get(airport)) {
                    if (flight.getCurrSize() > 1) {
                        flight.duplicateFlightAverages(flight);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns a BestPath object containing information about the best way to fly to the
     * destination from the origin. "Best" is defined by the FlightCriteria parameter
     * <code>enum</code>. This method should throw no exceptions and simply return a BestPath object
     * with information dictating the result. If the destination or origin is not contained in this
     * instance of NetworkGraph, simply return a BestPath object with an empty path (not a
     * <code>null</code> path) and a path cost of 0. If origin or destination are
     * <code>null</code>, also return a BestPath object with an empty path and a
     * path cost of 0 . If there is no path in this NetworkGraph from origin to destination, also
     * return a BestPath with an empty path and a path cost of 0.
     *
     * @param origin      - The starting location to find a path from. This should be a 3 character long
     *                    string denoting an airport.
     * @param destination - The destination location from the starting airport. Again, this should be
     *                    a 3 character long string denoting an airport.
     * @param criteria    - This enum dictates the definition of "best". Based on this value a path
     *                    should be generated and return.
     * @return - An object containing path information including origin, destination, and everything
     * in between.
     */
    public BestPath getBestPath(String origin, String destination, FlightCriteria criteria) {

        BestPath best = new BestPath(new ArrayList<>(), 0);

        if (origin == null || destination == null) {
            return best;
        }

        Airport _origin = new Airport(origin);
        Airport _destination = new Airport(destination);
        // Determines if the origin or destination are contained in this instance of NetworkGraph.
        if (!(airports.containsKey(_origin) || airports.containsKey(_destination))) {
            // If the destination or origin are not contained in this instance, return empty BestPath object
            return best;
        }

        return dijkstra(_origin, _destination, criteria, null);
    }

    /**
     * <p>
     * This overloaded method should do the same as the one above only when looking for paths skip the
     * ones that don't match the given airliner.
     * </p>
     *
     * @param origin      - The starting location to find a path from. This should be a 3 character long
     *                    string denoting an airport.
     * @param destination - The destination location from the starting airport. Again, this should be
     *                    a 3 character long string denoting an airport.
     * @param criteria    - This enum dictates the definition of "best". Based on this value a path
     *                    should be generated and return.
     * @param airliner    - a string dictating the airliner the user wants to use exclusively. Meaning no
     *                    flights from other airliners will be considered.
     * @return - An object containing path information including origin, destination, and everything
     * in between.
     */
    public BestPath getBestPath(String origin, String destination, FlightCriteria criteria,
                                String airliner) {

        BestPath best = new BestPath(null, 0.0);

        if (origin == null || destination == null || airliner == null) {
            return best;
        }

        Airport _origin = new Airport(origin);
        Airport _destination = new Airport(destination);
        // Determines if the origin or destination are contained in this instance of NetworkGraph.
        if (!(airports.containsKey(_origin) || airports.containsKey(_destination))) {
            // If the destination or origin are not contained in this instance, return empty BestPath object
            return best;
        }

        return dijkstra(_origin, _destination, criteria, airliner);

    }

    /**
     * //TODO: JavaDocs
     */
    private Airport findAirportInMap(String airport) {
        for (Airport air : airports.keySet()) {
            if (air.getOrigin().equals(airport)) {
                return air;
            }
        }
        return null;
    }

    /**
     * Performs dijkstra's shortest-path algorithm on a given set of criteria
     */
    private BestPath dijkstra(Airport start, Airport goal, FlightCriteria criteria, String airline) {
        // Represents Priority Queue that will be used to find best path
        PriorityQueue<Airport> PQ = new PriorityQueue<>();

        ArrayList<String> bestPath = new ArrayList<>();

        // initialize all nodes and priority queue
        Airport curr = null;
        start.setCost(0);
        PQ.add(start);

        while (!PQ.isEmpty()) {
            curr = PQ.poll();
            if (curr == null) {
                continue;
            }
            if(curr.getCost() < 0 && !curr.equals(goal)){
                continue;
            }else if(curr.equals(goal) && curr.getCost() < 0){
                return new BestPath(new ArrayList<>(), 0);

            }
            if (curr.equals(goal)) {
                //goal found, set goal to the current node in the PriorityQueue
                goal = curr;
                break;
            }
            curr.setVisited(true);

            Airport destination;
            Iterator<Flight> it = airports.get(curr).iterator();

            while (it.hasNext()) {
                Flight flight1 = it.next();
                destination = flightDestination(flight1);
                // If destination is not a viable path, go to next node
                if (destination == null) {
                    continue;
                }

               // airports.replace(destination, airports.get(destination));

                // If the airliner is a criteria
                if (airline != null) {
                    // ensure the airliner is the same for the flight
                    if (!destination.isVisited()) {
                        if (flight1.getCarriers().contains(airline)) {
                            if (curr.getCost() + flight1.getEdgeWeight(criteria) < destination.getCost()) {
                                PQ.add(destination);
                                destination.setPrevious(curr);
                                destination.setCost(curr.getCost() + flight1.getEdgeWeight(criteria));
                            }
                        }
                    }
                } else {
                    if (!destination.isVisited()) {
                        if (curr.getCost() + flight1.getEdgeWeight(criteria) < destination.getCost()) {
                            PQ.add(destination);
                            destination.setPrevious(curr);
                            destination.setCost(curr.getCost() + flight1.getEdgeWeight(criteria));
                        }
                    }
                }
            }
        }
        while (curr != null) {
            bestPath.add(curr.getOrigin());
            curr = curr.getPrevious();
        }
        Collections.reverse(bestPath);

        return new BestPath(bestPath, goal.getCost());
    }

    /**
     * Finds the destination airport where the given flight lands
     */
    public Airport flightDestination(Flight flight) {
        Iterator<Entry<Airport, HashSet<Flight>>> it = airports.entrySet().iterator();
        //iterate through every airport
        while (it.hasNext()) {
            Map.Entry<Airport, HashSet<Flight>> pair = it.next();
            //if the airport is the same as the flight destination
            if (pair.getKey().getOrigin().equals(flight.getDestination())) {
                //return the airport
                return pair.getKey();
            }
        }
        return null;
    }

}
