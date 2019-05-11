package com.example.android.materialme;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    private TextView fTitleText;
    private ImageView fDetailsImage;

    //Constant used to specify the type of transistion been used
    public static final String TRANSITION_TYPE = "Transition Type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        if(intent.hasExtra(TRANSITION_TYPE)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setEnterTransition(new Fade());
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Fade());
        }

        String title = intent.getStringExtra("SPORT_NAME");
        int imageResource = intent.getIntExtra("SPORT_IMAGE",0);

        fTitleText = findViewById(R.id.details_title);
        fDetailsImage = findViewById(R.id.details_image);

        fTitleText.setText(title);
        Glide.with(this).load(imageResource).into(fDetailsImage);

    }
}
