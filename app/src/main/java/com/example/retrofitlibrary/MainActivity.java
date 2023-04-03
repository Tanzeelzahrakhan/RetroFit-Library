package com.example.retrofitlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String url="https://jsonplaceholder.typicode.com/";
   MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myapi api=retrofit.create(myapi.class);
        Call<List<model>>call=api.getmodels();
           call.enqueue(new Callback<List<model>>() {
               @Override
               public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                   if (response.isSuccessful()) {
                       List<model> posts = response.body();
                       LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
                       recyclerView.setLayoutManager(layoutManager);
                     adapter=new MyAdapter(posts);
                     recyclerView.setAdapter(adapter);
                   } else {
                       Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                   }
               }

               @Override
               public void onFailure(Call<List<model>> call, Throwable t) {

               }
           });

    }
}