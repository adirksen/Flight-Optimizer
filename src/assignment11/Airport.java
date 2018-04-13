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
    public List<Flight> getFlights(){
        return this.flights;
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



  


}
