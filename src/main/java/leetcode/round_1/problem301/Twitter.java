package leetcode.round_1.problem301;

import java.util.*;

/**
 * 355. Design Twitter
 */
public class Twitter {

    private HashMap<Integer, HashSet<Integer>> followMap;
    private LinkedHashMap<Integer, Integer> twitters;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followMap = new HashMap<>();
        twitters = new LinkedHashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        twitters.put(tweetId, userId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        users.addAll(followMap.getOrDefault(userId, new HashSet<>()));

        ListIterator<Map.Entry<Integer, Integer>> it = new ArrayList<>(twitters.entrySet()).listIterator(twitters.size());
        List<Integer> res = new ArrayList<>();
        while (it.hasPrevious() && res.size() < 10) {
            Map.Entry<Integer, Integer> entry = it.previous();
            if (users.contains(entry.getValue())) res.add(entry.getKey());
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);

        System.out.println(twitter.getNewsFeed(1));

        twitter.follow(1, 2);

        twitter.postTweet(2, 6);

        System.out.println(twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);

        System.out.println(twitter.getNewsFeed(1));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
