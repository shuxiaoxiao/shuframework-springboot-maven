package com.shuframework.javaeedemo.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/lottery/go",description = "请在前端ajax调用或者直接httpclient直接调用，可以返回抽奖结果，需要别的功能可以继续扩展")  
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object[][] prizeArr = new Object[][] {
				// 奖品id,min,max，prize【奖项】,v【中奖率】
				{ 1, 1, 14, "一等奖", 1 }, { 2, 346, 364, "一等奖", 1 }, { 3, 16, 44, "不要灰心", 10 },
				{ 4, 46, 74, "神马也没有", 10 }, { 5, 76, 104, "祝您好运", 10 }, { 6, 106, 134, "二等奖", 2 },
				{ 7, 136, 164, "再接再厉", 10 }, { 8, 166, 194, "神马也没有", 10 }, { 9, 196, 224, "运气先攒着", 10 },
				{ 10, 226, 254, "三等奖", 5 }, { 11, 256, 284, "要加油哦", 10 }, { 12, 286, 314, "神马也没有", 10 },
				{ 13, 316, 344, "谢谢参与", 10 }
			};
		Object result[] = award(prizeArr);// 抽奖后返回角度和奖品等级
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("{\"angle\":\"" + result[0] + "\",\"msg\":\"" + result[2] + "\"}");
		System.out.println("转动角度:" + result[0] + "\t奖项ID:" + result[1] + "\t提示信息:" + result[2]);
	}

	// 抽奖并返回角度和奖项
	public Object[] award(Object[][] prizeArr) {
		// 概率数组
		Integer obj[] = new Integer[prizeArr.length];
		for (int i = 0; i < prizeArr.length; i++) {
			obj[i] = (Integer) prizeArr[i][4];
		}
		Integer prizeId = getRand(obj); // 根据概率获取奖项id
		// 旋转角度
		int seed = (Integer) prizeArr[prizeId][2] - (Integer) prizeArr[prizeId][1];
		int angle = new Random().nextInt(seed) + (Integer) prizeArr[prizeId][1];
		String msg = (String) prizeArr[prizeId][3];// 提示信息
		return new Object[] { angle, prizeId, msg };
	}

	// 根据概率获取奖项
	public Integer getRand(Integer obj[]) {
		Integer result = null;
		try {
			int sum = 0;// 概率数组的总概率精度
			for (int i = 0; i < obj.length; i++) {
				sum += obj[i];
			}
			for (int i = 0; i < obj.length; i++) {// 概率数组循环
				int randomNum = new Random().nextInt(sum);// 随机生成1到sum的整数
				if (randomNum < obj[i]) {// 中奖
					result = i;
					break;
				} else {
					sum -= obj[i];
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
