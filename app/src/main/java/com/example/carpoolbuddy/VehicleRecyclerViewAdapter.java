package com.example.carpoolbuddy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VehicleRecyclerViewAdapter extends RecyclerView.Adapter<VehicleHolder> {
    ArrayList<String> mData;
    ArrayList<String> iData;
    ArrayList<String> tData;
    private vehicleListener listener;

    public VehicleRecyclerViewAdapter(ArrayList modelData, ArrayList idData, ArrayList typeData, vehicleListener listener2) {
        mData = modelData;
        iData = idData;
        tData = typeData;
        listener = listener2;
    }

    @NonNull
    @Override
    public VehicleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);
        VehicleHolder holder = new VehicleHolder(myView, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleHolder holder, int position) {
        holder.modelText.setText(mData.get(position));
        holder.idText.setText(iData.get(position));
        holder.typeText.setText(tData.get(position));
    }

    public void newData(ArrayList modelData, ArrayList idData, ArrayList typeData) {
        mData = modelData;
        iData = idData;
        tData = typeData;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface vehicleListener{
        void vehicleOnClick(int p);
    }
}
