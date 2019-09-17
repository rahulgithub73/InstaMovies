package org.cod.client;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BrowserDetector {

	private static final Logger log = LoggerFactory.getLogger(BrowserDetector.class);

	public String getBrowserType(HttpServletRequest request) {

		String browserDetails = request.getHeader("User-Agent");
		String userAgent = browserDetails;

		String os = "";

		log.info("User Agent for the request is===> {} " , browserDetails);

		if (userAgent.toLowerCase().indexOf("windows") >= 0) {
			os = "Windows";
		} else if (userAgent.toLowerCase().indexOf("mac") >= 0) {
			os = "IPhone";
		} else if (userAgent.toLowerCase().indexOf("x11") >= 0) {
			os = "Unix";
		} else if (userAgent.toLowerCase().indexOf("android") >= 0) {
			os = "Android";
		} else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {
			os = "IPhone";
		} else {
			os = "UnKnown, More-Info: " + userAgent;
		}

		log.info("Operating System======>{}" , os);

		return os;

	}

}
