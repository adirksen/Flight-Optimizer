package assignment11;

/**
 * Represents a vertex when finding the best flight path
 */
public class Airport implements Comparable<Airport> {

  private String origin;

  private boolean visited;

  private Airport previous;

  private double cost;


  public Airport(String origin) {
    this.origin = origin;
    this.cost = Double.MAX_VALUE;
    this.visited = false;
  }


  @Override
  public boolean equals(Object o) {
    return o instanceof Airport && this.origin.equals(((Airport) o).origin);
  }


  @Override
  /*
   *    Title: Hashcode Override
   *    Author: Vern
   *    Date: 2018
   *    Code version: Now 30 2011
   *    Availability: https://stackoverflow.com/questions/8322129/arraylists-custom-contains-method
   */
  public int hashCode() {
    int hash = 7;
    hash = 17 * hash + (this.origin != null ? this.origin.hashCode() : 0);
    return hash;
  }


  /*--- GETTERS AND SETTERS ---*/

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
    return Double.compare(this.cost, ((Airport) o).cost);
  }

}
