package days;

import java.util.*;

class Job{
    public int profit;
    public int deadline;
}
class Item{
    public int value;
    public int weight;
    public double ratio;

    public Item(int value, int weight){
        this.value = value;
        this.weight = weight;
        ratio = (double) value/ weight;
    }
}
public class Two {
    ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int i = 0;
        while (i < n){
            while (i < n && A[i+1] <= A[i])
                i++;
            if (i == n-1) break;
            int buy = i++;
            while (i < n && A[i-1] <= A[i])
                i++;
            list.add(new ArrayList<>(Arrays.asList(buy,i-1)));
        }
        return list;
    }
    ArrayList<Integer> JobScheduling(Job[] jobs) {
        Arrays.sort(jobs, (a,b) -> b.profit - a.profit);
        int max = 0;
        for (Job j : jobs)
            max = Math.max(max, j.deadline);
        int[] arr = new int[max +1];
        Arrays.fill(arr,-1);
        int profit = 0;
        int count = 0;
        arr[0] = 1;
        for (Job j : jobs){
            int current = j.deadline;
            for (int i = Math.min(max, current); i>= 0; i--){
                if (arr[i] == -1){
                    arr[i] = 1;
                    profit += j.profit;
                    count++;
                    break;
                }
            }
        }
        return new ArrayList<>(Arrays.asList(count, profit));
    }
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(new Item(val.get(i),wt.get(i)));
        }
        list.sort((a, b) -> Double.compare(b.ratio, a.ratio));
        double ans = 0;
        int current = 0;
        for (int i = 0; i < n; i++){
            if (list.get(i).weight + current <= capacity){
                current += list.get(i).weight;
                ans += list.get(i).value;
            }
            else {
                int rem = capacity - current;
                ans +=  list.get(i).ratio * rem;
                break;
            }
        }
        return ans;
    }
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        ArrayList<Integer> list = new ArrayList<>();
        int less = 0;
        int index = N-1;
        int i = 0;
        while (i < index){
            less += candies[i];
            index -= K;
            i++;
        }
        i = N-1;
        index = 0;
        int large = 0;
        while (index < i){
            large += candies[i];
            i--;
            index += K;
        }
        return new ArrayList<>(Arrays.asList(less,large));
    }
    static List<Integer> minPartition(int N){
        List<Integer> list = new ArrayList<>();
        int[] currency = {1, 2, 5, 10, 20, 50, 100, 200,500,2000};
        int index = currency.length-1;
        while (N > 0){
            if (N - currency[index] >= 0){
                N -= currency[index];
                list.add(currency[index]);
            }
            else index--;
        }
        return list;
    }
    String chooseandswap(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        int[] firstPost = new int[26];
        Arrays.fill(firstPost,-1);
        for (int i = 0; i < n; i++){
            if (firstPost[arr[i] - 'a'] == -1)
                firstPost[arr[i] - 'a'] = i;
        }

        for (int i = 0; i < n; i++){
            for (char c = 'a'; c < arr[i]; c++){
                int pos = firstPost[c - 'a'];
                if (pos > i) {
                    return swap(arr, arr[i],str.charAt(pos));
                }
            }
        }
        return str;
    }
    private String swap(char[] arr, char c1, char c2){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == c1)
                arr[i] = c2;
            else if (arr[i] == c2)
                arr[i] = c1;
        }
        return new String(arr);
    }


    static int minimumDays(int S, int N, int M){
        int total = S * M;
        int food = (S - (S/7)) * N;
        if (total > food) return -1;
        return (int) Math.ceil((double) total/S);

    }


    public static void main(String[] args) {
        Two two = new Two();

    }
}
