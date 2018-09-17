package com.joseluis0218.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView name1;
    private TextView name2;
    private  TextView name3;
    private TextView role1;
    private TextView role2;
    private  TextView role3;
    private ImageView avatar1;
    private ImageView avatar2;
    private ImageView avatar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1 = (TextView) findViewById(R.id.user_name1);
        name2 = (TextView) findViewById(R.id.user_name2);
        name3 = (TextView) findViewById(R.id.user_name3);
        role1 = (TextView) findViewById(R.id.user_cargo1);
        role2 = (TextView) findViewById(R.id.user_cargo2);
        role3 = (TextView) findViewById(R.id.user_cargo3);




    }
    String name_user = "";
    String role_user = "";
    ImageView avatar;
    public void datosPersona1(View view){
        name_user = name1.getText().toString();
        role_user = role1.getText().toString();
        Intent intent = new Intent(this,DatosActivity.class);
        intent.putExtra("name_user",name_user);
        intent.putExtra("role_user",role_user);
        startActivity(intent);
    }
    public void datosPersona2(View view){
        name_user = name2.getText().toString();
        role_user = role2.getText().toString();
        Intent intent = new Intent(this,DatosActivity.class);
        intent.putExtra("name_user",name_user);
        intent.putExtra("role_user",role_user);
        startActivity(intent);
    }
    public void datosPersona3(View view){
        name_user = name3.getText().toString();
        role_user = role3.getText().toString();
        Intent intent = new Intent(this,DatosActivity.class);
        intent.putExtra("name_user",name_user);
        intent.putExtra("role_user",role_user);
        startActivity(intent);
    }

}
