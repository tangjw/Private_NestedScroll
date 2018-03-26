package com.zonsim.nestedscroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zonsim.nestedscroll.behavior.BehaviorActivity;
import com.zonsim.nestedscroll.nestingscroll.NestedScrollActivity;
import com.zonsim.nestedscroll.touch.TouchActivity;

public class MainActivity extends AppCompatActivity {
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void click1(View view) {
        startActivity(new Intent(this, TouchActivity.class));
        
        
    }
    
    public void click2(View view) {
        startActivity(new Intent(this, NestedScrollActivity.class));
    }
    
    public void click3(View view) {
        startActivity(new Intent(this, BehaviorActivity.class));
    }
    
    public void click(View view) {
        startActivity(new Intent(this, ScrollingActivity.class));
    }
}
