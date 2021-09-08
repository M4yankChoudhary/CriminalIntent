package me.mayankchoudhary.criminalintent.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import me.mayankchoudhary.criminalintent.Crime;
import me.mayankchoudhary.criminalintent.CrimeActivity;
import me.mayankchoudhary.criminalintent.R;

public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.ViewHolder> {

    private Context applicationContext;
    private List<Crime> crimeList;
    public static final String EXTRA_CRIME =
            "me.mayankchoudhary.criminalintent.crime_id";


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
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM d, ''yy, h:mm a");
        String strDate= formatter.format(crimeList.get(position).getDate());
        holder.mDate.setText(strDate);
        holder.constraintLayout.setOnClickListener( v -> {
                Intent intent = new Intent(applicationContext, CrimeActivity.class);
                intent.putExtra(EXTRA_CRIME, crimeList.get(position));
                applicationContext.startActivity(intent);
        });
        holder.mImage.setVisibility(
                crimeList.get(position).isSolved() ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return crimeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDate;
        private ImageView mImage;
        private ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.crime_list_title);
            mDate = itemView.findViewById(R.id.crime_list_date);
            mImage = itemView.findViewById(R.id.crimeImage);
            constraintLayout = itemView.findViewById(R.id.crime_list_container);
        }
    }
}
