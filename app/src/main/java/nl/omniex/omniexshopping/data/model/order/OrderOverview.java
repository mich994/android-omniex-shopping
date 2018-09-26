package nl.omniex.omniexshopping.data.model.order;

import nl.omniex.omniexshopping.data.model.address.Address;
import nl.omniex.omniexshopping.data.model.cart.Cart;
import nl.omniex.omniexshopping.data.model.shipping.ShippingMethod;

public class OrderOverview {

    private Cart mCart;
    private Address mShippingAddress;
    private Address mPaymentAddress;
    private ShippingMethod mShippingMethod;
    private String mPaymentMethod;

    public Cart getCart() {
        return mCart;
    }

    public void setCart(Cart cart) {
        mCart = cart;
    }

    public Address getShippingAddress() {
        return mShippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        mShippingAddress = shippingAddress;
    }

    public Address getPaymentAddress() {
        return mPaymentAddress;
    }

    public void setPaymentAddress(Address paymentAddress) {
        mPaymentAddress = paymentAddress;
    }

    public ShippingMethod getShippingMethod() {
        return mShippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        mShippingMethod = shippingMethod;
    }

    public String getPaymentMethod() {
        return mPaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        mPaymentMethod = paymentMethod;
    }
}
