package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.hongliang.demo.R;

public class RefreshViewActivity extends Activity implements View.OnClickListener {


    /**
     * Handler
     */
    private Button mBtHandler;
    /**
     * postView
     */
    private Button mBtPostView;
    /**
     * AsyncTask
     */
    private Button mBtAsyncTask;
    /**
     * runOnUiThread
     */
    private Button mBtRunOnUiThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        initView();


    }

    private void initView() {
        mBtHandler = (Button) findViewById(R.id.bt_handler);
        mBtHandler.setOnClickListener(this);
        mBtPostView = (Button) findViewById(R.id.bt_postView);
        mBtPostView.setOnClickListener(this);
        mBtAsyncTask = (Button) findViewById(R.id.bt_asyncTask);
        mBtAsyncTask.setOnClickListener(this);
        mBtRunOnUiThread = (Button) findViewById(R.id.bt_runOnUiThread);
        mBtRunOnUiThread.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_handler:
                break;
            case R.id.bt_postView:
                break;
            case R.id.bt_asyncTask:
                break;
            case R.id.bt_runOnUiThread:
                break;
        }
    }
}
