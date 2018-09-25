package nl.omniex.omniexshopping.ui.app.order.payment;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.model.order.ExistingAddress;
import nl.omniex.omniexshopping.data.repository.AddressRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;

public class OrderPaymentPresenter extends BasePresenter<OrderPaymentView> {

    private AddressRepository mAddressRepository;

    @Inject
    OrderPaymentPresenter(AddressRepository addressRepository) {
        mAddressRepository = addressRepository;
    }

    void getPaymentAddresses() {
        addDisposable(mAddressRepository
                .getPaymentAddresses()
                .subscribe(
                        shippingAddressesResponse -> {
//                            ifViewAttached(view -> view.onPaymentAddressesFetched(shippingAddressesResponse.body().getShippingAddressList().getAddressList()));
                        }, Throwable::printStackTrace));
    }

    void setPaymentAddress(ExistingAddress existingAddress) {
        addDisposable(mAddressRepository
                .setExistingPaymentAddress(existingAddress)
                .subscribe(voidResponse -> {
                }, Throwable::printStackTrace));
    }
}

