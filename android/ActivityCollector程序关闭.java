/**
*className：ActivityCollector
*function：管理活动栈，随时结束程序
*method：ActivityCollector.add()/.remove()/.finish()
**/
import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

   public static List<Activity> activities = new ArrayList<>(); //使用List管理活动栈

   public static void addActivity(Activity activity){ //入栈
       activities.add(activity);
   }

   public static void removeActivity(Activity activity){ //出站
       activities.remove(activity);
   }

   public static void finishAll(){ //结束程序
       for (Activity activity : activities){
           if (!activity.isFinishing()){
               activity.finish();
           }
       }
       activities.clear(); //清空栈
       // android.os.Process.killProcess (android.os.Process.myPid()); //未添加jar包，结束当前进程
   }
}
