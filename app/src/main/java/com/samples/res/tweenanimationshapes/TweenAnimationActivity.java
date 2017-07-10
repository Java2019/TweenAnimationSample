package com.samples.res.tweenanimationshapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TweenAnimationActivity extends AppCompatActivity
        implements Animation.AnimationListener{

    private ImageView imageView;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        imageView = (ImageView)findViewById(R.id.image);
        imageView.setImageResource(R.drawable.shape);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(Menu.NONE, R.anim.alpha, Menu.NONE, "Alpha")
                .setAlphabeticShortcut('a');
        menu.add(Menu.NONE, R.anim.rotate, Menu.NONE, "Rotate")
                .setAlphabeticShortcut('r');
        menu.add(Menu.NONE, R.anim.scale, Menu.NONE, "Scale")
                .setAlphabeticShortcut('s');
        menu.add(Menu.NONE, R.anim.translate, Menu.NONE, "Translate")
                .setAlphabeticShortcut('t');
        menu.add(Menu.NONE, R.anim.total, Menu.NONE, "Total")
                .setAlphabeticShortcut('o');

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Загружаем анимацию из выбранного XML-файла
        animation = AnimationUtils.loadAnimation(this, item.getItemId());
        imageView.startAnimation(animation);
        return true;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        imageView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        imageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        imageView.setVisibility(View.VISIBLE);
    }
}
