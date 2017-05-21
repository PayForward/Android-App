package com.payforward.androidapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.app.Activity;

public class IntroPageFragment extends Fragment {
    public static IntroPageFragment newInstance(){
        return new IntroPageFragment();
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_intro_page, container, false);
//        final Activity activity = getActivity();
//        final RecyclerView recyclerView = ()
        return rootView;
    }
}