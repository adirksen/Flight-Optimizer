package assignment11;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vertex when finding the best flight path
 */
public class Airport {

  private List<Flight> flights;

  private String origin;

  private static boolean visited;

  private Airport previous;

  private String location;

  private static double weight;


    public Airport(String origin){
        this.origin = origin;
        this.flights = new ArrayList<>();

    }


    @Override
    public boolean equals(Object o){
        return o instanceof Airport && this.origin.equals(((Airport) o).origin);
    }

 /*   @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.origin != null ? this.origin.hashCode() : 0);
        return hash;
    }*/


    /*--- GETTERS AND SETTERS ---*/

    public static double getWeight() {
      return weight;
    }

    public static void setWeight(double newWeight) {
      weight = newWeight;
    }

    public List<Flight> getFlights(){
        return this.flights;
    }

    public String getLocation() {
      return this.location;
    }

    public void setLocation(String location) {
      this.location = location;
    }

    public void addFLight(Flight flight){
        flights.add(flight);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public static boolean isVisited() {
        return visited;
    }

    public static void setVisited(boolean _visited) {
        visited = _visited;
    }

    public Airport getPrevious() {
        return previous;
    }

    public void setPrevious(Airport previous) {
        this.previous = previous;
    }



  


}
