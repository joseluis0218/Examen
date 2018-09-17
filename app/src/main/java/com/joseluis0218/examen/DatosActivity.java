package com.joseluis0218.examen;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {
    private TextView names;
    private TextView email;
    private TextView role;
    private TextView website;
    private TextView number;
    private ImageView avatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        names = (TextView) findViewById(R.id.names);
        role = (TextView) findViewById(R.id.role);
        email = (TextView) findViewById(R.id.email);
        website = (TextView) findViewById(R.id.website);
        number = (TextView) findViewById(R.id.number);
        avatar = (ImageView) findViewById(R.id.avatar);

        String name_user = "";
        String role_user = "";
        if (this.getIntent().getExtras() != null) {


            if (this.getIntent().getExtras().getString("name_user").equalsIgnoreCase("Linus Torvalds")) {
                name_user = this.getIntent().getExtras().getString("name_user");
                names.setText(name_user);

                role_user = this.getIntent().getExtras().getString("role_user");
                role.setText(role_user);

                number.setText("(123) 187-2364");
                email.setText("linus.pe@gmail.com");
                website.setText("www.linux.org");
                avatar.setImageResource(R.drawable.img_persona1);

            } else if (this.getIntent().getExtras().getString("name_user").equalsIgnoreCase("Steve Jobs")) {
                name_user = this.getIntent().getExtras().getString("name_user");
                names.setText(name_user);

                role_user = this.getIntent().getExtras().getString("role_user");
                role.setText(role_user);

                number.setText("(159) 123-7844");
                email.setText("steve.pe@gmail.com");
                website.setText("www.apple.com");
                avatar.setImageResource(R.drawable.img_persona2);

            } else {
                name_user = this.getIntent().getExtras().getString("name_user");
                names.setText(name_user);

                role_user = this.getIntent().getExtras().getString("role_user");
                role.setText(role_user);

                number.setText("(331) 121-3147");
                email.setText("billg.pe@gmail.com");
                website.setText("www.microsoft.com");
                avatar.setImageResource(R.drawable.img_persona3);

            }
        }
    }
    public void emailImplicit(View view){
        String name_email = email.getText().toString();
        String user_name = names.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new  String[]{name_email});
        intent.putExtra(Intent.EXTRA_SUBJECT,"TRABAJO");
        intent.putExtra(Intent.EXTRA_TEXT,"Hola "+user_name);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    public void hangoutsImplicit(View view) {
        String number_phone = number.getText().toString();
        String user_name = names.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new  String[]{number_phone});
        intent.putExtra(Intent.EXTRA_TEXT,"Hola "+user_name);
        intent.setPackage("com.google.android.talk");
        startActivity(intent);
    }

    public void callImplicit(View view) {
        String number_phone = number.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+number_phone));

        if (ActivityCompat.checkSelfPermission(DatosActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            return;
            startActivity(intent);
/*        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+number_phone));
        startActivity(intent);*/


    }

    public void webImplicit(View view){
        String user_web = website.getText().toString();
        Uri webpage = Uri.parse("http://"+user_web);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}

