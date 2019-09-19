package org.cod.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError() {

		return "redirect:/errorPage";
	}

	@RequestMapping("/errorPage")
	public String handleErrorPage(HttpSession session) {
		if(session != null) {
			session.removeAttribute("mobile");
			session.invalidate();
		}
		return "error";
	}

	@Override
	public String getErrorPath() {

		return "/error";
	}
}