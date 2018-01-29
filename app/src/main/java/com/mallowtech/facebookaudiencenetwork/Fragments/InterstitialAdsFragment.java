package com.mallowtech.facebookaudiencenetwork.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.mallowtech.facebookaudiencenetwork.R;

/**
 * Created by prakash.baskar on 29/01/18.
 */

public class InterstitialAdsFragment extends Fragment {
    private static final String TAG = "InterstitialAdsFragment";
    private InterstitialAd interstitialAd;

    public static InterstitialAdsFragment newInstance() {

        Bundle args = new Bundle();

        InterstitialAdsFragment fragment = new InterstitialAdsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_interstitial_ads, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadInterstitialAd();
    }

    private void loadInterstitialAd() {
        interstitialAd = new InterstitialAd(getActivity(), "YOUR_PLACEMENT_ID");
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override public void onInterstitialDisplayed(Ad ad) {
                Log.d(TAG, "onInterstitialDisplayed: ");
            }

            @Override public void onInterstitialDismissed(Ad ad) {
                Log.d(TAG, "onInterstitialDismissed: ");
            }

            @Override public void onError(Ad ad, AdError adError) {
                Log.d(TAG, "onError: " + adError.getErrorMessage());
            }

            @Override public void onAdLoaded(Ad ad) {
                Log.d(TAG, "onAdLoaded: ");
                interstitialAd.show();
            }

            @Override public void onAdClicked(Ad ad) {
                Log.d(TAG, "onAdClicked: ");
            }

            @Override public void onLoggingImpression(Ad ad) {
                Log.d(TAG, "onLoggingImpression: ");
            }
        });

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd();
    }

    @Override
    public void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }
}
