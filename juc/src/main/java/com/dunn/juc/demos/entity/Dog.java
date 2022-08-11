package com.dunn.juc.demos.entity;

/**
 * @description:
 * @author: Dunn
 * @create: 2022-08-02 16:52
 */
public class Dog {

    public static synchronized void sSyn1(){
        System.out.println("sSyn1----------");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wake up");
    }

    public static synchronized void sSyn2(){
        System.out.println("sSyn2-------");
    }

    public synchronized void syn(){
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("syn1---------");
    }
    public synchronized void syn2(){
        System.out.println("syn2---------");
    }

    public void demo(){
        System.out.println("demo---------");
    }



}
