package de.saschadoemer.iso11783;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Client name decoder for ISO 11783-5 encoded client names.
 */
public final class ClientNameDecoder {

    /**
     * Hide the constructor.
     */
    private ClientNameDecoder() {
    }

    /**
     * Decode a given binary representation of a client name into a more common representation.
     *
     * @param clientName -
     */
    public static void decode(byte[] clientName) {
        if (null == clientName || clientName.length == 0) {
            throw new IllegalArgumentException("The client name can not be null or empty");
        }
        validateClientName(clientName);
    }

    private static void validateClientName(byte[] clientName) {
        final String hexRepresentation = new String(clientName);
        final Pattern pattern = Pattern.compile("^[A-Fa-f0-9]{16}$");
        final Matcher matcher = pattern.matcher(hexRepresentation);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("The HEX representaton '%s' does not match the requirements, please check the input.", hexRepresentation));
        }
    }

}
