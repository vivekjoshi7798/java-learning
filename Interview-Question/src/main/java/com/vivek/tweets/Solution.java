package com.vivek.tweets;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
/*

📌 Problem Statement: Tweet Analytics Using Java 8 Streams

You are given a list of Tweet objects representing posts made by users on a social media platform.

Filter Tweets by User
Given a userId, filter and return all tweets posted by that user.

Group Tweets by Hashtags
Group all tweets based on each hashtag.
A tweet can belong to multiple hashtag groups.

Count Total Likes per User
Calculate the total number of likes received across all tweets for a given userId.
        (Optional Bonus)

Find the top 3 most liked tweets.

Find the most frequently used hashtag.

Get average likes per tweet for each user.

*/

public class Solution {

    public static void main() {


        List<Tweet> tweets = Arrays.asList(
                new Tweet("T1", "user1", "Learning Java Streams", Arrays.asList("#java", "#streams"), 10),
                new Tweet("T2", "user2", "Spring Boot guide", Arrays.asList("#spring", "#java"), 15),
                new Tweet("T3", "user1", "Concurrency in Java", Arrays.asList("#java", "#multithreading"), 20),
                new Tweet("T4", "user3", "Docker basics", Arrays.asList("#docker", "#devops"), 8),
                new Tweet("T5", "user2", "Microservices architecture", Arrays.asList("#microservices", "#spring"), 25),
                new Tweet("T6", "user4", "Kubernetes intro", Arrays.asList("#k8s", "#devops"), 18),
                new Tweet("T7", "user1", "Lambda expressions", Arrays.asList("#java", "#lambda"), 12),
                new Tweet("T8", "user3", "System design basics", Arrays.asList("#systemdesign"), 30),
                new Tweet("T9", "user5", "REST API best practices", Arrays.asList("#api", "#rest"), 22),
                new Tweet("T10", "user2", "Hibernate tips", Arrays.asList("#hibernate", "#java"), 17),
                new Tweet("T11", "user4", "CI/CD pipeline", Arrays.asList("#cicd", "#devops"), 14),
                new Tweet("T12", "user5", "SQL optimization", Arrays.asList("#sql", "#database"), 19),
                new Tweet("T13", "user3", "Design patterns", Arrays.asList("#designpatterns"), 27),
                new Tweet("T14", "user1", "Stream API advanced", Arrays.asList("#java", "#streams"), 35),
                new Tweet("T15", "user2", "Spring Security", Arrays.asList("#spring", "#security"), 21),
                new Tweet("T16", "user4", "Cloud computing", Arrays.asList("#cloud", "#aws"), 16),
                new Tweet("T17", "user5", "NoSQL vs SQL", Arrays.asList("#database", "#nosql"), 13),
                new Tweet("T18", "user3", "Logging in Java", Arrays.asList("#java", "#logging"), 11),
                new Tweet("T19", "user1", "Reactive programming", Arrays.asList("#reactive", "#java"), 26),
                new Tweet("T20", "user2", "Unit testing", Arrays.asList("#testing", "#junit"), 9)
        );


        System.out.println("******** Filter Tweets by User ****************");
        tweets.stream().filter(tweet -> tweet.getTweetOwner().equals("user1")).forEach(System.out::println);
        System.out.println("***************************");

//        Group Tweets by Hashtags
//        Group all tweets based on each hashtag.
//                A tweet can belong to multiple hashtag groups.


        System.out.println("******** Group Tweets by Hashtags ****************");
        Map<String, List<Tweet>> hashtags = tweets.stream()
                .flatMap(t -> t.getHashtags()
                        .stream()
                        .map(tags -> Map.entry(tags, t)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(s -> s.getValue(), Collectors.toList())
                ));

        System.out.println("***************************");

        System.out.println("********Count Total Likes per User  ****************");
        long totalNumberOfLikes = tweets.stream().filter(tweet -> tweet.getTweetOwner().equals("user1")).map(Tweet::getLikes).count();
        System.out.println("***************************" + totalNumberOfLikes);

        System.out.println("******** Find the top 3 most liked tweets. ****************");
        List<Tweet> top3 = tweets.stream().sorted(Comparator
                        .comparingInt(Tweet::getLikes)
                        .reversed())
                .limit(3).toList();

        top3.forEach(System.out::println);


        System.out.println("******** Find the most frequently used hashtag. ****************");
        Map<String, Long> counter = tweets.stream().flatMap(tweet -> tweet.getHashtags().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        String hashTags = counter.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("");
        System.out.println("***************************" + hashTags);

        System.out.println("******** Get average likes per tweet for each user. ****************");
        Map<String, Double> Likes = tweets.stream().collect(Collectors.groupingBy(Tweet::getTweetOwner, Collectors.averagingDouble(Tweet::getLikes)));
        System.out.println("***************************" + Likes);


    }
}
