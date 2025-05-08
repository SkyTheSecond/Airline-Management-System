package entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Plane {

    private String planeId;

    private String planeNumber;

    private List<List<Integer>> seats;

    private Map<String, Time> airportTimes;

    private List<String> airports;

    public Plane(String planeId, String planeNumber, List<List<Integer>> seats, Map<String, Time> airportTimes, List<String> airports){
        this.planeId = planeId;
        this.planeNumber = planeNumber;
        this.seats = seats;
        this.airportTimes = airportTimes;
        this.airports = airports;
    }

    public List<String> getAirports(){
        return airports;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats){
        this.seats = seats;
    }

    public Strng getPl

}
