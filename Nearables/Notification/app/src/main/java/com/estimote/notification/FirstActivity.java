package com.estimote.notification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FirstActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        if(item.getItemId() == R.id.lostAndFoundMenu){
            intent = new Intent(FirstActivity.this,LostAndFoundActivity.class);
            startActivity(intent);
        }
       /* else if(item.getItemId() == R.id.trackerMenu){
            intent = new Intent(FirstActivity.this,MainActivity.class);
            startActivity(intent);
        } */
        else if(item.getItemId() == R.id.logoutMenu){
            LoginActivity.mAuth = FirebaseAuth.getInstance();
            LoginActivity.mAuth.signOut();
            Toast.makeText(FirstActivity.this,"Signed out successfuly",Toast.LENGTH_LONG).show();
            intent = new Intent(FirstActivity.this,LoginActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setTitle("Nearables");


    }
}
