package com;

 class Mythread extends Thread{
    Mythread(){
        System.out.print(" Mythread");

    }
    public void run(){
        System.out.print(" bar");
    }
    public void run(String s){
        System.out.print(" baz");
    }
}
class TestThreads{
    public static void main(String []args){
String s="abhishek";
        Thread t=new Mythread(){
        };
        t.start();

    }
}
