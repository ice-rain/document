/**
*className:BaseActivity
*function:定位当前活动的名字 
*method：替换基类AppcompatActivity继承，输出debug日志。
**/
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName()); //debug输出当前Activity的类名
        ActivityCollector.addActivity(this); //使用ActivityCollector管理活动栈，添加当前活动。
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this); //使用ActivityCollector管理活动栈，移除当前活动。
    }
}
