package com.example.term_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.term_project.board.evaluate_board.response.result.GetEvaluateSubjectResult;
import com.example.term_project.board.evaluate_board.response.result.GetSubjectReviewsResult;

import java.util.ArrayList;

public class EvaluateReviewAdapter extends RecyclerView.Adapter<EvaluateReviewAdapter.ViewHolder>{
    private ArrayList<GetSubjectReviewsResult> result;
    private Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nickName,content;
        RatingBar ratingBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nickName = itemView.findViewById(R.id.subject_review_nick_name_tc_js);
            content = itemView.findViewById(R.id.review_content_tv_js);
            ratingBar = itemView.findViewById(R.id.subject_score_rb_js);
        }
    }

    public EvaluateReviewAdapter(ArrayList<GetSubjectReviewsResult> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public EvaluateReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.review_subject_recyclerview_item, parent, false);
        EvaluateReviewAdapter.ViewHolder vh = new EvaluateReviewAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull EvaluateReviewAdapter.ViewHolder holder, int position) {
        holder.nickName.setText(result.get(position).getNickName());
        holder.content.setText(result.get(position).getContent());
        holder.ratingBar.setRating(result.get(position).getScore());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
}
