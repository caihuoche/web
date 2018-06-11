package com.anan.web;

/**
 * @author yanghaiyu
 * @date 2018/06/10
 **/
public class VoliTest implements Runnable{
	private  boolean flag = false;
	public void stop(){
		flag =true;
		System.out.println("heh");
	}
	@Override
	public void run() {
		int i = 0;
		while (!flag){

			System.out.println(		Thread.currentThread().getName()
					+ "    "+i++);
		}
		System.out.println(		Thread.currentThread().getName()
				+ "stop");
	}
}
