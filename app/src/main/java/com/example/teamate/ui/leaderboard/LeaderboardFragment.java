package com.example.teamate.ui.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.Iterator;


import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.teamate.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LeaderboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_leaderboard, container, false);


        ListView listview = (ListView) root.findViewById(R.id.listview2);
        LinkedHashMap<String, String> nameDepartment = new LinkedHashMap<>();
        nameDepartment.put("1. Josh Allen (HR Team)", "120 Points");
        nameDepartment.put("2. Johnny Gaudreau (Development Team)", "104 points");
        nameDepartment.put("3. Jacob Hazen (Accounting Team)", "83 points");
        nameDepartment.put("4. Lebron James (HR Team)", "72 points");
        nameDepartment.put("5. Serena Williams (Marketing Team)", "61 points");
        nameDepartment.put("6. Alex Ovechkin (HR Team)", "58 points");
        nameDepartment.put("7. Michael Jordan (Development Team)", "47 points");
        nameDepartment.put("8. Michael Jackson (Marketing Team)", "44 points");
        nameDepartment.put("9. Jackie Chan (HR Team)", "38 points");

        List<HashMap<String, String>> listItems = new ArrayList<>();




        SimpleAdapter adapter = new SimpleAdapter(getActivity(), listItems, R.layout.listview,
                new String[]{"this line first", "then this line"},
                new int[]{R.id.text1, R.id.text2});

        Iterator it = nameDepartment.entrySet().iterator();
        while (it.hasNext())
        {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("this line first", pair.getKey().toString());
            resultsMap.put("then this line", pair.getValue().toString());
            listItems.add(resultsMap);
        }

        listview.setAdapter(adapter);


        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        // View root = inflater.inflate(R.layout.fragment_leaderboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        /*
        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                names
        );


*/

        //listview.setAdapter(listviewAdapter);
        return root;
    }
}