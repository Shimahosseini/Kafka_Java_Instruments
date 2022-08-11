package com.devices.model;

import java.util.List;
import java.util.Set;

public class Container {

    private List<Instrument> InstrumentList;

    public List<Instrument> getInstrumentList() {
        return InstrumentList;
    }

    public Container(List<Instrument> InstrumentList) {
        this.InstrumentList = InstrumentList;
    }
}
