package nl.omniex.omniexshopping.data.repository;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.api.OmniexApi;

public class CountriesRepository {

    private OmniexApi mOmniexApi;

    @Inject
    CountriesRepository(OmniexApi omniexApi){
        mOmniexApi = omniexApi;
    }
}
