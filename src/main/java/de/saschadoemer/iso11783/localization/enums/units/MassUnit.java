package de.saschadoemer.iso11783.localization.enums.units;

/**
 * The internal mass unit.
 * <p>
 * 00 Metric (tonnes, kilograms, ...)
 * 01 Imperial (long tons, pounds, ...)
 * 10 US (short tons, pounds, ...)
 * 11 No action
 */
public enum MassUnit {

    METRIC(false, false),
    IMPERIAL(false, true),
    US(true, false),
    NO_ACTION(true, true);

    private final boolean bit_1;
    private final boolean bit_2;

    MassUnit(boolean bit_1, boolean bit_2) {
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
