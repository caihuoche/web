package com.anan.web;

import java.util.Random;

import com.anan.web.domain.User;

/**
 * @author yanghaiyu
 * @date 2018/05/25
 **/
public class Production implements Runnable {

	private User user;
	private Random random =new Random();

	public Production() {
	}


	public Production(User user) {
		this.user = user;
	}

	@Override
	public void run() {
		while (true){
			synchronized (user){
				System.out.println("生产一个消息");
				user.setName(""+random.nextInt());
				try {
					user.notify();
					user.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
