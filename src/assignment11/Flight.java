package assignment11;

/**
 * Represents an edge when finding the best flight path
 */
public class Flight {

	private Airport origin, destination;
    private String  carrier, delay, cancel, time, distance, cost;
    private double edgeWeight;

    public Flight(Airport origin, Airport destination, String carrier, String delay, String cancel, String time, String distance, String cost) {
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

    public void setCost(String cost) {
        this.cost = cost;
    }


    /*--- FIELD GETTERS ---*/

    public Airport getOrigin() {
        return this.origin;
    }

    public Airport getDestination() {
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
     * @param currSize - Current size of the HashSet
     */
    public void DuplicateFlightAverages(Flight flight, int currSize) {
    	this.delay = parseAvg(flight.getDelay(), currSize);
    	this.distance = parseAvg(flight.getDistance(), currSize);
    	this.cancel = parseAvg(flight.getCancel(), currSize);
    	this.time = parseAvg(flight.getTime(), currSize);
    	this.cost = parseAvg(flight.getCost(), currSize);
    	
    }
    
    /**
     * Parses a given String as a double 
     * @param criteria
     * @return - average value of given criteria relative to the whole set
     */
    private String parseAvg(String criteria, int currSize) {

    	return Double.toString((Double.parseDouble(criteria) * currSize) + (Double.parseDouble(criteria) / (currSize + 1)));

    }


}
