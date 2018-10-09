package nl.omniex.omniexshopping.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import nl.omniex.omniexshopping.data.model.address.Address;

public class AddressUtils {

    public static List<Address> removeDuplicates(List<Address> pAddressList){
        if(pAddressList.size()==1)
            return pAddressList;
        else {
            return new ArrayList<>(new HashSet<>(pAddressList));
        }
    }
}
