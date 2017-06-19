package com.example.y_v_d.user.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.y_v_d.user.R;
import com.example.y_v_d.user.models.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Y-V-D on 2017-06-18.
 */

public class PostsAdapter extends ArrayAdapter<Post> {
    public PostsAdapter( Context ctx, ArrayList<Post> posts) {
        super(ctx, 0, posts);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Post post = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_post_item, parent, false);

        TextView title = (TextView) convertView.findViewById(R.id.textViewItemTitle);
        title.setText(post.title);

        return convertView;
    }
}
