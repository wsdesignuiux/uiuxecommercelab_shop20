package com.example.vaibhav.screen20;

import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import adapter.Tab_adapter;

public class Screen20Activity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tablayout;

    private Typeface mTypeface;
    private Typeface mTypefaceBold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen20);
        viewPager=findViewById(R.id.viewpager);
        tablayout=findViewById(R.id.tablayout1);

        setCustomFontAndStyle(tablayout, 0);
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tablayout.addTab(tablayout.newTab().setText("JEANS"));
        tablayout.addTab(tablayout.newTab().setText("PANTS"));
        tablayout.addTab(tablayout.newTab().setText("SANKERS"));
        tablayout.addTab(tablayout.newTab().setText("SHORTS"));
        tablayout.addTab(tablayout.newTab().setText("TIGHTS"));

        Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/sfnsdisplay.ttf");
        ViewGroup vg = (ViewGroup) tablayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
                }
            }
        }

        Tab_adapter adapter = new Tab_adapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(5);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                LinearLayout tabLayout = (LinearLayout)((ViewGroup) tablayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout.getChildAt(1);
                tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.BOLD);
                Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/sfnsdisplay.ttf");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                LinearLayout tabLayout = (LinearLayout)((ViewGroup) tablayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout.getChildAt(1);
                tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.NORMAL);
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setCustomFontAndStyle(TabLayout tabLayout, Integer position) {

        mTypeface = Typeface.createFromAsset(getAssets(), "fonts/sfnsdisplay.ttf");
        mTypefaceBold = Typeface.createFromAsset(getAssets(), "fonts/sfnsdisplay.ttf");
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    if (j == position) {
                        ((TextView) tabViewChild).setTypeface(mTypefaceBold, Typeface.BOLD);
                    } else {
                        ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
                    }
                }
            }
        }
    }
}