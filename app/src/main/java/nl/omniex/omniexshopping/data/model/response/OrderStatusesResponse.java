package nl.omniex.omniexshopping.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import nl.omniex.omniexshopping.data.model.order.OrderStatus;

public class OrderStatusesResponse {

    @SerializedName("data")
    private List<OrderStatus> mOrderStatusList;

    public List<OrderStatus> getOrderStatusList() {
        return mOrderStatusList;
    }
}
