package com.hoczz1.study.photoapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class AlbumActivity extends Activity implements AdapterView.OnItemClickListener{
    AlbumAdapter albumAdapter;
    GridView gridView;
    String tag;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_layout);
        tag = this.getClass().getName();
        gridView = (GridView) findViewById(R.id.gridView);
        albumAdapter = new AlbumAdapter(this); // context가 오길 기다리니까 this를 넣는다.
        gridView.setAdapter(albumAdapter); /* 연결!! */
    }
    public void btnClick(View view){
        finish();
    }

    //parent는 GridView !
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(tag,position+"나 눌렀어?");
        Intent intent = new Intent(this,DetailActivity.class);
        /*앨범에서 선택한 ImageView를 전달해보자!!
        * 주의) Intent가 대부분 기본자료형에 대한 전달만 지원기때문에
        * Bundle이 지원하는 putExtraParcelable~~~~
        * parcelable란 메서드가 있다!!*/
        ImageView imageView=(ImageView)view;
        imageView.setDrawingCacheEnabled(true);
        Bitmap imgBitmap=imageView.getDrawingCache();
        Bundle bundle = new Bundle();
        bundle.putParcelable("img",imgBitmap);
        intent.putExtra("bundle",bundle);
    }
}
