package com.fresco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Passenger {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    float fare;

    public Passenger(int id, float fare) {
        this.id = id;
        this.fare = fare;
    }
}

public class BusProb {

    public String output(int capacity, int stops, List<String> listOfInputStrings, String query) {
        String passengerId = "";
        if (query.contains(",")) {
            passengerId = query.split(",")[1];
            query = query.split(",")[0];
        }
        switch (query) {
            case "1":
                return getInOutCount(listOfInputStrings);
            case "2":
                return totalPassengersWithFareDetails(capacity, stops, listOfInputStrings);
            case "3":
                return totalFareSpentByPassenger(capacity, stops, listOfInputStrings, passengerId.trim());
            case "4":
                return totalTripsByPassenger(listOfInputStrings, passengerId.trim());
            case "5":
                return didPassengerTravelTillLastStop(listOfInputStrings, passengerId.trim());
        }

        //<= 25 0.6
        //25 > <=50 0.3
        //>50 full
        //Write your code here
        return null;
    }

    private String didPassengerTravelTillLastStop(List<String> listOfInputStrings, String passengerId) {
        List x = new ArrayList();
        int in = 0;
        for (String stop : listOfInputStrings) {
            for (String person : stop.split(" ")) {
                if (person.equals("+" + passengerId)) {
                    in++;
                } else if (person.equals("-" + passengerId)) {
                    in--;
                }
            }
        }
        if (in > 0) {
            return "Passenger " + passengerId + " was inside the bus at the end of the trip";
        } else {
            return "Passenger " + passengerId + " was not inside the bus at the end of the trip";
        }
    }

    private String totalTripsByPassenger(List<String> listOfInputStrings, String passengerId) {
        int in = 0;
        for (String stop : listOfInputStrings) {
            for (String person : stop.split(" ")) {
                if (person.equals("+" + passengerId)) {
                    in++;
                }
            }
        }
        return "Passenger " + passengerId + " has got on the bus for " + in + " times";
    }

    private String totalFareSpentByPassenger(int capacity, int stops, List<String> listOfInputStrings, String passengerId) {
        int crowd = 0;
        double amount = 0;
        for (String atStop : listOfInputStrings) {
            String[] passengers = atStop.split(" ");
            for (String passenger : passengers) {
                if (passenger.startsWith("+")) {
                    crowd++;
                } else if (passenger.startsWith("-")) {
                    crowd--;
                }
            }
            if (atStop.contains("+" + passengerId)) {
                if (((double) crowd / capacity) * 100 <= 25) {
                    amount = amount + capacity + capacity * 0.6;
                } else if (((double) crowd / capacity) * 100 > 25 && ((double) crowd / capacity) * 100 <= 50) {
                    amount = amount + capacity + capacity * 0.3;
                } else {
                    amount = amount + capacity;
                }
            }
        }
        System.out.println(amount);
        return "Passenger " + passengerId + " spent a total fare of " + amount;
    }

    private String totalPassengersWithFareDetails(int capacity, int stops, List<String> listOfInputStrings) {
        double full = 0;
        double fare6 = 0;
        double face3 = 0;
        for (String atStop : listOfInputStrings) {
            String[] passengers = atStop.split(" ");
            int crowd = passengers.length;
            Map<Float,Integer> x= new HashMap<>();
            x.put()
            for (String passenger : passengers) {
                passenger = passenger.replaceAll("\\+|-", "");
                if (((double) crowd / capacity) * 100 <= 25) {
                    Passenger p = new Passenger(Integer.parseInt(passenger), (float) (capacity + capacity * 0.6));
                } else if (((double) crowd / capacity) * 100 > 25 && ((double) crowd / capacity) * 100 <= 50) {
                    Passenger p = new Passenger(Integer.parseInt(passenger), (float) (capacity + capacity * 0.3));
                } else {
                    Passenger p = new Passenger(Integer.parseInt(passenger), (float) (capacity));
                }
            }
        }
        return "passengers traveled with a fare of "+(capacity + capacity * 0.6)+", " + " passengers traveled with a fare of "+(capacity + capacity * 0.6)+" and " + "passengers traveled with a fare of "+capacity;
    }

    private String getInOutCount(List<String> listOfInputStrings) {
        int inBus = 0;
        int outBus = 0;
        for (String passengersAtStop : listOfInputStrings) {
            String[] passengers = passengersAtStop.split(" ");
            for (String passenger : passengers) {
                if (passenger.startsWith("+")) {
                    inBus++;
                } else {
                    outBus++;
                }
            }
        }
        return inBus + " passengers got on the bus and " + outBus + " passengers got out of the bus";
    }
}
