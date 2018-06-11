package com.anan.web;

/**
 * @author yanghaiyu
 * @date 2018/05/25
 **/
public class ThreadOne implements Runnable {
	@Override
	public void run() {
		System.out.println("执行了T1");
	}
}
