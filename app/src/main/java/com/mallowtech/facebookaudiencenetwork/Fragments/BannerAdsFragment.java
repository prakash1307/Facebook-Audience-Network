package com.mallowtech.facebookaudiencenetwork.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.mallowtech.facebookaudiencenetwork.R;

/**
 * Created by prakash.baskar on 29/01/18.
 */

public class BannerAdsFragment extends Fragment {
    private static final String TAG = "BannerAdsFragment";
    private AdView adView;

    public static BannerAdsFragment newInstance() {

        Bundle args = new Bundle();

        BannerAdsFragment fragment = new BannerAdsFragment();
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
        return inflater.inflate(R.layout.fragment_banner_ads, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadBannerAds();
    }

    private void loadBannerAds() {
        adView = new AdView(getActivity(), "970996696390468_971032989720172", AdSize.BANNER_HEIGHT_50);

        // Find the Ad container
        LinearLayout adContainer = getView().findViewById(R.id.banner_container);


        // Add the ad view to container
        adContainer.addView(adView);

        adView.setAdListener(new AdListener() {
            @Override public void onError(Ad ad, AdError adError) {
                Log.d(TAG, "onError: " + adError.getErrorMessage());
            }

            @Override public void onAdLoaded(Ad ad) {
                Log.d(TAG, "onAdLoaded: ");
            }

            @Override public void onAdClicked(Ad ad) {
                Log.d(TAG, "onAdClicked: ");
            }

            @Override public void onLoggingImpression(Ad ad) {
                Log.d(TAG, "onLoggingImpression: ");
            }
        });

        // Request an ad
        adView.loadAd();
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}
