package com.hongliang.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.hongliang.demo.source.AFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private RadioGroup host;
    private int currentItem = 0;

    private String TAG = "EventDistribute";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        host = (RadioGroup) findViewById(R.id.rg_host);
        host.setOnCheckedChangeListener(MainActivity.this);

        viewPager = (ViewPager) findViewById(R.id.vp_event);
        viewPager.setOffscreenPageLimit(1);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new AFragment());
        fragmentList.add(new BFragment());

        PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.bt_product:
                if (currentItem != 0) {
                    viewPager.setCurrentItem(0, true);
                }
                break;
            case R.id.bt_ranking:
                if (currentItem != 1) {
                    viewPager.setCurrentItem(1, true);
                }
                break;
            default:
                break;
        }
    }


    private class PageAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;

        public PageAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.list = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    //viewPage 当前位置 position
    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                currentItem = 0;
                host.check(R.id.bt_product);
                break;
            case 1:
                currentItem = 1;
                host.check(R.id.bt_ranking);
                break;
            default:
                break;
        }
    }


    // arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，arg0==0的时辰默示什么都没做。
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
