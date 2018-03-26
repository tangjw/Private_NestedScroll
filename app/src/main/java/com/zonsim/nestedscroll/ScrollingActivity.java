package com.zonsim.nestedscroll;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.zonsim.nestedscroll.nestingscroll.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {
    
    private float maxHeight;
    private float minHeight;
    
    private float currHeight;
    private CoordinatorLayout mCoordinatorLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling2);
    
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    
        maxHeight = getResources().getDimension(R.dimen.scroll_title_max_height);
        minHeight = getResources().getDimension(R.dimen.scroll_title_min_height);
        currHeight = maxHeight;
        
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.top);
    
        RecyclerView rv = findViewById(R.id.rv);
    
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        
        rv.setLayoutManager(new LinearLayoutManager(this));
    
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("item" + i);
        }
        rv.setAdapter(new MyAdapter(this, data));
    
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                System.out.println("dy: " + dy);
                System.out.println("currHeight1: " + currHeight);
            
                if (currHeight >= minHeight && currHeight <= maxHeight) {
                    currHeight -= dy;
                    System.out.println("currHeight2: " + currHeight);
                    frameLayout.offsetTopAndBottom(-dy);
                }
            }
        });
    
    
    }
    
    public void top(View view) {
        Toast.makeText(this, "top", Toast.LENGTH_SHORT).show();
    }
    
    public void bottom(View view) {
        Toast.makeText(this, "bottom", Toast.LENGTH_SHORT).show();
    }
}
