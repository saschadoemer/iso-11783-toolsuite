package de.saschadoemer.iso11783.localization.parameters;

import de.saschadoemer.iso11783.localization.enums.UnitSystem;
import de.saschadoemer.iso11783.localization.enums.units.*;

/**
 * Device localization parameters, especially for the US system. All units are predefined.
 */
public class USDeviceLocalizationParameter extends DeviceLocalizationLabelParameter {

    public USDeviceLocalizationParameter() {
        super();
        distanceUnit = DistanceUnit.IMPERIAL_US;
        areaUnit = AreaUnit.IMPERIAL_US;
        volumeUnit = VolumeUnit.US;
        massUnit = MassUnit.US;
        temperatureUnit = TemperatureUnit.IMPERIAL_US;
        pressureUnit = PressureUnit.IMPERIAL_US;
        forceUnit = ForceUnit.IMPERIAL_US;
        unitSystem = UnitSystem.US;
    }

}
