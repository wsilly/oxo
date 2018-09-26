package com.horets.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 日志工厂
 * @author 19777
 *
 */
public class Logger {
	private FileWriter fw;
	private BufferedWriter bw;
	private static File file;
	private static Logger logger;
	
	static {
		File path = new File("src\\logbak");
		file = new File(path, "\\logbak.log");
		if(!file.exists()) {
			path.mkdirs();
			try {
				if (file.createNewFile()) {               
					//System.out.println("创建单个文件" + file + "成功！");                           
				} else {                
					//System.out.println("创建单个文件" + file + "失败！");               
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Logger() {}
	/**
	 * 还回一个单列 Logger对象
	 * @return longger
	 */
	public static Logger getLogger() {
		if(logger == null)
		{
			synchronized (Logger.class) {
				if(logger == null) {
					logger = new Logger();
				}
			}
		}
		return logger;
	}
	
	//日志记录到本地文件中
	private void fileLog(String msg) {
		String nowTimeStr = "";
		if(msg.startsWith("[ERROR]")) {
			nowTimeStr = "[ERROR] " + DateUtil.getCurrentMills() + " "
					+ msg.substring(6, msg.length());
		}else {
			nowTimeStr = "[INFO] " + DateUtil.getCurrentMills() + " " + msg;
		}
		
		try {
			fw = new FileWriter(file, true); //true --> append
			bw = new BufferedWriter(fw);
			bw.write(nowTimeStr);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) {
					bw.close();
				}
				if(fw != null)
				{
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//控制台打印日志
	private void consoleLog(String msg) {
		String nowInfo = "[INFO] " + " " + DateUtil.getCurrentMills() + " " + msg;
		System.out.println(nowInfo);
	}
	
	public void log(String msg) {
		fileLog(msg);
		consoleLog(msg);
	}
}
