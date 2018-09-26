package nl.omniex.omniexshopping.ui.app.order.overview;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.OrderRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;

public class OrderOverviewPresenter extends BasePresenter<OrderOverviewView> {

    private OrderRepository mOrderRepository;

    @Inject
    OrderOverviewPresenter(OrderRepository orderRepository) {
        mOrderRepository = orderRepository;
    }

    void getOverview(){
        addDisposable(mOrderRepository
        .confirmOrder()
        .subscribe(voidResponse -> {},Throwable::printStackTrace));
    }
}
