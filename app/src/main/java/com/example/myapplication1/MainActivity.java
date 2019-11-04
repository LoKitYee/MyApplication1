package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = (Button) findViewById(R.id.buttonLogin);
        final EditText email = (EditText) findViewById(R.id.enterEmail);
        final EditText password = (EditText)findViewById(R.id.enterPassword);
        Retrofit retrofit;

        btnLogin.setOnClickListener(new View.OnClickListener(){

              @Override
              public void onClick(View v) {
                  Call<Login> call = com.example.myapplication1.Retrofit.getInstance().getAPI().login(email.getText().toString(),password.getText().toString());
                   call.enqueue(new Callback<Login>(){

                       @Override
                       public void onResponse(Call<Login> call, Response<Login> response) {
                           try{
                               Login login = response.body();
                               Log.d("TAG","token: "+ login.getToken()+"message: "+login.getStatus().getMessage());
                               Status status = login.getStatus();
                               int code = status.getCode();

                           if(code==200){
                               SharedPreference.getInstance(MainActivity.this).user(login.getId(), login.getToken());

                               Intent Intent = new Intent(MainActivity.this, ListingActivity.class);
                               startActivity(Intent);
                           } else {
                               Toast.makeText(MainActivity.this, "" + login.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
                           }
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                       }

                       @Override
                       public void onFailure(Call<Login> call, Throwable t) {
                            Log.d("TAG", "Invalid email or password");
                            t.printStackTrace();
                       }
                   });
              }
        });

    }

}