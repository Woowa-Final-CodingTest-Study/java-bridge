package bridge.domain;

import java.util.Arrays;

public enum BridgeEnum {

    UP_TRUE("U", 1, true),
    UP_FALSE("U", 1, false),
    DOWN_TRUE("D", 0, true),
    DOWN_FALSE("D", 0, false);

    private final String bridgeStringType;
    private final int bridgeNumberType;
    private final boolean correctLocation;

    BridgeEnum(String stringType, int numberType, boolean correctLocation) {
        this.bridgeStringType = stringType;
        this.bridgeNumberType = numberType;
        this.correctLocation = correctLocation;
    }

    public static BridgeEnum createBridgeStringType(String location, boolean correctLocation) {
        for (BridgeEnum value : values()) {
            if (isLocation(value, location) && isCorrectLocation(value, correctLocation)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No matching BridgeEnum found for location: " + location);
    }

    public static BridgeEnum createBridgeNumberType(int locationNumber) {
        for (BridgeEnum value : values()) {
            if (value.isLocationNumber(value, locationNumber)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No matching BridgeEnum found for location number: " + locationNumber);
    }



    private static boolean isLocationNumber(BridgeEnum locationValue, int locationNumber) {
        return locationValue.bridgeNumberType == locationNumber;
    }

    private static boolean isCorrectLocation(BridgeEnum locationValue, boolean correctLocation) {
        return locationValue.correctLocation == correctLocation;
    }

    private static boolean isLocation(BridgeEnum locationValue, String location) {
        return locationValue.bridgeStringType.equals(location);
    }

    public String getStringType() {
        return bridgeStringType;
    }

    public String getStateLocation(String location) {
        if (this.bridgeStringType.equals(location)) {
            if (this.correctLocation) {
                return "O";
            }
            return "X";
        }
        return " ";
    }
}
