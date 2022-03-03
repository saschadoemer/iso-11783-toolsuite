package de.saschadoemer.iso11783.localization.enums;

/**
 * The internal unit system.
 * <p>
 * 00 Metric
 * 01 Imperial
 * 10 US
 * 11 No action
 */
public enum UnitSystem {

    METRIC(false, false),
    IMPERIAL(false, true),
    US(true, false),
    NO_ACTION(true, true);

    private final boolean bit_1;
    private final boolean bit_2;

    UnitSystem(boolean bit_1, boolean bit_2) {
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
