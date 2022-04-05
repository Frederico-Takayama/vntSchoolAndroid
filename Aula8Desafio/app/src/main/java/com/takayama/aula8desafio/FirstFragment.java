package com.takayama.aula8desafio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    TextView tvNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnInc = view.findViewById(R.id.button);
        tvNumber = view.findViewById(R.id.tv_number);

        if(savedInstanceState != null) {
            String numStr = savedInstanceState.getString("number_text");
            tvNumber.setText(numStr);
        }

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numStr = tvNumber.getText().toString();
                Integer num = Integer.parseInt(numStr);
                num ++;
                tvNumber.setText(num.toString());
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String numStr = tvNumber.getText().toString();
        outState.putString("number_text", numStr);
    }
}
