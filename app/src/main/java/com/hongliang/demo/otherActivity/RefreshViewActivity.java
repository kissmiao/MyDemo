package com.hongliang.demo.otherActivity;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hongliang.demo.R;

import java.lang.ref.WeakReference;

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

    private EditText mEtData;
    private Handler handler;
    /**
     * 取消AsyncTask
     */
    private Button mBtAsyncTaskClean;
    private ProgressBar mProgressBar;
    private MyTask mTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        initView();


        /**
         * 造成Handler内存泄漏两个原因
         *
         * 1、Handler内部类的创建方式导致隐式持有外部Activity的引用，当Handler所伴随的线程无法及时发送消息，但此时又关闭了Activity
         * 那么线程将持有handler,handler由持有Activity，导致内存无法回收造成泄漏
         * 2、当使用postDelayed延迟发送消息，导致Message占用MessageQueue、message、handler,activity一条消息链，导致Activity无法回收
         * 避免内存泄漏 使用静态内部类 或弱引用并在Activity销毁的时候回收Message
         */

        handler = new MyHandler(this);
        /**
         * AsyncTask子类的实例必须在UI线程中创建
         * AsyncTask也会有和Handler相识的内存泄漏问题
         */
        mTask = new MyTask();


    }


    private class MyHandler extends Handler {
        WeakReference<RefreshViewActivity> weakReference;
        Context context;

        public MyHandler(RefreshViewActivity activity) {
            context = activity;
            weakReference = new WeakReference(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (weakReference.get() != null) {
                if (msg.what == 1) {
                    mEtData.setText("handler");
                }
            }
        }
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
        mEtData = findViewById(R.id.et_data);

        mBtAsyncTaskClean = (Button) findViewById(R.id.bt_asyncTask_clean);
        mBtAsyncTaskClean.setOnClickListener(this);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_handler:
                onHandler();
                break;
            case R.id.bt_postView:
                onPostView();
                break;
            case R.id.bt_runOnUiThread:
                onRunOnUiThread();
                break;
            case R.id.bt_asyncTask:
                /**
                 * ：
                 * 手动调用execute(Params... params) 从而执行异步线程任务
                 * 注：
                 *    a. 必须在UI线程中调用
                 *    b. 同一个AsyncTask实例对象只能执行1次，若执行第2次将会抛出异常
                 *    c. 执行任务中，系统会自动调用AsyncTask的一系列方法：onPreExecute() 、doInBackground()、onProgressUpdate() 、onPostExecute()
                 *    d. 不能手动调用上述方法
                 */
                mTask.execute();
                break;
            case R.id.bt_asyncTask_clean:
                /**
                 *  取消一个正在执行的任务,onCancelled方法将会被调用
                 *  先点击取消销毁后，再执行会报错
                 */
                mTask.cancel(true);
                break;
        }
    }


    private void onRunOnUiThread() {

        /**
         * 执行完run()方法Thread就进入到死亡状态，当run()方法存在柱塞的时候，要注意回收线程
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEtData.setText("runOnUiThread");
                    }
                });


            }
        });
        thread.start();

    }


    private void onPostView() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                mEtData.post(new Runnable() {
                    @Override
                    public void run() {
                        mEtData.setText("onPostView");
                    }
                });

            }
        });
        thread.start();
    }


    private void onHandler() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = handler.obtainMessage();
                message.what = 1;
                handler.sendMessage(message);
            }
        });
        thread.start();

    }


    /**
     * 步骤1：创建AsyncTask子类
     * 注：
     * a. 继承AsyncTask类
     * b. 为3个泛型参数指定类型；若不使用，可用java.lang.Void类型代替
     * 此处指定为：输入参数 = String类型、执行进度 = Integer类型、执行结果 = String类型
     * c. 根据需求，在AsyncTask子类内实现核心方法
     */
    private class MyTask extends AsyncTask<String, Integer, String> {
        /**
         * 方法1：onPreExecute（）
         * 作用：执行 线程任务前的操作
         */
        @Override
        protected void onPreExecute() {
            mEtData.setText("加载中");
            // 执行前显示提示
        }


        /**
         * 方法2：doInBackground（）
         * 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
         * 此处通过计算从而模拟“加载进度”的情况
         *
         * @param strings
         * @return
         */
        @Override
        protected String doInBackground(String... strings) {

            try {
                int count = 0;
                int length = 1;
                while (count < 99) {

                    count += length;
                    // 可调用publishProgress（）显示进度, 之后将执行onProgressUpdate（）
                    publishProgress(count);
                    // 模拟耗时任务
                    //中途取消的时候会 java.lang.InterruptedException
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * 方法3：onProgressUpdate（）
         * 作用：在主线程 显示线程任务执行的进度
         *
         * @param progresses
         */
        @Override
        protected void onProgressUpdate(Integer... progresses) {
            mProgressBar.setProgress(progresses[0]);
            mEtData.setText("loading..." + progresses[0] + "%");

        }

        /**
         * 方法4：onPostExecute（）
         * 作用：接收线程任务执行结果、将执行结果显示到UI组件
         *
         * @param result
         */
        @Override
        protected void onPostExecute(String result) {
            // 执行完毕后，则更新UI
            mEtData.setText("加载完毕");
        }


        /**
         * 方法5：onCancelled()
         * 作用：将异步任务设置为：取消状态
         */
        @Override
        protected void onCancelled() {

            mEtData.setText("已取消");
            mProgressBar.setProgress(0);

        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);

    }
}
