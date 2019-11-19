package com.appsfromholland.sqlitecrud;

enum Unit {
    WATT,
    KILOWATT
}

public class Meting {
    Unit unit;
    int value;

    public Meting(Unit unit, int value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Meting{" +
                "unit=" + unit +
                ", value=" + value +
                '}';
    }
}

