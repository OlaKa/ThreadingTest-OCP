package com.gmail.murmeldjur.adressbok;

import static java.lang.Thread.currentThread;

class MyRunnable extends Thread{


    @Override
    public void run() {
        System.out.println("I am in this MyRunnable thread: " + currentThread().getName());

        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            System.out.println("I got woken up!!");

        }finally {
            System.out.println("I am back!!");

        }
    }
}
