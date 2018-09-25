package nl.omniex.omniexshopping.ui.app.order;

import javax.inject.Inject;

import nl.omniex.omniexshopping.data.repository.AddressRepository;
import nl.omniex.omniexshopping.data.repository.OrderRepository;
import nl.omniex.omniexshopping.ui.base.BasePresenter;

public class OrderPresenter extends BasePresenter<OrderView> {

    private OrderRepository mOrderRepository;
    private AddressRepository mAddressRepository;

    @Inject
    OrderPresenter(OrderRepository orderRepository, AddressRepository addressRepository){
        mOrderRepository = orderRepository;
        mAddressRepository = addressRepository;
    }
}
