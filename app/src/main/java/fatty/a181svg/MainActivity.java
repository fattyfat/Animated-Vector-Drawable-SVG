package fatty.a181svg;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Boolean mFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView );
        Drawable drawable = imageView.getDrawable();
        if(drawable instanceof Animatable){
            ((Animatable) drawable).start();
        }

        ImageButton button2 = (ImageButton)findViewById(R.id.imageButton0);

        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch(v.getId()) {
                    case R.id.imageButton0:
                        if(mFlag){
                            startAnim();
                        }else{
                            closeAnim();
                        }
                        break;
                    default:
                        //Toast.makeText(PropertyTest.this , ""+v.getId() , Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void startAnim(){

        ObjectAnimator animator0 = ObjectAnimator.ofFloat(
                findViewById(R.id.imageButton0),
                "alpha",
                1F,
                0.5F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                findViewById(R.id.imageButton1),
                "translationY",
                200F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                findViewById(R.id.imageButton2),
                "translationX",
                200F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                findViewById(R.id.imageButton3),
                "translationY",
                -200F);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(
                findViewById(R.id.imageButton4),
                "translationX",
                -200F);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(
                animator0,
                animator1,
                animator2,
                animator3,
                animator4);
        set.start();
        mFlag = false;
    }

    private void closeAnim() {

        ObjectAnimator animator0 = ObjectAnimator.ofFloat(
                findViewById(R.id.imageButton0),
                "alpha",
                0.5F,
                1F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                findViewById(R.id.imageButton1),
                "translationY",
                0F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                findViewById(R.id.imageButton2),
                "translationX",
                0F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                findViewById(R.id.imageButton3),
                "translationY",
                0F);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(
                findViewById(R.id.imageButton4),
                "translationX",
                0F);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(
                animator0,
                animator1,
                animator2,
                animator3,
                animator4);
        set.start();

        mFlag = true;
    }

}
