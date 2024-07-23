package LLD.foodDelivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private static List<DeliveryExecutive> deliveryExecutiveList = new ArrayList<>();

    private static Map<Integer,List<DeliveryAllotment>> map = new HashMap<>();

    public static List<DeliveryExecutive> getDeliveryExecutiveList() {
        return deliveryExecutiveList;
    }

    public List<DeliveryAllotment> getListById(int id){
        List<DeliveryAllotment> list = null;
        if (!map.containsKey(id)){
            map.put(id,new ArrayList<>());
            list = map.get(id);
            return list;
        }
        return map.get(id);
    }

    public void saveAllotment(DeliveryAllotment allotment){
        map.get(allotment.getExecutiveId()).add(allotment);
    }
}
