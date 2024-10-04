package com.example.demobookrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demobookrecyclerview.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        List<Book> books = new ArrayList<Book>();
        Book book = new Book();
        book.setBook_name("Alice in wonderland");
        book.setBook_image("https://th.bing.com/th/id/R.2b32136ce2d5bb5a0f0e94e246026de9?rik=hD6spMHaGSczmg&pid=ImgRaw&r=0");
        book.setBook_price(700);
        books.add(book);

        Book book2 = new Book();
        book2.setBook_name("Clifford");
        book2.setBook_image("https://th.bing.com/th/id/R.468b10d89f0fc0c0c078b10f175cada0?rik=UA8PS0hKNpQ8Rw&riu=http%3a%2f%2fcdn.collider.com%2fwp-content%2fuploads%2fclifford-the-big-red-dog-image.jpg&ehk=XhvXTY4ZcO1fC%2fvzeV%2b%2fluGEi4CExMMqfSNB9zAKG5g%3d&risl=&pid=ImgRaw&r=0");
        book2.setBook_price(600);
        books.add(book2);

        Book book3 = new Book();
        book3.setBook_name("Harry Potter");
        book3.setBook_image("https://th.bing.com/th/id/R.ccc73b764f3911217a29c0240f6e45cd?rik=Pe1MlzTSMvRBVw&riu=http%3a%2f%2fsartorialgeek.com%2fwp-content%2fuploads%2f2019%2f04%2fharry_potter_footage_header.jpeg&ehk=D0ZiiuL9mcJO1XgwPmD2UvNunzUmwN%2fXQl94p1oFpy4%3d&risl=&pid=ImgRaw&r=0");
        book3.setBook_price(800);
        books.add(book3);

        Book book4 = new Book();
        book4.setBook_name("Pippi Longstocking");
        book4.setBook_image("https://i.pinimg.com/originals/2d/89/83/2d8983c2aaec41b8a2be2f045c4fa778.jpg");
        book4.setBook_price(500);
        books.add(book4);


        // ส่ง books ไปให้ MyAdapteR
        mAdapter = new MyAdapter(books, this);
        recyclerView.setAdapter(mAdapter);
    }
}