import android.app.Application;
import android.content.Context;

/**
 * Created by je on 16-10-2.
 */

public class GoogleCopyApp extends Application {
    //当系统启动时会构建全局application 对象
    private static GoogleCopyApp mInstance;

    @Override
    public void onCreate() {
        mInstance = this;
        super.onCreate();
    }

    public static Context getContext(){
        return mInstance.getApplicationContext();
    }


}
