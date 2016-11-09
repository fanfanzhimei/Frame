package com.zhi.frame;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.MessageQueue;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setBackgroundResource(R.drawable.frame);

        final AnimationDrawable drawable = (AnimationDrawable) mTextView.getBackground();

        getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                drawable.start();
                return false;
            }
        });
    }
}