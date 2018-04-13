package assignment11;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vertex when finding the best flight path
 */
public class Airport {

  private List<Flight> flights = new ArrayList<>();

  private String airliner, location;

  private double cost, time, cancelled;

  private int delay, distance;

  private boolean visited;

  private Airport previous;

  private FlightCriteria criteria;


  /*--- FIELD SETTERS ---*/
  
  public void setAirliner(String airliner) {
    this.airliner = airliner;
  }

  public void setFlights(List<Flight> flights) {
    this.flights = flights;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setDelay(int delay) {
    this.delay = delay;
  }

  public void setCancelled(double cancelled) {
    this.cancelled = cancelled;
  }

  public void setTime(double time) {
    this.time = time;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public void setPrevious(Airport airport) {
    this.previous = airport;
  }

  public void setVisited(boolean state) {
    this.visited = state;
  }

  public void setCriteria(FlightCriteria criteria) {
    this.criteria = criteria;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  /*--- FIELD GETTERS ---*/

  public String getAirliner() {
    return airliner;
  }

  public List<Flight> getFlights() {
    return flights;
  }

  public String getLocation() {
    return location;
  }

  public int getDelay() {
    return this.delay;
  }

  public double getCancelled() {
    return this.cancelled;
  }

  public double getTime() {
    return this.time;
  }

  public double getCost() {
    return this.cost;
  }

  public Airport getPrevious() {
    return this.previous;
  }

  public boolean getVisited() {
    return this.visited;
  }

  public FlightCriteria getCriteria() {
    return this.criteria;
  }

  public int getDistance() {
    return this.distance;
  }


}
