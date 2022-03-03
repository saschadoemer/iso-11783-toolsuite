package de.saschadoemer.iso11783.localization.enums;

/**
 * The internal date format.
 * <p>
 * 0 ddmmyyyy
 * 1 ddyyyymm
 * 2 mmyyyydd
 * 3 mmddyyyy
 * 4 yyyymmdd
 * 5 yyyyddmm
 * 6–250 Reserved
 */
public enum DateFormat {

    DD_MM_YYYY(0),
    DD_YYYY_MM(1),
    MM_YYYY_DD(2),
    MM_DD_YYYY(3),
    YYYY_MM_DD(4),
    YYYY_DD_MM(5);

    private final int value;

    DateFormat(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
