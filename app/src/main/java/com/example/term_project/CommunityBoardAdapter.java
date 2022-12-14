package com.example.term_project;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.term_project.board.community_board.response.result.GetCommunitesResult;

import java.util.ArrayList;

public class CommunityBoardAdapter extends RecyclerView.Adapter<CommunityBoardAdapter.ViewHolder>{
    private ArrayList<GetCommunitesResult> result;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout itemLayout;
        TextView grade,title,content,createdAt,commentCount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemLayout = itemView.findViewById(R.id.community_item_cl_js);
            grade = itemView.findViewById(R.id.community_grade_number_tv_js);
            title = itemView.findViewById(R.id.community_title_js);
            content = itemView.findViewById(R.id.community_content_tv_js);
            createdAt = itemView.findViewById(R.id.community_created_js);
            commentCount = itemView.findViewById(R.id.community_comment_count_tv_js);
        }
    }

    public CommunityBoardAdapter(ArrayList<GetCommunitesResult> result, Context context) {
        this.result = result;
        this.context = context;
    }

    public ArrayList<GetCommunitesResult> getResult() {
        return result;
    }

    public void setResult(ArrayList<GetCommunitesResult> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.community_recyclerview_item, parent, false);
        CommunityBoardAdapter.ViewHolder vh = new CommunityBoardAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int touchIndex = holder.getAdapterPosition();
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,CommunityDetailActivity.class);
                intent.putExtra("touchIndex",touchIndex);
                intent.putExtra("title",result.get(touchIndex).getTitle());
                intent.putExtra("content",result.get(touchIndex).getContent());
                intent.putExtra("userIdx",result.get(touchIndex).getUserIdx());
                intent.putExtra("communityIdx",result.get(touchIndex).getCommunityIdx());
                intent.putExtra("correctCreatedAt",result.get(touchIndex).getCorrectCreatedAt());
                intent.putExtra("nickname",result.get(touchIndex).getNickname());
                context.startActivity(intent);
            }
        });
        holder.grade.setText(String.valueOf(result.get(position).getGrade()));
        holder.title.setText(result.get(position).getTitle());
        holder.content.setText(result.get(position).getContent());
        holder.createdAt.setText(result.get(position).getCreatedAt());
        holder.commentCount.setText(String.valueOf(result.get(position).getCommentCount()));
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
}
