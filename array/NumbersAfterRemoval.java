package array;

import java.util.List;

public class NumbersAfterRemoval {
    public void remove(List<Integer> list,int[] numbersToRemove){
        for (int digit : numbersToRemove){
            for (int i=0;i<list.size();i++){
                String current = String.valueOf(list.get(i));
                String currentNUm = String.valueOf(digit);
                String transForm = current.replace(currentNUm,"");
                list.remove(i);
                int result = Integer.parseInt(transForm);
                list.add(result);
            }
        }
    }
}
