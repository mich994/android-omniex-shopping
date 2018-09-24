package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.api.OmniexApi;

public class ShippingRepository {

    private OmniexApi mOmniexApi;

    @Inject
    ShippingRepository(OmniexApi omniexApi){
        mOmniexApi = omniexApi;
    }
}
