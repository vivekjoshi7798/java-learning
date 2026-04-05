package com.vivek.tweets;


import java.util.List;

public class Tweet {

    private String tweetId;
    private String tweetOwner;
    private String tweetText;
    private List<String> hashtags;
    private int likes;

    public Tweet(String tweetId, String tweetOwner, String tweetText, List<String> hashtags, int likes) {
        this.tweetId = tweetId;
        this.tweetOwner = tweetOwner;
        this.tweetText = tweetText;
        this.hashtags = hashtags;
        this.likes = likes;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetOwner() {
        return tweetOwner;
    }

    public void setTweetOwner(String tweetOwner) {
        this.tweetOwner = tweetOwner;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
