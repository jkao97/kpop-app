package com.example.james.kpop;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twitter.sdk.android.core.*;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.*;

/**
 * Created by James on 7/22/2016.
 */
public class Newsfeed extends ListActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsfeed);

        final UserTimeline timeline = new UserTimeline.Builder().screenName("Official_AOA").build();

        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(timeline)
                .build();
        setListAdapter(adapter);

    }
}
