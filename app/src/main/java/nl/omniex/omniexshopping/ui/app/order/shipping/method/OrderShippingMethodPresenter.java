package nl.omniex.omniexshopping.ui.app.order.shipping.method;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.ShippingRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;

public class OrderShippingMethodPresenter extends BasePresenter<OrderShippingMethodView> {

    private ShippingRepository mShippingRepository;

    @Inject
    OrderShippingMethodPresenter(ShippingRepository shippingRepository){
        mShippingRepository = shippingRepository;
    }

    void getShippingMethods(){
        addDisposable(mShippingRepository
        .getShippingMethods()
        .subscribe(voidResponse -> {},Throwable::printStackTrace));
    }
}
