package LLD.tollcollecting;

import java.util.LinkedList;
import java.util.List;

public class Repository {

    static List<Toll> tollList;
    public Repository(){
        tollList = new LinkedList<>();
        tollList.add(new TollA('A',1));
        tollList.add(new TollC('C',2));
        tollList.add(new TollF('F',3));
    }
    public List<Toll> getTolls() {
        return tollList;
    }

    public Toll getTollByPoint(char point){
        for (Toll toll : tollList)
            if (point == toll.getLocation())
                return toll;
        return null;
    }
}
