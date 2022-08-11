package com.devices.builders;

import com.devices.objects.Container;
import com.devices.objects.machines;

import java.util.Arrays;

import static com.devices.objects.Instrument.Milling Machine;
import static com.devices.objects.Instrument.Grinding Machine;
import static com.devices.objects.Instrument.Shaper Machines;

public class ContainerBuilder {

    public Container build() {
        Instrument instrument1 = new Instrument("Milling Machine 1", 27, Milling Machine);
        Instrument instrument2 = new Instrument("Grinding Machine 4", 24, Grinding Machine);
        Instrument instrument3 = new Instrument("Shaper Machines 8", 28, Shaper Machines);

        return new Container(Arrays.asList(instrument1, instrument2, instrument3));
    }
}
