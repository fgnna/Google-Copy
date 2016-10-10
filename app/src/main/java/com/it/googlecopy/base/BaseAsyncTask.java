package com.it.googlecopy.base;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * 异步任务基类，用于处理一些须要重复处理的事情
 * Created by jie on 16-7-4.
 */
public abstract  class  BaseAsyncTask extends AsyncTask
{
    private WeakReference<Context> mContext;
    private WeakReference<NewBaseUiInterface> mNewBaseUiInterface;

    public BaseAsyncTask(Context context,@Nullable NewBaseUiInterface newBaseUiInterface)
    {
        if(null == context)
            throw new NullPointerException();
        mContext = new WeakReference<>(context);
        mNewBaseUiInterface = new WeakReference<>(newBaseUiInterface);
    }

    @Override
    protected void onPreExecute()
    {
        if(null != mNewBaseUiInterface.get())
            mNewBaseUiInterface.get().beforeLoading();
    }

    @Override
    public Object doInBackground(Object[] params)
    {
        try {
            return this.doInBackground();
        }
        catch (NetworkErrorException e)
        {
            e.printStackTrace();
            return e;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e;
        }
    }

    @Override
    protected void onPostExecute(Object o)
    {
        if(null == mContext.get())
            return ;

        if(mContext.get() instanceof BaseActivity && ((BaseActivity)mContext.get()).isDestroyed())
            return;

        if(null != mNewBaseUiInterface.get())
            mNewBaseUiInterface.get().afterLoading();

        if(null == o)
        {
            onNullData();
            return;
        }

        if(o instanceof NetworkErrorException)
        {
            onNetworkError((NetworkErrorException) o);
            return;
        }
        if(o instanceof Exception)
        {
            onError((Exception) o);
            return;
        }

        try{

        onSuccess(o);
        }catch (Exception e)
        {
            e.printStackTrace();
            onNullData();
        }

    }

    protected Context getContext()
    {
        return mContext.get();
    }


    protected abstract Object doInBackground() throws Exception;
    protected void onError(Exception e)
    {
        onNullData();
    }
    protected void onNetworkError(NetworkErrorException e){
        onNullData();
    }
    protected abstract void onNullData();
    protected abstract void onSuccess(Object data);
}
