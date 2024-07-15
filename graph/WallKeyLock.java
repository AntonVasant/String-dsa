package graph;

//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Set;
//
//public class WallKeyLock {
//    public static int wallKeyLock(String[] array){
//        int row = array.length;
//        int col = array[0].length();
//        int keyCount = 0;
//        int[] startPos = new int[2];
//        for (int i = 0; i < row; i++){
//            for (int j = 0; j < col; j++){
//                char c = array[i].charAt(j);
//                if (Character.isLowerCase(c))
//                    keyCount++;
//                else if (c == '@'){
//                    startPos[0] = i;
//                    startPos[1] = j;
//                }
//            }
//        }

//        Queue<int[]> queue = new LinkedList<>();
//        Set<String> set = new HashSet<>();
//        queue.offer(new int[]{startPos[0],startPos[1],keyCount});
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            for (int i = 0; i < size; i++){
//                int[] current = queue.poll();
//                int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
//                for (int[] d : dir){
//                    int r = current[0] + d[0];
//                    int c = current[1] + d[1];
//
//                    if (r < 0 || c < 0 || r >= row || c >= col) continue;
//                    char ch = array[r].charAt(c);
//                    if (ch == '#') continue;
//                    if (Character.isUpperCase(ch) && set.contains(Character.toLowerCase(ch))) continue;
//                }
//            }
//        }
//    }
//}
