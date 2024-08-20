package LLD.tollcollecting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DistanceService {
    private Repository repository;

    public DistanceService(Repository repository) {
        this.repository = repository;
    }

    public List<Toll> getTolls(char start, char destination) {
        List<Toll> tollList = repository.getTolls();
        int n = tollList.size();
        List<Toll> ans = new ArrayList<>();
        if (isForward(start,destination,tollList.size()-1)){
            while (start != destination){
                if (repository.getTollByPoint(start) != null)
                    ans.add(repository.getTollByPoint(start));
                start++;
                if (start == (char)('A'+n)) start = 'A';
            }
        }
        else {
            while (start != destination){
                Toll cur = repository.getTollByPoint(start);
                if (cur != null) ans.add(cur);
                start--;
                if (start == 'A')
                    start = (char) ('A'+n);
            }
        }
        return ans;
    }

    private boolean isForward(char source, char destination, int total) {
        int start = source - 'A';
        int end = destination - 'A';
        int forward = (end - start + total) % total;
        int back = (start - end + total)%total;
        return forward <= back;
    }
}