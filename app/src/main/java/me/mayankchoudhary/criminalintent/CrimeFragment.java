package me.mayankchoudhary.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.UUID;
import static me.mayankchoudhary.criminalintent.RecyclerView.CrimeListAdapter.EXTRA_CRIME;

//CrimeFragment is a controller that
//interacts with model and view objects.
public class CrimeFragment extends Fragment {

//    private Crime crime;
    Crime crime = null;
    private EditText title;
    private Button button;
    private CheckBox checkBox;
    private Object obj;

    public CrimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        crime = new Crime();
        obj = getActivity().getIntent()
                        .getSerializableExtra(EXTRA_CRIME);
        if(obj instanceof Crime){
            crime = (Crime) obj;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        title = v.findViewById(R.id.crime_title);
        button = v.findViewById(R.id.crime_date);
        button.setText(crime.getDate().toString());
        button.setEnabled(false);
        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        title.setText(crime.getTitle());
        checkBox = v.findViewById(R.id.solved_or_not);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> crime.setSolved(isChecked));
        checkBox.setChecked(crime.isSolved());
        // The third
        //parameter tells the layout inflater
        //whether to add the inflated view to the
        //view’s parent. You pass in false
        //because you will add the view in the
        //activity’s code.
        return v;
    }
}