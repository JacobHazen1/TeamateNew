package com.example.teamate.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.teamate.LoginActivity;
import com.example.teamate.R;

public class ActivitiesFragment extends Fragment {
    private TextView hryoga;



    //    private ActivitiesViewModel activitiesViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        final View root = inflater.inflate(R.layout.fragment_activities, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        hryoga = (TextView) root.findViewById(R.id.HR_Yoga);
        hryoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivitiesFragment.this.getActivity(), LoginActivity.class));
            }
        });

//        return rootview;
//        activitiesViewModel =
//                ViewModelProviders.of(this).get(ActivitiesViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_activities, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        activitiesViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}