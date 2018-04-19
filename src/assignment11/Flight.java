package assignment11;

/**
 * Represents an edge when finding the best flight path
 */
public class Flight {

  private String origin, destination;
  private String  carrier, delay, cancel, time, distance, cost;
  private double edgeWeight;
  private int currSize;

  public Flight(String origin, String destination, String carrier, String delay, String cancel, String time, String distance, String cost) {
    this.origin = origin;
    this.destination = destination;
    this.carrier = carrier;
    this.delay = delay;
    this.cancel = cancel;
    this.time = time;
    this.distance = distance;
    this.cost = cost;
    currSize = 1;
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
      case PRICE:
        edgeWeight = Double.parseDouble(cost);
        break;
    }
    return edgeWeight;
  }

  @Override
  public boolean equals(Object o) {
    if(o instanceof Flight) {
      return (((Flight) o).getOrigin().equals(this.origin) && ((Flight) o).getDestination().equals(this.destination));
    }
    return false;
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




  /*--- FIELD SETTERS ---*/

  public void setEdgeWeight(float edgeWeight) { this.edgeWeight = edgeWeight; }

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

  public String  getOrigin() {
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


  /**
   * Computes averages when a duplicate flight is encountered
   * @param flight - instance of a duplicate flight
   */
  public void DuplicateFlightAverages(Flight flight) {
    this.delay = parseAvg(this.delay, flight.getDelay(), currSize);
    this.distance = parseAvg(this.distance, flight.getDistance(), currSize);
    this.cancel = parseAvg(this.cancel, flight.getCancel(),  currSize);
    this.time = parseAvg(this.time, flight.getTime(),  currSize);
    this.cost = parseAvg(this.cost, flight.getCost(), currSize);
    this.currSize++;
  }

  /**
   * Parses a given String as a double
   * @param criteria
   * @return - average value of given criteria relative to the whole set
   */
  private String parseAvg(String criteria, String flightData, int currSize) {

    double criteriaD = Double.parseDouble(criteria);
    double flightDataD = Double.parseDouble(flightData);
    double answer = ((criteriaD * currSize) + flightDataD) / (currSize + 1);
    return Double.toString(answer);

  }

}