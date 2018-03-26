package com.zonsim.nestedscroll.behavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.zonsim.nestedscroll.R;

@SuppressWarnings("all")
public class BehaviorActivity extends AppCompatActivity {
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
        
        final Button button = (Button) findViewById(R.id.btn);
        
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    v.setX(event.getRawX() - v.getWidth() / 2);
                    v.setY(event.getRawY() - v.getHeight() / 2);
                }
                return true;
            }
        });
        
    }
}
