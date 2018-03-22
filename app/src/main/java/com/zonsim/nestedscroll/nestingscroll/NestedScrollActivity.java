package com.zonsim.nestedscroll.nestingscroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zonsim.nestedscroll.R;

import java.util.ArrayList;
import java.util.List;

public class NestedScrollActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest_scroll);
    
        RecyclerView rv = findViewById(R.id.rv);
    
        rv.setLayoutManager(new LinearLayoutManager(this));
    
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("item" + i);
        }
        rv.setAdapter(new MyAdapter(this, data));
        
        
       /* rv.setChildDrawingOrderCallback(new RecyclerView.ChildDrawingOrderCallback() {
            @Override
            public int onGetChildDrawingOrder(int childCount, int i) {
                return 0;
            }
        });*/
    
        rv.setOnFlingListener(new RecyclerView.OnFlingListener() {
            @Override
            public boolean onFling(int velocityX, int velocityY) {
                System.out.println("velocityX: " + velocityX);
                System.out.println("velocityY: " + velocityY);
                return false;
            }
        });
    
    
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                System.out.println("newState: " + newState);
            }
        
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                System.out.println("dy: " + dy);
            }
        });
    
    }
    
    public void back(View view) {
        finish();
    }
    
    public void toast(View view) {
        
        Toast.makeText(this, "hhhhh", Toast.LENGTH_SHORT).show();
        
    }
}
