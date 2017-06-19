package com.example.y_v_d.user.presenters;

import com.example.y_v_d.user.models.Post;
import com.example.y_v_d.user.models.comments;
import com.example.y_v_d.user.services.ForumService;
import com.example.y_v_d.user.views.DetailActivity;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Y-V-D on 2017-06-19.
 */

public class DetailPresenter {
    DetailActivity mView;
    ForumService mForum;

    public DetailPresenter(DetailActivity activity, ForumService mForum) {
        this.mView = activity;
        this.mForum = mForum;
    }

    public void loadPost(){

        mForum.getApi()
                .getPost(mView.getPostId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Post>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Post post) {

                        mView.displayPost(post);
                    }
                });
    }

    public void loadComments() {

        mForum.getApi()
                .getComments(mView.getPostId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<comments>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<comments> comments) {

                        mView.displayComments(comments);
                    }
                });
    }

}
