package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddVehicleActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseFirestore fireStoreRef;

    private String owner;
    private boolean open;
    private EditText model;
    private EditText capacity;
    private EditText vehicleID;
    private EditText vehicleType;
    private EditText basePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        mAuth = FirebaseAuth.getInstance();
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        fireStoreRef = FirebaseFirestore.getInstance();

        owner = mUser.getEmail();
        open = true;
        model = (EditText) findViewById(R.id.VehicleModel);
        capacity = (EditText) findViewById(R.id.Capacity);
        vehicleID = (EditText) findViewById(R.id.VehicleID);
        vehicleType = (EditText) findViewById(R.id.VehicleType);
        basePrice = (EditText) findViewById(R.id.BasePrice);
    }

    public void addNewVehicle(View v) {
        System.out.println("Add Vehicle!");
        String modelInput = model.getText().toString();
        int capacityInput = Integer.parseInt(capacity.getText().toString());
        String vehicleIDInput = vehicleID.getText().toString();
        String vehicleTypeInput = vehicleType.getText().toString();
        double basePriceInput = Double.parseDouble(basePrice.getText().toString());

        //add the information of new vehicle into the firebase database
        Vehicle currVehicle = new Vehicle(owner, modelInput, vehicleIDInput, vehicleTypeInput, capacityInput, open, basePriceInput);
        fireStoreRef.collection("Vehicle").document(UUID.randomUUID().toString()).set(currVehicle);
        //message to user
        Toast messageUser = Toast.makeText(getApplicationContext(), "Successfully added vehicle!", Toast.LENGTH_LONG);
        messageUser.show();

        //go to VehicleInfoActivity
        Intent startPage = new Intent(this, MainActivity.class);
        startActivity(startPage);
    }
}