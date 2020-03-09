package com.boda.renuka.guessnamegame;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;

/**
 * Created by renuka on 22/8/18.
 */

public class LoginActivity extends AppCompatActivity {
    private static final int ADMIN_INTENT = 1;
    private DevicePolicyManager mDevicePolicyManager;
    private ComponentName mComponentName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
//        mDevicePolicyManager = (DevicePolicyManager)getSystemService(
//                Context.DEVICE_POLICY_SERVICE);
//        mComponentName = new ComponentName(this, Admin.class);
//        switchCompat=(SwitchCompat)findViewById(R.id.switchButton);
//        if( mDevicePolicyManager != null && mDevicePolicyManager.isAdminActive(mComponentName)) {
//            switchCompat.setChecked(true);
//        }
    }

    private void init() {
    }
}
