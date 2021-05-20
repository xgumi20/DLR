package com.example.driverslicenseregistration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    Button bsimg;
    ImageView dsimg;
    int SELECT_IMAGE = 200;

    Uri imageeUri;

    String lnameget;
    String fnameget;
    String mnameget;
    String enameget;
    String birthdayget;
    String housenoget;
    String housestreetget;
    String housebzget;
    String housetcget;
    String houseprovinceget;
    String genderget;
    String nationalityget;
    String heightget;
    String weightget;
    String bloodget;
    String eyecolorget;

    String fullname;
    String fulladdress;
    String sexs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        EditText lnamein = findViewById(R.id.lastname);
        EditText fnamein = findViewById(R.id.firstname);
        EditText mnamein = findViewById(R.id.middlename);
        EditText enamein = findViewById(R.id.extensionname);
        EditText birthdayin = findViewById(R.id.birthday);
        EditText weightin = findViewById(R.id.weight);
        EditText heightin = findViewById(R.id.height);
        EditText housenoin = findViewById(R.id.houseno);
        EditText housestreetin = findViewById(R.id.housestreet);
        EditText housebzin = findViewById(R.id.housebz);
        EditText housetcin = findViewById(R.id.housetc);
        EditText houseprovincein = findViewById(R.id.houseprovince);


        Spinner genderselect = findViewById(R.id.gender);
        ArrayAdapter<CharSequence> genderadapter = ArrayAdapter.createFromResource(this, R.array.genders, android.R.layout.simple_spinner_dropdown_item);
        genderselect.setAdapter(genderadapter);
        Spinner nationalityselect = findViewById(R.id.nationalities);
        ArrayAdapter<CharSequence> nationalityadapter = ArrayAdapter.createFromResource(this, R.array.nationalities, android.R.layout.simple_spinner_dropdown_item);
        nationalityselect.setAdapter(nationalityadapter);
        Spinner bloodselect = findViewById(R.id.bloodtype);
        ArrayAdapter<CharSequence> bloodadapter = ArrayAdapter.createFromResource(this, R.array.bloodtype, android.R.layout.simple_spinner_dropdown_item);
        bloodselect.setAdapter(bloodadapter);
        Spinner eyecolorselect = findViewById(R.id.eyecolor);
        ArrayAdapter<CharSequence> eyecoloradapter = ArrayAdapter.createFromResource(this, R.array.coloredeye, android.R.layout.simple_spinner_dropdown_item);
        eyecolorselect.setAdapter(eyecoloradapter);




        bsimg = findViewById(R.id.upload);
        dsimg = findViewById(R.id.uploaded_img);

        bsimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgSelector();
            }
        });

        AlertDialog.Builder alrt = new AlertDialog.Builder(this);
        alrt.setTitle("Submit Registration");
        alrt.setMessage("You can check a preview and double check you information in the data you've given");
        alrt.setPositiveButton("Check preview (recommended)", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, Preview.class);
                intent.putExtra("rimg", imageeUri.toString());
                intent.putExtra("fname", fullname);
                intent.putExtra("ntlity", nationalityget);
                intent.putExtra("sexx", sexs);
                intent.putExtra("bods", birthdayget);
                intent.putExtra("wghtt", weightget);
                intent.putExtra("hghtt", heightget);
                intent.putExtra("addss", fulladdress);
                intent.putExtra("blds", bloodget);
                intent.putExtra("eycs", eyecolorget);
                startActivity(intent);
                finish();
            }
        });
        alrt.setNegativeButton("Submit without Checking", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Activity not yet available...", Toast.LENGTH_LONG).show();
            }
        });
        alrt.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lnameget = lnamein.getText().toString().toUpperCase();
                fnameget = fnamein.getText().toString().toUpperCase();
                mnameget = mnamein.getText().toString().toUpperCase();
                enameget = enamein.getText().toString().toUpperCase();
                birthdayget = birthdayin.getText().toString().toUpperCase();
                housenoget = housenoin.getText().toString().toUpperCase();
                housestreetget = housestreetin.getText().toString().toUpperCase();
                housebzget = housebzin.getText().toString().toUpperCase();
                housetcget = housetcin.getText().toString().toUpperCase();
                houseprovinceget = houseprovincein.getText().toString().toUpperCase();
                genderget = genderselect.getSelectedItem().toString().toUpperCase();
                nationalityget = nationalityselect.getSelectedItem().toString().toUpperCase();
                heightget = heightin.getText().toString().toUpperCase();
                weightget = weightin.getText().toString().toUpperCase();
                bloodget = bloodselect.getSelectedItem().toString().toUpperCase();
                eyecolorget = eyecolorselect.getSelectedItem().toString().toUpperCase();



                if (lnameget.equals("") || fnameget.equals("") || mnameget.equals("") || birthdayget.equals("") || dsimg.getDrawable()==null ||
                housenoget.equals("") || housebzget.equals("") || houseprovinceget.equals("") || housestreetget.equals("") || housetcget.equals("") ||
                genderget.equals("") || nationalityget.equals("") || heightget.equals("") || weightget.equals("") || bloodget.equals("") || eyecolorget.equals("")){
                    Toast.makeText(MainActivity.this, "Please fill all data...", Toast.LENGTH_LONG).show();
                }else {
                    fullname = lnameget + ", " + fnameget + " " + mnameget + " " + enameget;
                    fulladdress = housenoget+ " " + housestreetget + " " + housebzget + " " + housetcget + " " + houseprovinceget;
                    if (genderget.equals("MALE")){
                        sexs = "M";
                    }else{
                        sexs = "F";
                    }

                    alrt.show();
                }

            }
        });
    }

    void imgSelector(){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Image"), SELECT_IMAGE);

        
    }

    public void onActivityResult(int requestC, int resultC, Intent data){
        super.onActivityResult(requestC, resultC, data);

        if(resultC == RESULT_OK){
            if (requestC == SELECT_IMAGE){
                Uri selectedImgUri = data.getData();
                if (null != selectedImgUri){


                    imageeUri = data.getData();
                    dsimg.setImageURI(selectedImgUri);

                }
            }
        }
    }
}