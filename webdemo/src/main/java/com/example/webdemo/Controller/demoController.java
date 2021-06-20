package com.example.webdemo.Controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class demoController {


    @RequestMapping("/")
    public String myfirstcontroller() {
        return "你好";
    }

    @RequestMapping("demo")
    public String returnhtml(){
        return "demo";
    }

    @Test
    public void knowstack(){
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(0);
        stack.push(1);
        int a=stack.elementAt(0);
        System.out.println(a);
        List<Integer> list=new LinkedList<Integer>();
        list.add(1);
        list.add(2);

        System.out.println(list.get(0));
        int b[]={1,2,3,4};
        int[]c= Arrays.copyOf(b,4);
        System.out.println(c[3]);
        b[3]=7;
        System.out.println(c[3]+b[3]);

    }
    public int maxLength(List<String> arr) {
        int []has=new int[26];
        int right=dfs(arr,0,has);
        return right;
    }
    public int dfs(List<String> arr,int ind,int[] has){
        if(ind==arr.size()){
            return 0;
        }

        int []m=Arrays.copyOf(has,26);
        if(isunque(arr.get(ind),has)){
            int right=arr.get(ind).length()+dfs(arr,ind+1,has);
            int left=dfs(arr,ind+1,m);
            return Math.max(right,left);
        }
        return dfs(arr,ind+1,m);

    }
    public boolean isunque(String str,int arr[]){
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]>1){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test1(){
        demoController demo=new demoController();
        List<String> list=new LinkedList<>();
        list.add("cha");
        list.add("r");
        list.add("act");
        list.add("ers");
        //["cha","r","act","ers"]
        int result=demo.maxLength(list);
        System.out.println(result);
    }
}
//restcontroller为controller+responsebody
//todo:了解页面解析方法
