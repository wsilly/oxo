package com.horets.core;

import java.net.ServerSocket;

import com.horets.common.ServerParser;
import com.horets.util.Logger;

/**
 * 启动引导boot
 * @author 19777
 *
 */
public class ServerBoot {
	private static Logger logger = Logger.getLogger();
	
	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			logger.log("server start");
			
			int port = ServerParser.getPort();
			ServerSocket ss = new ServerSocket(port);
			
			long stopTime = System.currentTimeMillis();
			logger.log("httpServer started:" + (startTime - stopTime) + "ms");
			ss.accept();
			logger.log("server stop");
		}catch(Exception e) {
			logger.log("[ERROR]" + e.toString());
			e.printStackTrace();
		}
	}
}
