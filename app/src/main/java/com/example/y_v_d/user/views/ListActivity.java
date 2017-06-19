package com.example.y_v_d.user.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.y_v_d.user.R;
import com.example.y_v_d.user.adapters.PostsAdapter;
import com.example.y_v_d.user.models.Post;
import com.example.y_v_d.user.presenters.ListPresenter;
import com.example.y_v_d.user.services.ForumService;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;

/**
 * Created by Y-V-D on 2017-06-18.
 */

public class ListActivity extends AppCompatActivity {
    @InjectView(R.id.listViewPosts)
    ListView mListViewPosts;

    PostsAdapter mPostsAdapter;

    ListPresenter mListPresenter;

    ForumService mForumService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        ArrayList<Post> dummyPosts = new ArrayList<Post>();
        mPostsAdapter = new PostsAdapter(this, dummyPosts);
        mListViewPosts.setAdapter(mPostsAdapter);

        mForumService = new ForumService();
        mListPresenter = new ListPresenter(this, mForumService);
        mListPresenter.loadPosts();

    }
       @OnItemClick(R.id.listViewPosts)
        public void onPostSelect(int position) {

            Post p = mPostsAdapter.getItem(position);
            int postId = p.id;

            Intent detailIntent = new Intent(this, DetailActivity.class);
            detailIntent.putExtra("postId", postId);
            startActivity(detailIntent);
        }


    public void displayPosts(List<Post> posts) {
        mPostsAdapter.clear();
        mPostsAdapter.addAll(posts);
        mPostsAdapter.notifyDataSetInvalidated();

    }
}