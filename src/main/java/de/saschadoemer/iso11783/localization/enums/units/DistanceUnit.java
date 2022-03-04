package de.saschadoemer.iso11783.localization.enums.units;

/**
 * The internal distance unit.
 * <p>
 * 00 Metric (kilometres, metres, ...)
 * 01 Imperial/US (miles, feet, ...)
 * 10 Reserved
 * 11 No action
 */
public enum DistanceUnit {

    METRIC(false, false),
    IMPERIAL_US(false, true),
    RESERVED(true, false),
    NO_ACTION(true, true);

    private final boolean bit_1;
    private final boolean bit_2;

    DistanceUnit(boolean bit_1, boolean bit_2) {
        this.bit_1 = bit_1;
        this.bit_2 = bit_2;
    }

    public boolean isBit_1() {
        return bit_1;
    }

    public boolean isBit_2() {
        return bit_2;
    }
}
