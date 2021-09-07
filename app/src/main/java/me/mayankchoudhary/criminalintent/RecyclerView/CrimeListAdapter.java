package me.mayankchoudhary.criminalintent.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.mayankchoudhary.criminalintent.Crime;
import me.mayankchoudhary.criminalintent.R;

public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.ViewHolder> {

    private Context applicationContext;
    private List<Crime> crimeList;

    public CrimeListAdapter(Context applicationContext, List<Crime> crimeList) {
        this.applicationContext = applicationContext;
        this.crimeList = crimeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(applicationContext).inflate(R.layout.list_item_crime, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTitle.setText(crimeList.get(position).getTitle());
        holder.mDate.setText(crimeList.get(position).getDate().toString());
    }

    @Override
    public int getItemCount() {
        return crimeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.crime_list_title);
            mDate = itemView.findViewById(R.id.crime_list_date);
        }
    }
}
