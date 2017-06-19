package com.example.y_v_d.user.services;

import com.example.y_v_d.user.models.Post;
import com.example.y_v_d.user.models.comments;
import java.util.List;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;
/**
 * Created by Y-V-D on 2017-06-18.
 */

public class ForumService {
    public static final String FORUM_SERVER_URL = "http://jsonplaceholder.typicode.com";
    private ForumApi mForumApi;

    public ForumService(){

        RequestInterceptor requestInterceptor = new RequestInterceptor(){
            @Override
            public void intercept(RequestFacade request){
                request.addHeader("Accept", "application/json");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(FORUM_SERVER_URL)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        mForumApi = restAdapter.create(ForumApi.class);
    }

    public ForumApi getApi(){
        return mForumApi;
    }

    public interface ForumApi{

        @GET("/posts")
        public Observable<List<Post>>
        getPosts();

        @GET("/posts/{id}")
        public Observable<Post>
        getPost(@Path("id") int postId);

        @GET("/comments")
        public Observable<List<comments>>
        getComments(@Query("postId") int postId);

        @POST("/posts")
        public Observable<Post>
        postPost(Post post);

    }
}
