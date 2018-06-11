package com.anan.web;

/**
 * @author yanghaiyu
 * @date 2018/05/25
 **/
public class ThreadTwo implements Runnable {
	@Override
	public void run() {
		System.out.println("T2");
	}
}
