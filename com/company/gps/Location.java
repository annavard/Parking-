package com.company.gps;

import java.util.Objects;

/**
 * Created by anhaytananun on 12.05.15.
 */
public class Location {
    private float latitude;
    private float longitude;

    public Location(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Location) {
            Location location = (Location) object;

            return location.longitude == this.longitude
                    && location.latitude == this.latitude;
        }

        return false;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }
}