package pablo.example.com.fortnitetracker.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import pablo.example.com.fortnitetracker.DTOs.FinalStats;
import pablo.example.com.fortnitetracker.R;

import java.util.List;

public class ForniteTrackerAdapter extends RecyclerView.Adapter<ForniteTrackerAdapter.FortniteViewHolder> {

    public List<FinalStats> finalStatsList;

    public ForniteTrackerAdapter(List<FinalStats> finalStatsList) {
        this.finalStatsList = finalStatsList;

    }

    @NonNull
    @Override
    public FortniteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.cardlayout, viewGroup, false);
        return new FortniteViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull FortniteViewHolder fortniteViewHolder, int i) {
        final FinalStats fnStats = finalStatsList.get(i);

        putDataInAdapter(fortniteViewHolder,fnStats);
    }

    private  void putDataInAdapter(FortniteViewHolder fortniteViewHolder, FinalStats item){

        fortniteViewHolder.txtLabel.setText(item.getLabel());
        fortniteViewHolder.txtDisplayValue.setText(item.getDisplayValue());
        fortniteViewHolder.txtRank.setText(item.getRank());

    }

    @Override
    public int getItemCount() {
        System.out.println(finalStatsList.size());
        return  finalStatsList.size();

    }

    public class FortniteViewHolder extends RecyclerView.ViewHolder {

        private TextView txtLabel;
        private TextView txtDisplayValue;
        private TextView txtRank;



        public FortniteViewHolder(View itemView) {
            super(itemView);

            txtLabel = itemView.findViewById(R.id.txtLabel);
            txtDisplayValue = itemView.findViewById(R.id.txtValue);
            txtRank = itemView.findViewById(R.id.txtRank);

        }

    }
}


