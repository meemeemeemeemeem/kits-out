package com.kits.inms.api.controller;

import com.kits.core.base.RSAService;
import com.kits.core.model.RSAList;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
public class RsaController {
	@Autowired
	private RSAService rsaService;

	@ResponseBody
	@RequestMapping(value = "/rsa", method = RequestMethod.GET)
	public String getRSA(String tenantId, HttpSession session) {
		JSONObject result = new JSONObject();
		RSAList rsa = rsaService.getRandRSA();
		session.setAttribute("RSA_", rsa.getId());
		session.setAttribute("TENANT_ID_", tenantId);
		result.accumulate("result", true);
		result.accumulate("puk", rsa.getPubKeyString());
		return result.toString();
	}
}
