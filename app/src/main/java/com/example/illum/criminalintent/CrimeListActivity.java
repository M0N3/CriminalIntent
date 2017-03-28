package com.example.illum.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by illum on 3/28/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
