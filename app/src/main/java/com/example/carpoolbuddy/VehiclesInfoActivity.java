package com.example.carpoolbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class VehiclesInfoActivity extends AppCompatActivity implements VehicleRecyclerViewAdapter.vehicleListener{
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseFirestore data;
    private VehicleRecyclerViewAdapter adapter;
    private ArrayList<Vehicle> vehicleList;
    RecyclerView vehicleRecycler;
    public static Vehicle vehicleP;

    private ArrayList<String> modelData;
    private ArrayList<String> idData;
    private ArrayList<String> typeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_info);
        vehicleRecycler = findViewById(R.id.VehicleRecycler);
        mAuth = FirebaseAuth.getInstance();
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        data = FirebaseFirestore.getInstance();
        modelData = new ArrayList();
        idData = new ArrayList();
        typeData = new ArrayList();
        vehicleList = new ArrayList<>();

        //set the adapter
        adapter = new VehicleRecyclerViewAdapter(modelData, idData, typeData, this);
        vehicleRecycler.setAdapter(adapter);
        vehicleRecycler.setLayoutManager(new LinearLayoutManager(this));



        getAndPopulateData();
    }

    public void getAndPopulateData() {
        data.collection("Vehicle").whereEqualTo("owner", mUser.getEmail()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot docs : task.getResult().getDocuments()) {
                        Vehicle newVehicle = docs.toObject(Vehicle.class);
                        vehicleList.add(newVehicle);
                    }
                    for(Vehicle vech : vehicleList){
                        String modelD = vech.getModel();
                        modelData.add(modelD);
                        String idD = vech.getVehicleID();
                        idData.add(idD);
                        String typeD = vech.getVehicleType();
                        typeData.add(typeD);
                    }
                    adapter.newData(modelData, idData, typeData);
                    adapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(getApplicationContext(), "You don't have vehicles.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void vehicleOnClick(int p){
        vehicleP = vehicleList.get(p);
        startActivity(new Intent(this, VehicleProfileActivity.class));
    }
}