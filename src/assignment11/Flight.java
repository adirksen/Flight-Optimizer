package assignment11;

public class Flight {
    private String origin, destination, carrier, delay, cancel, time, distance, cost, airliner;
    private double edgeWeight;


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


    //-----FIELD SETTERS---------//
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

    public void setAirliner(String airliner) {
        this.airliner = airliner;
    }
}
