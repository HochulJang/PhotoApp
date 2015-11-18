package com.hoczz1.study.photoapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
public class DetailActivity extends Activity{
    String tag;
    ImageView imageView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        tag = this.getClass().getName();
        /*DetailActivity로 넘어온 데이터를 받기 위함..*/
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");

        Bitmap bitmap=bundle.getParcelable("img");
        Log.d(tag,"bitmap is" + bitmap);
        imageView = (ImageView)findViewById(R.id.image);
        imageView.setImageBitmap(bitmap);
    }
}
