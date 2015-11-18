package com.hoczz1.study.photoapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class AlbumAdapter extends BaseAdapter {
    ArrayList<ImageView> list = new ArrayList<ImageView>();
    Context context;
    /*SD카드내의 사진이 있는 경로를 조사하여, ArrayList에 담아서 사진을 출력!*/

    public AlbumAdapter(Context context) {
        this.context = context;
        init();
    }

    public void init(){
        File dir= Environment.getExternalStorageDirectory();
        String path=dir.getAbsolutePath() +"/MyMedia/photo";
        File file = new File(path);
        File[] files=file.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].isFile()){ // 디렉토리가 아니라 파일이라면
                BitmapFactory.Options options=new BitmapFactory.Options();
                options.inSampleSize=16;
                Matrix matrix = new Matrix();
                matrix.postRotate(90);
                Bitmap bitmap = BitmapFactory.decodeFile(files[i].getAbsolutePath(),options);
                Bitmap rotateBitmap = bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
                ImageView imageView = new ImageView(context);
                imageView.setImageBitmap(rotateBitmap);
                list.add(imageView);
            }
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =null;
        view= list.get(position);
        return view;
    }
}
