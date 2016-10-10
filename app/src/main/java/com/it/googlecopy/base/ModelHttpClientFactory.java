package com.it.googlecopy.base;

import android.accounts.NetworkErrorException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author jie
 *
 */
public class ModelHttpClientFactory
{
    public static final String LOG_TAG = "ModelHttpClientFactory";

    public static final String CONTENT_TYPE_STREAM = "application/octet-stream";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_URLENCODED = "application/x-www-form-urlencoded";

	public static  Gson sGson = new Gson();
	public static String  getStringByURL_GET(String urlApi) throws NetworkErrorException {
        HttpURLConnection httpConn = null;
        OutputStream outputStream = null;
        try
        {
            //建立连接
            URL url = new URL(urlApi);
            httpConn = (HttpURLConnection) url.openConnection();

            ////设置连接属性
            httpConn.setDoInput(true);//使用 URL 连接进行输入
            httpConn.setUseCaches(true);//忽略缓存
            httpConn.setRequestMethod("GET");//设置URL请求方法
            httpConn.setConnectTimeout(20000);
            httpConn.setReadTimeout(20000);

            //获得响应状态
            int responseCode = httpConn.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode || HttpURLConnection.HTTP_NOT_MODIFIED == responseCode)
            {
                //连接成功
                //当正确响应时处理数据
                StringBuffer sb = new StringBuffer();
                String readLine;
                BufferedReader responseReader;
                //处理响应流，必须与服务器响应流输出的编码一致
                responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null)
                {
                    sb.append(readLine);
                }
                responseReader.close();
                return sb.toString();
            }
        } catch (Exception ex)
        {
            ex.printStackTrace();
            throw new NetworkErrorException();
        } finally
        {
            if (null != outputStream) {
                try {
                    outputStream.flush();
                } catch (Exception e) {
                }
                try {
                    outputStream.close();
                } catch (Exception e) {
                }
            }
        }
        return null;
	}
	
	public static  <T> T getJsonObjectForTypeToken(String url,Type type) throws NetworkErrorException {
        try {
            return sGson.fromJson(getStringByURL_GET(url), type);

        } catch (NetworkErrorException e) {
            throw e;
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw new NetworkErrorException(e);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String postHttpForStringAsJSON(String urlapi,String params) throws NetworkErrorException
    {
        return postHttpForString(urlapi,params,CONTENT_TYPE_JSON);
    }
    public static String postHttpForStringAsJSON(String urlapi,Object params) throws NetworkErrorException
    {
        return postHttpForStringAsJSON(urlapi,sGson.toJson(params));
    }
    public static <T> T postHttpForStringAsJSON(String urlapi,Object params,Type type) throws NetworkErrorException
    {
        return new Gson().fromJson(postHttpForStringAsJSON(urlapi,params),type);
    }

    public static String postHttpForStringAsUrlencoded(String urlapi,String params) throws NetworkErrorException
    {
        return postHttpForString(urlapi,params,CONTENT_TYPE_URLENCODED);
    }

    /**
     * 后台不再支持,不要再使用
     * @param urlapi
     * @param params
     * @return
     * @throws NetworkErrorException
     */
    @Deprecated
    public static String postHttpForString(String urlapi,String params) throws NetworkErrorException
    {
        return postHttpForString(urlapi,params,null);
    }
    @Deprecated
    public static String postHttpForString(String urlapi,String params,String contentType) throws NetworkErrorException
    {
        return sumbitHttpForString(urlapi, params, contentType, null);
    }
    @Deprecated
    public static String putHttpForString(String urlapi,String params) throws NetworkErrorException
    {
        return sumbitHttpForString(urlapi,params,CONTENT_TYPE_JSON,"PUT");
    }


    public static String sumbitHttpForString(String urlapi,String params,String contentType,String requestType) throws NetworkErrorException
    {
        HttpURLConnection httpConn = null;
        OutputStream outputStream = null;
        try
        {
            //建立连接
            URL url = new URL(urlapi);
            httpConn = (HttpURLConnection) url.openConnection();

            ////设置连接属性
            httpConn.setDoOutput(true);//使用 URL 连接进行输出
            httpConn.setDoInput(true);//使用 URL 连接进行输入
            httpConn.setUseCaches(false);//忽略缓存
            httpConn.setRequestMethod(ValidateUtil.isEmpty(requestType)?"POST":requestType);//设置URL请求方法
            httpConn.setConnectTimeout(20000);
            httpConn.setReadTimeout(20000);
            String requestString = params;

            //设置请求属性
            //获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
            byte[] requestStringBytes = requestString.getBytes("UTF-8");
            httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length);
            if(null == contentType)
                httpConn.setRequestProperty("Content-Type",CONTENT_TYPE_STREAM);
            else
                httpConn.setRequestProperty("Content-Type",contentType);

            httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
            httpConn.setRequestProperty("Charset", "UTF-8");

            //建立输出流，并写入数据
            outputStream = httpConn.getOutputStream();
            outputStream.write(requestStringBytes);
            outputStream.close();
            //获得响应状态
            int responseCode = httpConn.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode)
            {
                //连接成功
                //当正确响应时处理数据
                StringBuffer sb = new StringBuffer();
                String readLine;
                BufferedReader responseReader;
                //处理响应流，必须与服务器响应流输出的编码一致
                responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null)
                {
                    sb.append(readLine).append("\n");
                }
                responseReader.close();


                return sb.toString();
            }
        } catch (Exception ex)
        {
            ex.printStackTrace();
            throw new NetworkErrorException();
        } finally
        {
            if (null != outputStream) {
                try {
                    outputStream.flush();
                } catch (Exception e) {
                }
                try {
                    outputStream.close();
                } catch (Exception e) {
                }
            }
        }
        return null;
    }



}
