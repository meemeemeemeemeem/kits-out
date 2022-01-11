package com.bstek.bdf2.core.controller;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.apache.commons.lang.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;

public class CaptchaController implements IController {
	private int defaultWidth = 200;
	private int defaultHeight = 60;
	private String defaultSessionKey = "KAPTCHA_SESSION_KEY";
	private String url;

	public CaptchaController() {
	}

	public CaptchaController(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setDateHeader("Expires", 0L);

		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");

		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		response.setHeader("Pragma", "no-cache");

		response.setContentType("image/jpeg");

		int width = this.defaultWidth;
		int height = this.defaultHeight;
		String key = this.defaultSessionKey;
		if (StringUtils.isNotEmpty(request.getParameter("width"))) {
			width = Integer.valueOf(request.getParameter("width")).intValue();
		}
		if (StringUtils.isNotEmpty(request.getParameter("height"))) {
			height = Integer.valueOf(request.getParameter("height")).intValue();
		}
		if (StringUtils.isNotEmpty(request.getParameter("key"))) {
			key = request.getParameter("key");
		}
		Producer captchaProducer = getProducer(width, height);
		String capText = captchaProducer.createText();
		request.getSession().setAttribute(key, capText);

		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		try {
			ImageIO.write(bi, "jpg", out);
			out.flush();
		} finally {
			out.close();
		}
	}

	public boolean anonymousAccess() {
		return true;
	}

	private Producer getProducer(int width, int height) {
		DefaultKaptcha kaptcha = new DefaultKaptcha();
		Properties prop = new Properties();

		prop.put("kaptcha.image.width", String.valueOf(width));
		prop.put("kaptcha.image.height", String.valueOf(height));
		prop.put("kaptcha.textproducer.char.length", "4");
		
		prop.put("kaptcha.textproducer.char.space", "5");
		prop.put("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");
		//prop.put(Constants.KAPTCHA_NOISE_COLOR,"202,202,202");
		prop.put("kaptcha.textproducer.font.size", String.valueOf(height - 10));
		prop.put("kaptcha.textproducer.char.string",
				"0123456789");

		Config config = new Config(prop);
		kaptcha.setConfig(config);
		return kaptcha;
	}

	public boolean isDisabled() {
		return false;
	}
}