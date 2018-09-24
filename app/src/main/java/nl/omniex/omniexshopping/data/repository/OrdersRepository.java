package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.api.OmniexApi;

public class OrdersRepository {

    private OmniexApi mOmniexApi;

    @Inject
    OrdersRepository(OmniexApi omniexApi){
        mOmniexApi = omniexApi;
    }
}
