package com.example.y_v_d.user.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.y_v_d.user.R;
import com.example.y_v_d.user.adapters.CommentsAdapter;
import com.example.y_v_d.user.models.Post;
import com.example.y_v_d.user.models.comments;
import com.example.y_v_d.user.presenters.DetailPresenter;
import com.example.y_v_d.user.services.ForumService;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DetailActivity extends AppCompatActivity {

    @InjectView(R.id.textViewTitle)
    TextView mTextViewTitle;

    @InjectView(R.id.textViewBody)
    TextView mTextViewBody;

    @InjectView(R.id.listViewComments)
    ListView mListViewComments;

    CommentsAdapter mCommentsAdapter;

    DetailPresenter mDetailPresenter;
    ForumService mForumService;

    protected int mPostId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.inject(this);

        mPostId = getIntent().getIntExtra("postId", 0);

        ArrayList<comments> dummyComments = new ArrayList<comments>();
        mCommentsAdapter = new CommentsAdapter(this, dummyComments);
        mListViewComments.setAdapter(mCommentsAdapter);

        mForumService = new ForumService();
        mDetailPresenter = new DetailPresenter(this, mForumService);
        mDetailPresenter.loadComments();
        mDetailPresenter.loadPost();
    }

    public int getPostId(){
        return mPostId;
    }

    public void displayComments(List<comments> comments){

        mCommentsAdapter.clear();
        mCommentsAdapter.addAll(comments);
        mCommentsAdapter.notifyDataSetInvalidated();
    }

    public void displayPost(Post post){
        mTextViewTitle.setText(post.title);
        mTextViewBody.setText(post.body);
    }

}
