package com.payforward.androidapp.onboard;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.payforward.androidapp.R;

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