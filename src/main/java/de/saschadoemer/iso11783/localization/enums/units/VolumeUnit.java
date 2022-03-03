package de.saschadoemer.iso11783.localization.enums.units;

/**
 * The internal volume unit.
 * <p>
 * 00 Metric (litre)
 * 01 Imperial (gallon)
 * 10 US (gallon)
 * 11 No action
 */
public enum VolumeUnit {

    METRIC(false, false),
    IMPERIAL(false, true),
    US(true, false),
    NO_ACTION(true, true);

    private final boolean bit_1;
    private final boolean bit_2;

    VolumeUnit(boolean bit_1, boolean bit_2) {
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
