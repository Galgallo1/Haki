package com.example.haki;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class IncidencesListAdapter extends RecyclerView.Adapter<IncidencesListAdapter.IncidencesViewHolder>{
    List<Article> mArticles;
    Context mContext;
    Article article;


    public IncidencesListAdapter(List<Article> mArticles, Context mContext) {
        this.mArticles = mArticles;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public IncidencesListAdapter.IncidencesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.incidences_list_item, parent, false);
        IncidencesViewHolder viewHolder = new IncidencesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IncidencesViewHolder holder, int position) {
        holder.bindArticles(mArticles.get(position));
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }





    public class IncidencesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.restaurantImageView) ImageView mRestaurantImageView;
        @BindView(R.id.restaurantNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.categoryTextView1) TextView mCategoryTextView1;
        @BindView(R.id.source) TextView mRatingTextView;

        private Context mContext;



        public IncidencesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();


        }

        public void bindArticles(Article articles){
            Picasso.get().load(articles.getUrlToImage()).into(mRestaurantImageView);
            mNameTextView.setText(articles.getTitle());
            mCategoryTextView.setText(articles.getDescription());
            mCategoryTextView1.setText("Read more...");
            mRatingTextView.setText("Source: " + articles.getSource().getName());
        }



//        @Override
//        public void onClick(View view) {
//            if(view == mCategoryTextView1){
//                Intent webIntent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse(article.getUrl()));
//                startActivity(webIntent);
//            }
//        }
    }
}
