package com.assignment.endtoendtest.utils;

import net.sf.json.JSONArray;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {
    public static String generateEmail() {
        long time = System.currentTimeMillis();
        String str = String.valueOf(time);
        //String subStr = str.substring(0, 6);
        return "it" + str + "@gmail.com";
    }

    private static int fromHex(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }
        throw new IllegalArgumentException();
    }

    public static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('A' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String integerToHex(final int value) {
        String hexStr = Integer.toHexString(value);

        if (!(hexStr.length() % 2 == 0)) {
            hexStr = padleft(hexStr, hexStr.length() + 1, '0');
        }

        return hexStr.toUpperCase();
    }

    public static String padleft(String s, final int len, final char c) {
        s = s.trim();

        StringBuilder d = new StringBuilder(len);
        int fill = len - s.length();

        while (fill-- > 0) {
            d.append(c);
        }

        return d.append(s).toString();
    }

    public static byte[] doXor(byte[] firstArray, int firstOffset, byte[] secondArray, int secondOffset, int length) {
        byte[] temp = new byte[length];
        for (int i = 0; i < length; i++) {
            temp[i] = (byte) (firstArray[i + firstOffset] ^ secondArray[i + secondOffset]);
        }
        return temp;
    }

    public static String generateUniqueMobileNumber() {
        try {

            long nanoTime = System.nanoTime();
            String time = "015" + String.valueOf(nanoTime).substring(7);
            /*Date date = new Date();
            String time = new java.sql.Timestamp(date.getTime()).toString();
            time = time.replaceAll(" ", "");
            time = time.replaceAll("-", "");
            time = time.replaceAll(":", "");
            time = time.replaceAll("\\.", "");
            time = time.replaceAll("2017", "010");
            System.out.println(time);*/
            return time;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String formatNumber(int num) {
        return String.format("%03d",num);
    }

    public static String formatInterger(int num) {
        return String.format("%04d",num);
    }

    public static String getAsciiFromHex(String data){
        StringBuilder outputData = new StringBuilder("");
        for(int i = 0; i < data.length(); i+=2) {
            String str = data.substring(i, i + 2);
            outputData.append((char) Integer.parseInt(str, 16));
        }

        return outputData.toString();
    }

    public static String generateTransactionId() {
        try {

            long nanoTime = System.nanoTime();
            String time = "101" + String.valueOf(nanoTime).substring(5);
            return time;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String generateUnpredictableNumber() {
        try {
            Random random = new Random();
            int value = random.nextInt();
            String hex = new String();
            hex = Integer.toHexString(value);
            String unpredictableNumber = hex.toUpperCase();

            return unpredictableNumber;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String generateBankAccount() {
        try {

            long nanoTime = System.nanoTime();
            String time = "101" + String.valueOf(nanoTime).substring(7);
            return time;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String generateUnicodeStr(String plainStr) {
        try {
            String unicodeStr = "";
            ArrayList<String> subStringList = new ArrayList<String>();
            boolean loopThrough = true;
            int startIndex = 0;
            String subStr = "";
            while(loopThrough) {
                subStr = plainStr.substring(startIndex, startIndex + 5);
                subStringList.add("\\" + subStr);
                startIndex += 5;

                if(startIndex >= plainStr.length())
                    loopThrough = false;
            }

            for (int i = 0; i < subStringList.size(); i++)
                unicodeStr += subStringList.get(i);

            return unicodeStr;
        }
         catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String convertDecimalToHex(int value) {
        try {
            String hex = "";
            int inputDecimal = value;
            while (inputDecimal != 0)
            {
                if ((inputDecimal % 16) < 10)
                    hex = Integer.toString(inputDecimal % 16) + hex;
                inputDecimal = inputDecimal / 16;
            }

            if (hex.equals(""))
                hex="0";

            return hex;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getCurrentMillisecondTime() {
        long time = System.currentTimeMillis();
        String str = String.valueOf(time);
        return str;
    }

    // Subtract specific days with current time
    public static String getPastMillisecondTime(long days) {
        long time = System.currentTimeMillis() - (1000 * 60 * 60 * 24 * days);
        String str = String.valueOf(time);
        return str;
    }

    public static String getFutureMillisecondTime(long days) {
        long time = System.currentTimeMillis() + (1000 * 60 * 60 * 24 * days);
        String str = String.valueOf(time);
        return str;
    }

    public static String getCurrentDate(String format){
        String result = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            result = dateFormat.format(new Date());
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String getFutureDate(String format, int days){
        String result = null;
        try {
            String currentDate = getCurrentDate(format);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(currentDate));
            calendar.add(Calendar.DATE, days);
            result = sdf.format(calendar.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String getCurrentTime(){
        DateFormat converter = new SimpleDateFormat("HHmmss");
        String currentTime = "";
        Date localTime = new Date();
        try {
            currentTime = converter.format(localTime);
        } catch (Exception e){
            e.printStackTrace();
        }

        return currentTime;
    }

    public static JSONArray listToJsonArr(List list) {
        JSONArray arr = new JSONArray();
        try {
            arr = JSONArray.fromObject(list);
        } catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }
}
