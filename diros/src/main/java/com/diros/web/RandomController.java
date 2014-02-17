package com.diros.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diros.util.TotalAction;

@Controller
@RequestMapping("random")
public class RandomController extends TotalAction{
	
	
	@RequestMapping("code")
	@ResponseBody
	public void execute(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception {
		
		 response.setHeader("Pragma", "No-cache");
         response.setHeader("Cache-Control", "No-cache");
         response.setDateHeader("Expires", 0);
         //指定生成的响应是图片
         response.setContentType("image/jpeg");
		// 在内存中创建图象
		int width = 65, height = 20;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 13 * i + 6, 16);
		}
		// 将认证码存入SESSION
		request.getSession().setAttribute("randomCode", sRand);
		// 图象生效
		g.dispose();

		ImageIO.write(image, "JPEG", response.getOutputStream());	
	}

	/*
	 * 给定范围获得随机颜色
	 */
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	@RequestMapping("checkCode")
	@ResponseBody
	public Map<String, Object> checkRandCode(String randomCode, HttpServletRequest request,ModelMap map){
		System.out.println("randomCode===="+randomCode);
		String code = (String)request.getSession().getAttribute("randomCode");
		if(randomCode.equals(code)){
			map.put(RESULT_CODE, "success");
			map.put(RESULT_MSG, "验证成功");
		}else{
			map.put(RESULT_CODE, "fail");
			map.put(RESULT_MSG, "验证码输入不正确");
			
		}
		return map;
	}
	
	

	
	
}
