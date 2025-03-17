package rescursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetSum {
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        helper(n,n,new ArrayList<>(),list);
        return list;
    }

    private void helper(int current, int max, List<Integer> list, ArrayList<ArrayList<Integer>> res){
        if (current == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = Math.min(current, max); i > 0; i--){
            list.add(i);
            helper(current-i, i, list, res);
            list.remove(list.size()-1);
        }
    }
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++){
            boolean[] used = new boolean[10];
            ans += countNumbers(0,i,used);
        }
        return ans;
    }
    private int countNumbers(int length, int n, boolean[] used){
        if (length == n)
            return 1;
        int count = 0;
        for (int i = 0; i <= 9; i++){
            if (used[i] || length == 0 && i == 0) continue;
            used[i] = true;
            count += countNumbers(length+1, n, used);
            used[i] = false;
        }
        return count;
    }
    public boolean isAdditiveSequence(String n) {
        return findAddictive(n,-1,-1,0,0);
    }
    private boolean findAddictive(String num, int num1, int num2, int index, int count){
        if (index == num.length())
            return count >= 3;
        int current = 0;
        int sum = num1 + num2;
        for (int i = index; i < num.length(); i++){
            if (i > index && num.charAt(index) == '0') break;
            current = current * 10 + num.charAt(i) - '0';
            if (count >= 2){
                if (current > sum) break;
                if (current < sum) continue;
            }
            if (findAddictive(num, num2, current, i+1,count+1))
                return true;
        }
        return false;
    }
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();

        generate(list,0,s.toCharArray());
        return list;
    }
    private void generate(List<String> list, int index, char[] arr){
        if (index == arr.length){
            list.add(new String(arr));
            return;
        }
        generate(list,index+1,arr);

        if (Character.isLetter(arr[index])){
            arr[index] = Character.isUpperCase(arr[index]) ?
                    Character.toLowerCase(arr[index]) : Character.toUpperCase(arr[index]);
            generate(list,index+1,arr);
            arr[index] = Character.isUpperCase(arr[index]) ?
                    Character.toLowerCase(arr[index]) : Character.toUpperCase(arr[index]);
        }
    }
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> list = new ArrayList<>();
        helper(list,num,0);
        return list;
    }
    private boolean helper(List<Integer> list, String number, int index){
        if (index == number.length())
            return list.size() >= 3;
        int current = 0;
        for (int i = index; i < number.length(); i++){
            if (i > index && number.charAt(index) == '0') break;
            current = current * 10 + number.charAt(i) - '0';
            if (list.size() >= 2 && current > list.get(list.size()-1) + list.get(list.size()-2)) break;
            if (list.size() <= 1 || current == list.get(list.size()-1) + list.get(list.size()-2)){
                list.add(current);
                if (helper(list,number,i+1))
                    return true;
                list.remove(list.size()-1);
            }
        }
        return false;
    }
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++)
            addNumber(i,list,n,k);
        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    private void addNumber(int current, List<Integer> list, int remaining, int k){
        if (remaining == 0){
            list.add(current);
            return;
        }
        int remain = current % 10;
        int next = remain + k;
        int next2 = remain - k;
        if (next >= 0 && next <= 9)
            addNumber(current * 10 + next, list,remaining-1,k);
        if (next2 >= 0 && next2 <= 9 && next != next2)
            addNumber(current * 10 + next2,list,remaining-1,k);
    }
    public static void main(String[] args) {
        SubSetSum subSetSum = new SubSetSum();
        List<Integer> list = subSetSum.splitIntoFibonacci("1101111");
        for (int s : list)
            System.out.print(s+" ");
    }
}
