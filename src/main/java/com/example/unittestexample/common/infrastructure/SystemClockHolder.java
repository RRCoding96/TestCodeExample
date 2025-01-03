package com.example.unittestexample.common.infrastructure;

import com.example.unittestexample.common.service.ClockHolder;
import org.springframework.stereotype.Component;

import java.time.Clock;

@Component
public class SystemClockHolder implements ClockHolder {

    @Override
    public long millis() {
        return Clock.systemUTC().millis();
    }
}
