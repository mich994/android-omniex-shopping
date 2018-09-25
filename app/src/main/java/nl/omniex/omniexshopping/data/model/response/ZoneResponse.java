package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import nl.omniex.omniexshopping.data.model.address.Zone;

public class ZoneResponse {

    @SerializedName("data")
    private Zone mZone;

    public Zone getZone() {
        return mZone;
    }
}
