package com.example.demobookrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demobookrecyclerview.model.Book;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Book> books;
    private Context context;

    public MyAdapter(List<Book> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Book book = books.get(position);
        holder.firstLine.setText(book.getBook_name());
        holder.secondLine.setText(String.valueOf(book.getBook_price()));
        Glide.with(context).load(book.getBook_image()).into(holder.icon);

        // Set up the click listener
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookDetailActivity.class);
            intent.putExtra("BOOK_NAME", book.getBook_name());
            intent.putExtra("BOOK_PRICE", String.valueOf(book.getBook_price()));
            intent.putExtra("BOOK_IMAGE", book.getBook_image());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView firstLine;
        public TextView secondLine;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            firstLine = view.findViewById(R.id.firstLine);
            secondLine = view.findViewById(R.id.secondLine);
            icon = view.findViewById(R.id.icon);
        }
    }
}
