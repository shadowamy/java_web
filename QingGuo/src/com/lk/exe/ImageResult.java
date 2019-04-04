package com.lk.exe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class ImageResult {

	
	private String exec;

	/*public ImageResult(String exec) {
		super();
		this.exec = exec;
	}*/

	public ImageResult() {
		super();
		this.exec = "python D:/iot/2019hanjia/cm/img-trans.py";
	}
	
	public String getResult()
	{
		Process proc;
		try {
			
			proc = Runtime.getRuntime().exec(exec);
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = null;
			String result = null;
			while ((line = in.readLine())!=null) {
				//System.out.println(line);
				if(line!=null) result = line;
			}

			in.close();
			proc.waitFor();
			return result;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
