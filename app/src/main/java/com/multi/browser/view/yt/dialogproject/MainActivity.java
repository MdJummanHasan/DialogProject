package com.multi.browser.view.yt.dialogproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button customDialog;
    TextView nameText, emailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.dialogButton);
        customDialog = findViewById(R.id.customDialog);

        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Delete")
                        .setMessage("Do You Really Want to Delete?")
                        .setCancelable(true)
                        .setNegativeButton("CANCEL", ((dialogInterface, i) -> {
                            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                            dialogInterface.dismiss();
                        }))

                        .setPositiveButton("DELETE", (dialogInterface, i) -> {
                            Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                            dialogInterface.dismiss();
                        });

                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(dialogInterface -> {
                    dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                            .setTextColor(getResources().getColor(android.R.color.holo_blue_dark));

                    dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                            .setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                });


                dialog.show();

                //Thanks





            }
        });

        customDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.custom_dialog, null);


                EditText name = view1.findViewById(R.id.nameEt);
                EditText email = view1.findViewById(R.id.emailEt);
                Button yesBtn = view1.findViewById(R.id.yesBtn);
                Button noBtn = view1.findViewById(R.id.noBtn);




                builder.setView(view1);


                AlertDialog dialog = builder.create();
                dialog.setCancelable(true);
                dialog.show();

                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });





            }
        });








    }
}