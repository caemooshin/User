package com.example.y_v_d.user.presenters;

import android.widget.ListView;

import com.example.y_v_d.user.models.Post;
import com.example.y_v_d.user.services.ForumService;
import com.example.y_v_d.user.views.ListActivity;

import java.util.List;

import rx.Observer;
import rx.schedulers.Schedulers;

/**
 * Created by Y-V-D on 2017-06-19.
 */

public class ListPresenter {
    ListActivity mView;
    ForumService mForum;

    public ListPresenter(ListActivity view, ForumService forum) {
        mView = view;
        mForum = forum;
    }

    public void loadPosts(){
        mForum.getApi()
                .getPosts()
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        mView.displayPosts(posts);
                    }
                });
    }

}
