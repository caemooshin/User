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
import com.example.y_v_d.user.models.comments;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Y-V-D on 2017-06-18.
 */

public class CommentsAdapter extends ArrayAdapter<comments> {


    public CommentsAdapter(Context ctx, ArrayList<comments> posts) {
        super(ctx, 0, posts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        comments comment = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_comment_item, parent, false);

        CommentViewWrapper view = new CommentViewWrapper();
        ButterKnife.inject(view, convertView);
        view.load(comment);

        return convertView;
    }

    class CommentViewWrapper{

        @InjectView(R.id.textViewCommentName)
        protected TextView name;

        @InjectView(R.id.textViewCommentEmail)
        protected TextView email;

        @InjectView(R.id.textViewCommentBody)
        protected TextView body;

        public void load(comments comment){

            name.setText(comment.name);
            email.setText(comment.email);
            body.setText(comment.body);
        }
    }
}
