package com.niuke.test1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
  
public class Main {
  
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        ArrayList<NetLog> list = new ArrayList<NetLog>();
        while (in.hasNextLine()) {
            String str = in.nextLine();
            if (str == null || str.length() == 0) {
                break;
            }
            String log = str.trim().replaceAll("[' ']+", " ");
            String[] logArr = log.split(" ");
            NetLog netLog = new NetLog();
            netLog.taskName = logArr[0];
            netLog.taskStartTime = logArr[1] + " " + logArr[2];
            netLog.spendTime = logArr[3];
            netLog.sourceString = str;
            list.add(netLog);
        }
        Collections.sort(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i).sourceString);
        }
        in.close();
    }
  
}
  
class NetLog implements Comparable<NetLog> {
    public String taskName;
    public String taskStartTime;
    public String spendTime;
    public String sourceString;
  
    @Override
    public int compareTo(NetLog o) {
        // TODO Auto-generated method stub
        int len1 = this.spendTime.length();
        int len2 = o.spendTime.length();
        if (len1 != len2) {
            return len1 - len2;
        }
        int tmp = this.spendTime.compareTo(o.spendTime);
        if (tmp != 0) {
            return tmp;
        }
        len1 = this.taskStartTime.length();
        len2 = o.taskStartTime.length();
        if (len1 != len2) {
            return len1 - len2;
        }
        return this.taskStartTime.compareTo(o.taskStartTime);
    }
}

