package com.zonsim.nestedscroll.touch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zonsim.nestedscroll.R;

public class TouchActivity extends AppCompatActivity {
    
    private LinearLayout mLinearLayout;
    private FrameLayout mFrameLayout;
    private TextView mTextView;
    private View mDecorView;
    private View mContentView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_touch);
        
        mLinearLayout = (LinearLayout) findViewById(R.id.ll);
        
        mFrameLayout = (FrameLayout) findViewById(R.id.fl);
        
        mTextView = (TextView) findViewById(R.id.tv);
        
        mDecorView = getWindow().getDecorView();
        
        mDecorView.setContentDescription("DecorView");
        
        mContentView = mDecorView.findViewById(android.R.id.content);
        
        
    }
    
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---dispatchTouchEvent ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
    
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---onTouchEvent ACTION_UP");
                break;
        }
        return true;
    }
}
