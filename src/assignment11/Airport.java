package assignment11;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private List<Flight> flights = new ArrayList<>();
    private String airliner;
    private String location;

    public String getAirliner() {
        return airliner;
    }

    public void setAirliner(String airliner) {
        this.airliner = airliner;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
