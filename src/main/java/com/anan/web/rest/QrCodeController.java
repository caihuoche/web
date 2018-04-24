package com.anan.web.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghaiyu
 * @date 2018/04/23
 **/
@RestController
public class QrCodeController {

	private static final Map<String, String> map = new HashMap<>();

	/**
	 *  前端轮询检测二维码是否被扫描
	 * @param uuid
	 * @return
	 */
	@GetMapping("/check-qr-code")
	@ResponseBody
	public String check(String uuid) {
		System.out.println("check    "+uuid);
		String s = map.get(uuid);
		if (s != null && !"".equals(s)) {
			return s;
		}
		return "";

	}

	/**
	 *  用户扫描二维码调到这里
	 * @param uuid
	 */
	@GetMapping("/qr-code-login")
	public void qrLogin(String uuid) {
		System.out.println("login    "+uuid);

		// 1 则是扫描的用户登录信息
		String s = map.get(uuid);
		if (s == null || "".equals(s)) {
			map.put(uuid, "1");
		}
	}
}
