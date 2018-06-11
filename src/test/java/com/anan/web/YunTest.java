package com.anan.web;

import java.util.Vector;
import java.util.concurrent.ExecutorService;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2018/06/07
 **/
public class YunTest {

	@Test
	public void t1() {
		int i = 1;
		System.out.println(i++);
		System.out.println(i);
		i += 1;
		System.out.println(i);
	}

	@Test
	public void t2() {
		boolean flag = true;
		flag &= false;
		System.out.println(flag);
		flag |= true;
		System.out.println(flag);
		flag ^= true;
		System.out.println(flag);
		int a = 4 ^ 4;
		int b = 4 ^ 8;
		System.out.println(a);
		System.out.println(b);
	}


	@Test
	public void t3() {
		MySingleton instance = MySingleton.INSTANCE;
		System.out.println(instance);
		ExecutorService executorService = MySingleton.INSTANCE.getExecutorService();
		System.out.println(executorService);
		ExecutorService executorService2 = MySingleton.INSTANCE.getExecutorService();
		System.out.println(executorService2);

	}

	@Test
	public void t4() throws InterruptedException {
		Vector<Object> objects = new Vector<>();
		for (int i=0;i<25;i++){
			byte[] bytes = new byte[1024 * 1024];
objects.add(bytes);
		}	}
}

