package com.yy.android.myapplicationaaq.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yy.android.myapplicationaaq.R;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class OneFragment extends Fragment {

    private static final String TAG = "OneFragment";
    UserViewModel userViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel =
                new ViewModelProvider(getActivity(),new UserViewModelFactory()).get(UserViewModel.class);
        userViewModel.getSet().observe(this, new Observer<List<RemoteUserData>>() {
            @Override
            public void onChanged(List<RemoteUserData> remoteUserData) {
                ((TextView) getActivity().findViewById(R.id.text)).setText(remoteUserData.toString());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}