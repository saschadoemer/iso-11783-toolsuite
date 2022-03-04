package de.saschadoemer.iso11783.localization.enums;

/**
 * Internal time format.
 * <p>
 * 00 24 h
 * 01 12 h (am/pm)
 * 10 Reserved
 * 11 No action
 */
public enum TimeFormat {

    _24H(false, false),
    _12H(false, true),
    RESERVED(true, false),
    NO_ACTION(true, true);

    private final boolean bit_1;
    private final boolean bit_2;

    TimeFormat(boolean bit_1, boolean bit_2) {
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
