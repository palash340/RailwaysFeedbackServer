package com.irctc.twitter;

import com.irctc.beans.TwitterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

import javax.annotation.PostConstruct;
import java.util.List;

@ComponentScan(basePackageClasses = StreamFeeds.class)
public class StreamFeeds {

    @Autowired
    TwitterProperties twitterProperties;

    private TwitterStream twitterStream;

    @PostConstruct
    private void initConfiguration(){
        System.err.println("I am trying");
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(false)
                .setOAuthConsumerKey(twitterProperties.getConsumerKey())
                .setOAuthConsumerSecret(twitterProperties.getConsumerSecret());

        TwitterStreamFactory twitterStreamFactory = new TwitterStreamFactory(cb.build());
        twitterStream = twitterStreamFactory.getInstance(new AccessToken(twitterProperties.getAccessToken(), twitterProperties.getAccessTokenSecret()));
        twitterStream.addListener(userStreamListener);
        twitterStream.user();
    }

    public void getTimelineFeeds(){
        try {
            // gets Twitter instance with default credentials
            Twitter twitter = new TwitterFactory().getInstance();
            User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            for (Status status : statuses) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
    }

    public TwitterListener getTwitterListener(){
        TwitterListener twitterListener = new TwitterAdapter(){

        };
        return twitterListener;
    }

    UserStreamListener userStreamListener = new UserStreamListener() {

        @Override
        public void onException(Exception e) {
            // Do Nothing
        }

        @Override
        public void onStatus(Status status) {
            System.out.println(status.getText());
        }

        @Override
        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
            // Do Nothing
        }

        @Override
        public void onTrackLimitationNotice(int i) {
            // Do Nothing
        }

        @Override
        public void onScrubGeo(long l, long l1) {
            // Do Nothing
        }

        @Override
        public void onStallWarning(StallWarning stallWarning) {
            // Do Nothing
        }

        @Override
        public void onDeletionNotice(long l, long l1) {
            // Do Nothing
        }

        @Override
        public void onFriendList(long[] longs) {
            // Do Nothing
        }

        @Override
        public void onFavorite(User user, User user1, Status status) {
            // Do Nothing
        }

        @Override
        public void onUnfavorite(User user, User user1, Status status) {
            // Do Nothing
        }

        @Override
        public void onFollow(User user, User user1) {
            // Do Nothing
        }

        @Override
        public void onUnfollow(User user, User user1) {
            // Do Nothing
        }

        @Override
        public void onDirectMessage(DirectMessage directMessage) {
            // Do Nothing
        }

        @Override
        public void onUserListMemberAddition(User user, User user1, UserList userList) {
            // Do Nothing
        }

        @Override
        public void onUserListMemberDeletion(User user, User user1, UserList userList) {
            // Do Nothing
        }

        @Override
        public void onUserListSubscription(User user, User user1, UserList userList) {
            // Do Nothing
        }

        @Override
        public void onUserListUnsubscription(User user, User user1, UserList userList) {
            // Do Nothing
        }

        @Override
        public void onUserListCreation(User user, UserList userList) {
            // Do Nothing
        }

        @Override
        public void onUserListUpdate(User user, UserList userList) {
            // Do Nothing
        }

        @Override
        public void onUserListDeletion(User user, UserList userList) {
            // Do Nothing
        }

        @Override
        public void onUserProfileUpdate(User user) {
            // Do Nothing
        }

        @Override
        public void onUserSuspension(long l) {
            // Do Nothing
        }

        @Override
        public void onUserDeletion(long l) {
            // Do Nothing
        }

        @Override
        public void onBlock(User user, User user1) {
            // Do Nothing
        }

        @Override
        public void onUnblock(User user, User user1) {
            // Do Nothing
        }

        @Override
        public void onRetweetedRetweet(User user, User user1, Status status) {
            // Do Nothing
        }

        @Override
        public void onFavoritedRetweet(User user, User user1, Status status) {
            // Do Nothing
        }

        @Override
        public void onQuotedTweet(User user, User user1, Status status) {
            // Do Nothing
        }
    };
}
