package com.example.keeplone.lab4_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class WelcomeActivity extends AppCompatActivity {

    private Button btnNext, btnSkip;
    private SmartTabLayout indicator;
    private ViewPager pager;
    static final int TOTAL_PAGES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnSkip = (Button) findViewById(R.id.btnSkip);
        indicator = (SmartTabLayout) findViewById(R.id.indicator);
        pager = (ViewPager) findViewById(R.id.pager);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                WelcomeFragment fragment = null;
                switch (position){
                    case 0:
                        fragment = WelcomeFragment.newInstance(R.layout.fragment_one);
                        break;
                    case 1:
                        fragment = WelcomeFragment.newInstance(R.layout.fragment_two);
                        break;
                    case 2:
                        fragment = WelcomeFragment.newInstance(R.layout.fragment_three);
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return TOTAL_PAGES;
            }
        };
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == TOTAL_PAGES -1){
                    btnNext.setText("Done");
                    btnSkip.setVisibility(View.GONE);
                }
                else{
                    btnNext.setText("Next");
                    btnSkip.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pager.getCurrentItem() == TOTAL_PAGES-1){
                    finishWelcome();
                }
                else {
                    pager.setCurrentItem(pager.getCurrentItem()+1, true);
                }
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishWelcome();
            }
        });
    }

    private void finishWelcome() {
        SharedPreferences preferences = getSharedPreferences("my_preferences",
                MODE_PRIVATE);
        preferences.edit().putBoolean("welcome_complete", true).apply();
        Intent main = new Intent(this, MenuNavigation.class);
        startActivity(main);
        finish();
    }

}
