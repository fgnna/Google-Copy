package com.it.googlecopy.module.home;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.it.googlecopy.R;

/**
 * Created by je on 16-10-11.
 */

public class SettingDetailFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_settings);

    }
}
