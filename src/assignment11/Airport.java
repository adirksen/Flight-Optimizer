package assignment11;

import java.util.HashSet;

/**
 * Represents a vertex when finding the best flight path
 */
public class Airport implements Comparable<Airport>{

  private HashSet<Flight> flights;

  private String origin;

  private boolean visited;

  private Airport previous;


  private double cost;


    public Airport(String origin){
        this.origin = origin;
        this.flights = new HashSet<>();
        this.cost = Double.MAX_VALUE;
        this.visited = false;
    }
/*    public Airport(HashSet<Flight> flights, String  origin, boolean visited, Airport previous, double cost){
        this.flights = flights;
        this.origin = origin;
        this.visited = visited;
        this.previous = previous;
        this.cost = cost;
    }*/


    @Override
    public boolean equals(Object o){
        return o instanceof Airport && this.origin.equals(((Airport) o).origin);
    }
    
    
    @Override
    /**
     *TODO: Cite this shit
     */
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.origin != null ? this.origin.hashCode() : 0);
        return hash;
    }


    /*--- GETTERS AND SETTERS ---*/


    public HashSet<Flight> getFlights(){
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
        return this.visited;
    }

    public void setVisited(boolean _visited) {
        this.visited = _visited;
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


	@Override
	public int compareTo(Airport o) {
		// TODO Auto-generated method stub
        //return Double.compare(((Airport) o).cost, this.cost);
    return Double.compare(this.cost, ((Airport) o).cost);
	}
 
}
