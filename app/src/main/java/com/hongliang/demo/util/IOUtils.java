package com.hongliang.demo.util;

import com.hongliang.demo.bean.Text;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static com.hongliang.demo.util.FileUtils.closeIO;
import static com.hongliang.demo.util.FileUtils.createOrExistsFile;

public class IOUtils {


    /**
     * 只能单例写一次，一直覆盖
     *
     * @param fileUrl
     * @param data
     */
    public static void onOutputStream(String fileUrl, String data) {

        if (createOrExistsFile(fileUrl)) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileUrl));
                objectOutputStream.writeObject(data);
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }
    }


    /**
     * 读取文件
     *
     * @param fileUrl
     * @return
     */
    public static String onInputStream(String fileUrl) {


        String data = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileUrl));
            data = inputStream.readObject().toString();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }


    /**
     * 写文件 可以追加数据到本地
     *
     * @param fileUrl
     * @param data
     */
    public static void onOutputStream2(String fileUrl, String data) {
        onOutputStream2(fileUrl,data,true);

    }

    public static void onOutputStream2(String fileUrl, String data ,boolean append) {

        Writer writer = null;

        StringBuffer buf = new StringBuffer();

        buf.append(data);

        String str = new String(buf);

        char[] ch = new char[]{'a', 'b', 'c'};

        try {
            writer = new FileWriter(fileUrl, append);
            writer.write(str);    //将字符串写入到文件中
            //    writer.write(ch);    //直接将字符数组写入
            writer.close();        //关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 读取文件
     *
     * @param fileUrl
     * @return
     */
    public static String onInputStream2(String fileUrl) {
        File file = new File(fileUrl);
        Reader r = null;
        char[] ch = new char[(int) file.length()];
        int temp, i = 0;
        try {
            r = new FileReader(file);
            while ((temp = r.read()) != -1) {//每次只能读取一个字符，通过循环的方式放入到字符数组中
                ch[i++] = (char) temp;
            }
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(ch, 0, i);
    }


    /**
     * 读取json文件
     *
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static JSONArray TextList2Json(List<Text> list) {
        JSONArray json = new JSONArray();
        for (Text pLog : list) {
            JSONObject jo = new JSONObject();
            try {
                jo.put("id", pLog.getA());
                jo.put("time", pLog.getB());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            json.put(jo);
        }
        return json;
    }


    public static List<Text> TextList2Json(String list) {
        List<Text> list1 = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(list);
            if (jsonArray.length() > 0) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Text text = new Text(jsonObject.getInt("id"), jsonObject.getInt("time"));
                    list1.add(text);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list1;
    }



    /**
     * 将输入流写入文件
     *
     * @param file   文件
     * @param is     输入流
     * @param append 是否追加在文件末
     * @return {@code true}: 写入成功<br>{@code false}: 写入失败
     */
    public static boolean writeFileFromIS(File file, InputStream is, boolean append) {
        if (file == null || is == null) return false;
        if (!createOrExistsFile(file)) return false;
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file, append));
            byte data[] = new byte[100];
            int len;
            while ((len = is.read(data, 0, 100)) != -1) {
                os.write(data, 0, len);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeIO(is, os);
        }
    }

}
