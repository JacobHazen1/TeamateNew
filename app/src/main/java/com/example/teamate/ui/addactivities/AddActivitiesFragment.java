package com.example.teamate.ui.addactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.teamate.Contactus;
import com.example.teamate.LoginActivity;
import com.example.teamate.R;

public class AddActivitiesFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private ListView activitieslist;
    private TextView addyoga;
    private TextView addworkout;
    private TextView addbike;
    private TextView addvolunteer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_addactivities, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        addyoga = (TextView) root.findViewById(R.id.addYoga);
        addyoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddActivitiesFragment.this.getActivity(), LoginActivity.class));
            }
        });
//        addworkout = (TextView) root.findViewById(R.id.addworkout);
//        addworkout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(AddActivitiesFragment.this.getActivity(), Contactus.class));
//            }
//        });
//
//        addbike = (TextView) root.findViewById(R.id.addbiketowork);
//        addbike.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(AddActivitiesFragment.this.getActivity(), LoginActivity.class));
//            }
//        });
//        addvolunteer = (TextView) root.findViewById(R.id.addvolunteering);
//        addvolunteer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(AddActivitiesFragment.this.getActivity(), LoginActivity.class));
//            }
//        });
//





        return root;

    }
}