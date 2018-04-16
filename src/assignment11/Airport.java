package assignment11;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vertex when finding the best flight path
 */
public class Airport {

  private List<Flight> flights;

  private String origin;

  private boolean visited;

  private Airport previous;

  private String location;

  private double cost;


    public Airport(String origin){
        this.origin = origin;
        this.flights = new ArrayList<>();
        this.cost = Double.MAX_VALUE;
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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Airport getPrevious() {
        return previous;
    }

    public void setPrevious(Airport previous) {
        this.previous = previous;
    }


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
