package com.example.keeplone.lab4_2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.keeplone.lab4_2.R.id.height;
import static com.example.keeplone.lab4_2.R.id.weight;


/**
 * A simple {@link Fragment} subclass.
 */
public class BmiFragment extends Fragment implements View.OnClickListener {
    private Button btnCal;
    private EditText h;
    private EditText w;
   // private double x;


    public BmiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_bmi, container, false);
        btnCal = (Button) myView.findViewById(R.id.btnCal);
        btnCal.setOnClickListener(this);
        h = (EditText) myView.findViewById(R.id.height);
        w = (EditText) myView.findViewById(R.id.weight);
        //x = Double.parseDouble(h.getText().toString());
        return myView;
        //inflater.inflate(R.layout.fragment_bmi, container, false);
    }


    @Override
    public void onClick(View v) {
        double n1 = Double.parseDouble(h.getText().toString());
        double n2 = Double.parseDouble(w.getText().toString());
        double m = (n1/100);
        double result = n2/(m*m);
        Toast.makeText(getActivity(), "Bmi = "+ result, Toast.LENGTH_SHORT).show();
    }
}
