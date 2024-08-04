package com.example.unittestexample.mock;

import com.example.unittestexample.common.service.ClockHolder;

public class TestClockHolder implements ClockHolder {

    private final long millis;

    public TestClockHolder(long millis) {
        this.millis = millis;
    }

    @Override
    public long millis() {
        return millis;
    }
}
