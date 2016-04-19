package br.com.managersystems.guardasaude.images;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import br.com.managersystems.guardasaude.ui.FullScreenImageActivity;

public class GridViewImageAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Bitmap> filePaths = new ArrayList<Bitmap>();
    private int imageWidth;

    public GridViewImageAdapter(Activity activity, ArrayList<Bitmap> filePaths,
                                int imageWidth) {
        this.activity = activity;
        this.filePaths = filePaths;
        this.imageWidth = imageWidth;
    }

    @Override
    public int getCount() {
        return this.filePaths.size();
    }

    @Override
    public Object getItem(int position) {
        return this.filePaths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(activity);
        } else {
            imageView = (ImageView) convertView;
        }

        Bitmap bitmap = filePaths.get(position);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(imageWidth,
                imageWidth));
        imageView.setImageBitmap(bitmap);

        imageView.setOnClickListener(new OnImageClickListener(position));

        return imageView;
    }

    class OnImageClickListener implements View.OnClickListener {

        int _postion;

        // constructor
        public OnImageClickListener(int position) {
            this._postion = position;
        }

        @Override
        public void onClick(View v) {
            // on selecting grid view image
            // launch full screen activity
            Intent i = new Intent(activity, FullScreenImageActivity.class);
            i.putExtra("position", _postion);
            activity.startActivity(i);
        }

    }


}
