package com.example.illum.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by illum on 4/2/2017.
 */

public class CrimePagerActivity extends AppCompatActivity implements CrimeFragment.Callbacks {


    @BindView(R.id.activity_crime_pager_view_pager)
    ViewPager mViewPager;

    private List<Crime> mCrimes;
    private static final String EXTRA_CRIME_ID =
            "com.example.illum.criminalintent.crime_id";

    public static Intent newIntent(Context packegeContext, UUID crimeId) {
        Intent intent = new Intent(packegeContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        ButterKnife.bind(this);
        mViewPager = (ViewPager) findViewById(R.id.activity_crime_pager_view_pager);
        UUID crimeID = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        mCrimes = CrimeLab.get(this).getCrimes();


        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });
        for (int i = 0; i < mCrimes.size(); i++) {
            if (mCrimes.get(i).getId().equals(crimeID)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime) {

    }
}
