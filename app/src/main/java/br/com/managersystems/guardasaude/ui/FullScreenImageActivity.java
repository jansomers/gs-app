package br.com.managersystems.guardasaude.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import br.com.managersystems.guardasaude.R;
import br.com.managersystems.guardasaude.images.FullScreenImageAdapter;
import br.com.managersystems.guardasaude.images.FullScreenImagePresenter;
import br.com.managersystems.guardasaude.images.ImagesPresenter;
import butterknife.Bind;
import butterknife.ButterKnife;


public class FullScreenImageActivity extends Activity {
    private FullScreenImageAdapter adapter;
    private FullScreenImagePresenter fullScreenImagePresenter;
    private ViewPager viewPager;

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fullscreen_view);

            viewPager = (ViewPager) findViewById(R.id.pager);

            Intent i = getIntent();
            int position = i.getIntExtra("position", 0);

            fullScreenImagePresenter = new FullScreenImagePresenter(this);

            adapter = new FullScreenImageAdapter(FullScreenImageActivity.this,fullScreenImagePresenter.getExamImages());

            viewPager.setAdapter(adapter);

            viewPager.setCurrentItem(position);
        }
}
