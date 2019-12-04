package com.example.teamate.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.teamate.Contactus;
import com.example.teamate.LoginActivity;
import com.example.teamate.R;
import com.example.teamate.ui.addactivities.AddActivitiesFragment;

import java.util.Set;

public class SettingsFragment extends Fragment {

    private settingsViewModel settingsViewModel;
    private TextView logout;
    private TextView contactus;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                ViewModelProviders.of(this).get(settingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        logout = (TextView)root.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsFragment.this.getActivity(), LoginActivity.class));
            }
        });
        contactus = (TextView)root.findViewById(R.id.contactus);
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsFragment.this.getActivity(), Contactus.class));
            }
        });

//        final TextView textView = root.findViewById(R.id.text_settings);
//        settingsViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}