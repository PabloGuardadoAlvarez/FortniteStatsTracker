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

    public List<FinalStats> dataList;

    public ForniteTrackerAdapter(List<FinalStats> dataList) {
        this.dataList = dataList;

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
        final FinalStats fnStats = dataList.get(i);

        putDataInAdapter(fortniteViewHolder,fnStats);
    }

    private  void putDataInAdapter(FortniteViewHolder fortniteViewHolder, FinalStats item){

        fortniteViewHolder.txtLabel.setText(item.getLabel());
        fortniteViewHolder.txtDisplayValue.setText(item.getDisplayValue());
        fortniteViewHolder.txtRank.setText(item.getRank());

    }

    @Override
    public int getItemCount() {
        System.out.println(dataList.size());
        return  dataList.size();

    }

    public class FortniteViewHolder extends RecyclerView.ViewHolder {

        private TextView txtLabel, txtRank, txtDisplayValue;

        public FortniteViewHolder(View itemView) {
            super(itemView);

            txtLabel = itemView.findViewById(R.id.tv_label);
            txtRank = itemView.findViewById(R.id.tv_rank);
            txtDisplayValue = itemView.findViewById(R.id.tv_displayValue);
        }

    }
}


