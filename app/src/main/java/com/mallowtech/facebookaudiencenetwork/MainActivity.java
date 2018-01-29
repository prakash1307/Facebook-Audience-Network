package com.mallowtech.facebookaudiencenetwork;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mallowtech.facebookaudiencenetwork.Fragments.BannerAdsFragment;
import com.mallowtech.facebookaudiencenetwork.Fragments.InterstitialAdsFragment;
import com.mallowtech.facebookaudiencenetwork.Fragments.NativeAdsFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnBannerAds = findViewById(R.id.btn_banner_ad);
        Button btnInterstitialAds = findViewById(R.id.btn_interstitial_ad);
        Button btnNativeAds = findViewById(R.id.btn_native_ad);

        btnBannerAds.setOnClickListener(this);
        btnInterstitialAds.setOnClickListener(this);
        btnNativeAds.setOnClickListener(this);
    }

    /**
     * Method to replace the fragments
     *
     * @param activity          The activity hosting the fragments
     * @param fragmentToReplace The fragment to replace
     * @param addToBackStack    Whether to add the fragment to backstack or not
     * @param containerId       The frame layout containing the fragment
     */
    protected void replaceFragment(FragmentActivity activity, Fragment fragmentToReplace, boolean addToBackStack, int containerId) {
        if (activity != null) {
            FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(containerId, fragmentToReplace);
            if (addToBackStack) {
                fragmentTransaction.addToBackStack(null);
            }
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_banner_ad:
                BannerAdsFragment bannerAdsFragment = BannerAdsFragment.newInstance();
                replaceFragment(this, bannerAdsFragment, true, R.id.fragment_container);
                break;
            case R.id.btn_interstitial_ad:
                InterstitialAdsFragment interstitialAdsFragment = InterstitialAdsFragment.newInstance();
                replaceFragment(this, interstitialAdsFragment, true, R.id.fragment_container);
                break;
            case R.id.btn_native_ad:
                NativeAdsFragment nativeAdsFragment = NativeAdsFragment.newInstance();
                replaceFragment(this, nativeAdsFragment, true, R.id.fragment_container);
                break;
        }
    }
}
