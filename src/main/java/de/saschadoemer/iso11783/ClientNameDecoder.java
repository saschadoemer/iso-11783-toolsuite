package de.saschadoemer.iso11783;

import java.util.logging.Logger;

/**
 * Client name decoder for ISO 11783-5 encoded client names.
 */
public final class ClientNameDecoder {

    private static final Logger LOG = Logger.getLogger(ClientNameDecoder.class.getName());

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
            LOG.warning("Could not decode client name, since the client name was null or empty.");
            throw new IllegalArgumentException("The client name can not be null or empty");
        }
        validateClientName(clientName);
    }

    private static void validateClientName(byte[] clientName) {
        final String hexRepresentation = new String(clientName);
        if (hexRepresentation.length() != 16) {
            LOG.warning("The client name has the wrong length. The client name has to have exactly 16 digits.");
            throw new IllegalArgumentException(String.format("Wrong client name format, expected 15 digits,found %d digits.", hexRepresentation.length()));
        }
    }

}
