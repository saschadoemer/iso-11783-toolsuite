package de.saschadoemer.iso11783.localization.enums.units;

/**
 * Internal area unit.
 * <p>
 * 00 Metric (hectares or square metres)
 * 01 Imperial/US (acres or square feet)
 * 10 Reserved
 * 11 No action
 */
public enum AreaUnit {

    METRIC(false, false),
    IMPERIAL_US(false, true),
    RESERVED(true, false),
    NO_ACTION(true, true);

    private final boolean bit_1;
    private final boolean bit_2;

    AreaUnit(boolean bit_1, boolean bit_2) {
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
