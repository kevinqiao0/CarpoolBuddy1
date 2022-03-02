package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //go to AddVehicle Activity
    public void goAddVehicle(View v) {
        Intent startActivity = new Intent(this, AddVehicleActivity.class);
        startActivity(startActivity);
    }

    //go to VehicleInfo Activity
    public void goVehicleInfo(View v) {
        Intent startActivity = new Intent(this, VehiclesInfoActivity.class);
        startActivity(startActivity);
    }

    public void signOut(View v) {
        //sign out the account and go back to AuthActivity
        FirebaseAuth.getInstance().signOut();
        Intent startActivity = new Intent(this, AuthActivity.class);
        startActivity(startActivity);
        //send message to user
        Toast messageUser = Toast.makeText(getApplicationContext(), "Successfully signed out with Email!", Toast.LENGTH_LONG);
        messageUser.show();
    }
}