package nl.omniex.omniexshopping.ui.app.order.shipping;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.model.address.Address;
import nl.omniex.omniexshopping.data.model.order.ExistingAddress;
import nl.omniex.omniexshopping.data.repository.AddressRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;

public class OrderShippingPresenter extends BasePresenter<OrderShippingView> {

    private AddressRepository mAddressRepository;

    @Inject
    OrderShippingPresenter(AddressRepository addressRepository) {
        mAddressRepository = addressRepository;
    }

    void getShippingAddresses() {
        addDisposable(mAddressRepository
                .getShippingAddresses()
                .subscribe(
                        shippingAddressesResponse -> {
                            ifViewAttached(view -> view.onShippingAddressesFetched(shippingAddressesResponse.body().getShippingAddressList().getAddressList()));
                        }, Throwable::printStackTrace));
    }

    void setShippingAddress(Address existingAddress) {
        addDisposable(mAddressRepository
                .setExistingShippingAddress(existingAddress)
                .subscribe(voidResponse -> {
                    ifViewAttached(view -> view.onShippingAddressSet());
                }, Throwable::printStackTrace));
    }
}
