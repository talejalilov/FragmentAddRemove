package com.example.fragmentaddandremove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   FragmentManager manager;
    Button addFragmentA,removeA,addFragmentB,removeB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        addFragmentA = findViewById(R.id.button);
        removeA = findViewById(R.id.button2);
        addFragmentB = findViewById(R.id.button3);
        removeB = findViewById(R.id.button4);

        addFragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentA fragmentA = new FragmentA();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.frameLayout,fragmentA,"Fragment A");
                transaction.commit();

            }
        });


        addFragmentB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentB fragmentB = new FragmentB();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.frameLayout,fragmentB,"Fragment B");
                transaction.commit();

            }
        });

        removeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("Fragment A");
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                if(fragmentTransaction != null){
                    fragmentTransaction.remove(fragmentA);
                    fragmentTransaction.commit();
                }else {

                    Toast.makeText(MainActivity.this,"Not Found",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}