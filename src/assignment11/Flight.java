package assignment11;

/**
 * Represents an edge when finding the best flight path
 */
public class Flight {

  private String origin, destination, carrier, delay, cancel, time, distance, cost;
  private double edgeWeight;

  public Flight(String origin, String destination, String carrier, String delay, String cancel, String time, String distance, String cost){
      this.origin = origin;
      this.destination = destination;
      this.carrier = carrier;
      this.delay = delay;
      this.cancel = cancel;
      this.time = time;
      this.distance = distance;
      this.cost = cost;
  }


  public double getEdgeWeight(FlightCriteria criteria) {
    switch (criteria) {
      case TIME:
        edgeWeight = Double.parseDouble(time);
        break;
      case DISTANCE:
        edgeWeight = Double.parseDouble(distance);
        break;
      case DELAY:
        edgeWeight = Double.parseDouble(delay);
        break;
      case CANCELED:
        edgeWeight = Double.parseDouble(cancel);
        break;
    }
    return edgeWeight;
  }

  public void setEdgeWeight(float edgeWeight) {
    this.edgeWeight = edgeWeight;
  }


  /*--- FIELD SETTERS ---*/
  
  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  public void setDelay(String delay) {
    this.delay = delay;
  }

  public void setCancel(String cancel) {
    this.cancel = cancel;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public void setDistance(String distance) {
    this.distance = distance;
  }

  public void setCost(String cost) {
    this.cost = cost;
  }



  /*--- FIELD GETTERS ---*/

  public String getOrigin() {
    return this.origin;
  }

  public String getDestination() {
    return this.destination;
  }

  public String getDelay() {
    return this.delay;
  }

  public String getCancel() {
    return this.cancel;
  }

  public String getTime() {
    return this.time;
  }

  public String getDistance() {
    return this.distance;
  }

  public String getCost() {
    return this.cost;
  }


}
