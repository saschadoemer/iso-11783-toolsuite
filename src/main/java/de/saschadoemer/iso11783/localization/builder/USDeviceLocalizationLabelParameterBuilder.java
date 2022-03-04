package de.saschadoemer.iso11783.localization.builder;

import de.saschadoemer.iso11783.localization.parameters.USDeviceLocalizationParameter;

/**
 * Builder class for the parameter.
 */
public class USDeviceLocalizationLabelParameterBuilder extends DeviceLocalizationLabelParameterBuilder {

    public USDeviceLocalizationLabelParameterBuilder() {
        super(new USDeviceLocalizationParameter());
    }
}
