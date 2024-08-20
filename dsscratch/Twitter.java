package dsscratch;

import java.util.*;

class Tweet{
    int time;
    int tweetId;

    public Tweet(int time,int tweetId){
        this.time = time;
        this.tweetId = tweetId;
    }
}

class Twitter {
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer,List<Tweet>> tweetMap;
    private static int timeStamp = 1;

    public Twitter() {
        this.followerMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(timeStamp++,tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        Set<Integer> set = followerMap.getOrDefault(userId,new HashSet<>());
        set.add(userId);
        for (Integer id : set){
            List<Tweet> tweets = tweetMap.getOrDefault(id,new ArrayList<>());
            for (Tweet tweet : tweets){
                pq.offer(tweet);
                if (pq.size() > 10){
                    pq.poll();
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()){
            list.add(pq.poll().tweetId);
        }
        Collections.reverse(list);
        return list;
    }

    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId,new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId){
            if (followerMap.get(followerId) != null && followerMap.get(followerId).contains(followeeId))
                followerMap.get(followerId).remove(followeeId);
        }
    }
}