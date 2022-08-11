package com.devices.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.devices.model.Instrument;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class InstrumentDeserializer implements Deserializer {

     @Override
    public void configure(Map map, boolean b) {
    }

    @Override
    public Instrument deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        Instrument instrument = null;
        try {
            instrument = mapper.readValue(bytes, Instrument.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instrument;
    }

    @Override
    public void close() {
    }
}
