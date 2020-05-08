package de.noahb.bikeservicetracker;

public class Service {
    private String name;
    private String description;
    private int distance_interval;

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    private boolean reminder;

    public Service(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDistance_interval() {
        return distance_interval;
    }

    public void setDistance_interval(int distance_interval) {
        this.distance_interval = distance_interval;
    }


}
