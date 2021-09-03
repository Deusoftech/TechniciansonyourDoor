package com.example.techniciansonyourdoor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Language extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        Button button=findViewById(R.id.change_lang);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });

    }


    private void showChangeLanguageDialog(){
        final String[] listitems={"English","French"};
        AlertDialog.Builder builder=new AlertDialog.Builder(Language.this);
        builder.setTitle("Choose Language");
        builder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0) {
                    setLocate("eng");
                    recreate();
                }
                else if(which==1){
                    setLocate("fr");
                    recreate();
                }
                dialog.dismiss();
            }

            private void setLocate(String fr) {
                Locale locale=new Locale(fr);
                Locale.setDefault(locale);
                Configuration config =new Configuration();
                config.locale=locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                SharedPreferences.Editor editor= getSharedPreferences("settings", MODE_PRIVATE).edit();
                editor.putString("My_Lang", fr);
                editor.apply();
            }
            public void loadLocale(){
                SharedPreferences prefs=getSharedPreferences("settings", Activity.MODE_PRIVATE);
                String language =prefs.getString("My_Lang","");
                setLocate(language);
            }

        });
        AlertDialog mDialog=builder.create();
        mDialog.show();
    }

}
