package com.anan.web;

import com.anan.web.domain.User;

/**
 * @author yanghaiyu
 * @date 2018/05/25
 **/
public class ThreadConsumerAndProduction {
	public static void main(String[] args) {
		User user = new User();
		new Thread(new Production(user)).start();
		new Thread(new Consumer(user)).start();
	}
}
