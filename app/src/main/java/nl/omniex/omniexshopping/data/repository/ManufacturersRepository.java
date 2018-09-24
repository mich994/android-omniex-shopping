package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.api.OmniexApi;

public class ManufacturersRepository {

    private OmniexApi mOmniexApi;

    @Inject
    ManufacturersRepository(OmniexApi omniexApi){
        mOmniexApi = omniexApi;
    }
}
