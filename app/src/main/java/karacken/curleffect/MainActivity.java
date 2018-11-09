package karacken.curleffect;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import karacken.curl.PageCurlAdapter;
import karacken.curl.PageSurfaceView;

/**
 *
 */
public class MainActivity extends Activity {




    private PageSurfaceView pageSurfaceView;
    private int screen_width;
    private int screen_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            pageSurfaceView = new PageSurfaceView(this);

        setContentView(pageSurfaceView);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point(); display.getSize(size);
         screen_width = size.x;  screen_height = size.y;
       String[] res_array = null;
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
            res_array=  new String[]{"portrait/page1.png", "portrait/page2.png", "portrait/page3.png",
                    "portrait/page4.png", "portrait/page5.png", "portrait/page6.png","portrait/page7.png",
                    "portrait/page8.png","portrait/page9.png","portrait/page10",
                    "portrait/page11.jpg", "portrait/page12.png", "portrait/page13.png",
                    "portrait/page14.png", "portrait/page15.png", "portrait/page16.png","portrait/page17.png",
                    "portrait/page18.jpg","portrait/page19.png","portrait/page20.png","portrait/page21","portrait/page22.png", "portrait/page23.png",
                    "portrait/page24.png", "portrait/page25.png", "portrait/page26.png","portrait/page27.png",
                    "portrait/page28.png","portrait/page29.png","portrait/page30","portrait/page31.jpg", "portrait/page32.png", "portrait/page33.png",
                    "portrait/page34.png", "portrait/page35.png", "portrait/page36.png","portrait/page37.png",
                    "portrait/page38.png","portrait/page39.png","portrait/page40","portrait/page41.jpg", "portrait/page42.png", "portrait/page43.png",
                    "portrait/page44.png", "portrait/page45.png", "portrait/page46.png","portrait/page47.png",
                    "page/page48.png","page/page49.png"};
      else //page 49
            res_array=  new String[]{"portrait/page1.png", "portrait/page2.png", "landscape/page3.png",
                    "landscape/page4.png", "landscape/page5.png", "landscape/page6.png","landscape/page7.png",
                    "landscape/page8.png","portrait/page9.png","portrait/page10",
                    "portrait/page11.jpg", "portrait/page12.png", "portrait/page13.png",
                    "portrait/page14.png", "portrait/page15.png", "portrait/page16.png","portrait/page17.png",
                    "portrait/page18.jpg","portrait/page19.png","portrait/page20.png","portrait/page21","portrait/page22.png", "portrait/page23.png",
                    "portrait/page24.png", "portrait/page25.png", "portrait/page26.png","portrait/page27.png",
                    "portrait/page28.png","portrait/page29.png","portrait/page30","portrait/page31.jpg", "portrait/page32.png", "portrait/page33.png",
                    "portrait/page34.png", "portrait/page35.png", "portrait/page36.png","portrait/page37.png",
                    "portrait/page38.png","portrait/page39.png","portrait/page40","portrait/page41.jpg", "portrait/page42.png", "portrait/page43.png",
                    "portrait/page44.png", "portrait/page45.png", "portrait/page46.png","portrait/page47.png",
                    "page/page48.png","page/page49.png"};

        PageCurlAdapter pageCurlAdapter=new PageCurlAdapter(res_array);
        pageSurfaceView.setPageCurlAdapter(pageCurlAdapter);


    }


    @Override
    protected void onResume() {
        super.onResume();
        pageSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pageSurfaceView.onPause();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return pageSurfaceView.onPageTouchEvent(event);
    }
}
