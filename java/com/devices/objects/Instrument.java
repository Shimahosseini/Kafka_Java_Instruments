package com.devices.model;

public class Instrument {

    private String name;
    private int value;
    private Machines machines;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Machines getMachines() {
        return machines;
    }

    public void setMachines(Machines machines) {
        this.machines = machines;
    }

    public Instrument() {
    }

    public Instrument(String name, int value, Machines machines) {
        this.name = name;
        this.value = value;
        this.machines = machines;
    }
}
