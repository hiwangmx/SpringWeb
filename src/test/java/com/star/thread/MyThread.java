package com.star.thread;

public class MyThread extends Thread{

	@Override
	public void run() {
		super.run();
		System.out.println(Thread.currentThread().getName() + "正在执行");
	}
	
}
