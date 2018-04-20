package assignment11;

import java.util.HashSet;

/**
 * Represents an edge when finding the best flight path
 */
public class Flight {

  private Airport origin, destination;
  private String carrier, delay, cancel, time, distance, price;
  private double edgeWeight;
  private int currSize;
  private HashSet<String> carriers;

  public Flight(Airport origin, Airport destination, String carrier, String delay, String cancel,
      String time, String distance, String price) {
    this.origin = origin;
    this.destination = destination;
    this.carrier = carrier;
    this.delay = delay;
    this.cancel = cancel;
    this.time = time;
    this.distance = distance;
    this.price = price;
    this.currSize = 1;
    carriers = new HashSet<>();
    carriers.add(carrier);
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
        edgeWeight = Double.parseDouble(price);
        break;
    }
    return edgeWeight;
  }

  public void addToEdgeWeight(Flight flight) {
    this.time = String.valueOf(Double.valueOf(flight.getTime()) + Double.valueOf(this.time));
    this.distance = String.valueOf(Double.valueOf(flight.getDistance()) + Double.valueOf(this.distance));
    this.delay = String.valueOf(Double.valueOf(flight.getDelay()) + Double.valueOf(this.delay));
    this.cancel = String.valueOf(Double.valueOf(flight.getCancel()) + Double.valueOf(this.cancel));
    this.price = String.valueOf(Double.valueOf(flight.getPrice()) + Double.valueOf(this.price));
    currSize++;
    carriers.add(flight.getCarrier());
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Flight) {
      return (((Flight) o).getOrigin().equals(this.origin) && ((Flight) o).getDestination()
          .equals(this.destination));
    }
    return false;
  }

  @Override
  /*
   *TODO: Cite this shit
   */
  public int hashCode() {
    int hash = 7;
    hash = 17 * hash + (this.origin != null ? this.origin.hashCode() : 0);
    return hash;
  }


  /*--- FIELD SETTERS ---*/

  public void setEdgeWeight(float edgeWeight) {
    this.edgeWeight = edgeWeight;
  }

  public void setOrigin(Airport origin) {
    this.origin = origin;
  }

  public void setDestination(Airport destination) {
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

  public void setPrice(String price) {
    this.price = price;
  }


  /*--- FIELD GETTERS ---*/

  int getCurrSize() {
    return this.currSize;
  }

  HashSet<String> getCarriers() {
    return this.carriers;
  }

  Airport getOrigin() {
    return this.origin;
  }

  Airport getDestination() {
    return this.destination;
  }

  String getDelay() {
    return this.delay;
  }

  String getCancel() {
    return this.cancel;
  }

  String getTime() {
    return this.time;
  }

  String getDistance() {
    return this.distance;
  }

  String getPrice() {
    return this.price;
  }

  String getCarrier() {
    return this.carrier;
  }


  /**
   * Computes averages when a duplicate flight is encountered
   *
   * @param flight - instance of a duplicate flight
   */
  public void duplicateFlightAverages(Flight flight) {
    this.delay = parseAvg(this.delay, currSize);
    this.distance = parseAvg(this.distance, currSize);
    this.cancel = parseAvg(this.cancel, currSize);
    this.time = parseAvg(this.time, currSize);
    this.price = parseAvg(this.price, currSize);
  }

  /**
   * Parses a given String as a double
   *
   * @return - average value of given criteria relative to the whole set
   */
  private String parseAvg(String criteria, int currSize) {
    double criteriaD = Double.parseDouble(criteria);
    double answer = ((criteriaD) / (currSize));
    return Double.toString(answer);
  }

}
