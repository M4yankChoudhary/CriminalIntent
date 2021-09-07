package me.mayankchoudhary.criminalintent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.mayankchoudhary.criminalintent.RecyclerView.CrimeListAdapter;

public class CrimeListFragment extends Fragment {
    private CrimeLab crimeLab = CrimeLab.get(getActivity());
    private List<Crime> mCrimes = crimeLab.getCrimes();
//    private List<Crime> mCrimes;
    private CrimeListAdapter mCrimeListAdapter;
    private RecyclerView mCrimeRecyclerView;



    public CrimeListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = v.findViewById(R.id.crime_list_recycler);
//        mCrimes = new ArrayList<>();
        mCrimeListAdapter = new CrimeListAdapter(getContext(), mCrimes);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false));
        mCrimeRecyclerView.setAdapter(mCrimeListAdapter);
//        updateUI();
        return v;
    }

//    private void updateUI() {
//        CrimeLab crimeLab = CrimeLab.get(getActivity());
//        List<Crime> crimeList = crimeLab.getCrimes();
//        for(Crime crime: crimeList) {
//            mCrimes.add(crime);
//        }
//        mCrimeListAdapter.notifyDataSetChanged();
//    }
}
