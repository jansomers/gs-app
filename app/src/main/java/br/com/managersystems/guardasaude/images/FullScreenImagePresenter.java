package br.com.managersystems.guardasaude.images;

import android.app.AlertDialog;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.ui.FullScreenImageActivity;

public class FullScreenImagePresenter implements IFullScreenImagePresenter {
    private FullScreenImageActivity fullScreenImageActivity;

    public FullScreenImagePresenter(FullScreenImageActivity fullScreenImageActivity) {
        this.fullScreenImageActivity = fullScreenImageActivity;
    }

    @Override
    public ArrayList<Bitmap> getFilePaths() {
        final ArrayList<Bitmap> imageItems = new ArrayList<>();
        TypedArray imgs = fullScreenImageActivity.getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(fullScreenImageActivity.getResources(), imgs.getResourceId(i, -1));
            imageItems.add(scaleImage(bitmap));
        }
        return imageItems;
    }

    public Bitmap scaleImage(Bitmap bitmap) {
        int nh = (int) ( bitmap.getHeight() * (512.0 / bitmap.getWidth()) );
        return Bitmap.createScaledBitmap(bitmap, 512, nh, true);
    }

}
