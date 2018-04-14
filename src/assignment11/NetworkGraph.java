package assignment11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <p>This class represents a graph of flights and airports along with specific
 * data about those flights. It is recommended to create an airport class and a
 * flight class to represent nodes and edges respectively. There are other ways
 * to accomplish this and you are free to explore those.</p>
 * <p>
 * <p>Testing will be done with different criteria for the "best" path so be
 * sure to keep all information from the given file. Also, before implementing
 * this class (or any other) draw a diagram of how each class will work in
 * relation to the others. Creating such a diagram will help avoid headache and
 * confusion later.</p>
 * <p>
 * <p>Be aware also that you are free to add any member variables or methods
 * needed to completed the task at hand</p>
 *
 * @author CS2420 Teaching Staff - Spring 2018
 */
public class NetworkGraph {

    // Represents Priority Queue that will be used to find best path
    PriorityQueue<Airport> PQ = new PriorityQueue<>();

    List<Airport> airports = new ArrayList<>();

    /**
     * <p>Constructs a NetworkGraph object and populates it with the information
     * contained in the given file. See the sample files or a randomly generated
     * one for the proper file format.</p>
     * <p>
     * <p>You will notice that in the given files there are duplicate flights with
     * some differing information. That information should be averaged and stored
     * properly. For example some times flights are canceled and that is
     * represented with a 1 if it is and a 0 if it is not. When several of the same
     * flights are reported totals should be added up and then reported as an
     * average or a probability (value between 0-1 inclusive).</p>
     *
     * @param flightInfo - The inputstream to the flight data. The format is a
     *                   *.csv(comma separated value) file
     */
    public NetworkGraph(InputStream flightInfo) {
        //TODO: Implement a constructor that reads in the file and stores the information
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(flightInfo));
        String line;
        try {
            bufferedReader.readLine(); //Get Rid of header
            while ((line = bufferedReader.readLine()) != null) {
                String[] row = line.split(",");
                Flight flight = new Flight(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7]);
                Airport newAirport = new Airport(row[0]);
                if(!airports.contains(newAirport)){
                    newAirport.addFLight(flight);
                    airports.add(new Airport(row[0]));
                }else{
                    for(Airport airport : airports)
                        if(airport.equals(newAirport)) airport.addFLight(flight);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 		appropriately in this object.
    }

    /**
     * This method returns a BestPath object containing information about the best
     * way to fly to the destination from the origin. "Best" is defined by the
     * FlightCriteria parameter <code>enum</code>. This method should throw no
     * exceptions and simply return a BestPath object with information dictating
     * the result. If the destination or origin is not contained in this instance of
     * NetworkGraph, simply return a BestPath object with an empty path
     * (not a <code>null</code> path) and a path cost of 0. If origin or destination
     * are <code>null</code>, also return a BestPath object with an empty path and a
     * path cost of 0 .  If there is no path in this NetworkGraph from origin to
     * destination, also return a BestPath with an empty path and a path cost of 0.
     *
     * @param origin      - The starting location to find a path from. This should be a
     *                    3 character long string denoting an airport.
     * @param destination - The destination location from the starting airport.
     *                    Again, this should be a 3 character long string denoting an airport.
     * @param criteria    - This enum dictates the definition of "best". Based on this
     *                    value a path should be generated and return.
     * @return - An object containing path information including origin, destination,
     * and everything in between.
     */
    public BestPath getBestPath(String origin, String destination, FlightCriteria criteria) {
        //TODO: First figure out what kind of path you need to get (HINT: Use a switch!) then
        //		Search for the shortest path using Dijkstra's algorithm.
        return null;
    }

    /**
     * <p>This overloaded method should do the same as the one above only when looking for paths
     * skip the ones that don't match the given airliner.</p>
     *
     * @param origin      - The starting location to find a path from. This should be a
     *                    3 character long string denoting an airport.
     * @param destination - The destination location from the starting airport.
     *                    Again, this should be a 3 character long string denoting an airport.
     * @param criteria    - This enum dictates the definition of "best". Based on this
     *                    value a path should be generated and return.
     * @param airliner    - a string dictating the airliner the user wants to use exclusively. Meaning
     *                    no flights from other airliners will be considered.
     * @return - An object containing path information including origin, destination,
     * and everything in between.
     */
    public BestPath getBestPath(String origin, String destination, FlightCriteria criteria, String airliner) {
        //TODO:
        for (Airport airport : airports) {
            if (airport.getOrigin().equals(origin)) {
                //pass dikstrajs(airport, destination, criteria, airliner)
            }

        }
        return null;
    }

  private void dijkstra(Airport start, Airport goal, FlightCriteria criteria, String airline) {
    // Represents Priority Queue that will be used to find best path
    PriorityQueue<Airport> PQ = new PriorityQueue<>();

    // initialize all nodes and priority queue

    Airport curr;
    PQ.add(start);

    while(!PQ.isEmpty()) {
      curr = PQ.poll();
      if (curr.getLocation().compareTo(goal.getLocation()) == 0) {
        // return because goal found
        curr.setVisited(true);
        /**
         * for each unvisited neighbor n of curr: {
         * if(n.cost > curr.cost + cost(curr, n) {
         *     PQ.enqueue(n) || update n's priority
         *     n.previous = curr;
         *     n.cost = curr.cost + cost(curr, n)
         * }
         *}
         */
        return;
      }
    }
  }


}
