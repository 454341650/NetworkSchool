package com.zc.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

public class HtmlCreator{
	
	
	
public HtmlCreator(){}
	

  HttpServletRequest request;
    
	/**
	 * 根据传过来的参数生成静态html页面
	 * @param fileFolder 生成静态html的文件夹
	 * ,如项目(当前为mep)根目录下的product文件夹下的client文件夹应写成product/clinet而不能写成/product/client/
	 * @param fileName 生成的文件名
	 * @param requestUrl 生成静表态html时的请求地址
	 */
	public  int outHtml(String fileFolder,String fileName,String requestUrl){
		
	    try {
	    	
	    	    File  folder = new File(fileFolder);
	    	   
				if(!folder.exists())
				{
					if(!folder.mkdirs())
					{
						System.out.println("\n\n\n文件夹创建失败");
						return 1;
					}
				}
				 /* HttpClient client = new HttpClient(); 
	    	    PostMethod post= new PostMethod(url ); 
	    	    int statusCode=client.executeMethod(post); 
	    	    byte[] responseBody = post.getResponseBody(); 
	    	    String content = new String(responseBody,"UTF-8"); 
	    	    post.releaseConnection(); */
				URL conUrl = new URL(requestUrl);
	            URLConnection connection = conUrl.openConnection(); 
	            connection.connect(); 
	            HttpURLConnection httpURLConnection = (HttpURLConnection) connection; 
	            int httpResult = httpURLConnection.getResponseCode(); 
	            if (httpResult != HttpURLConnection.HTTP_OK)
	            { 
	            	System.out.println("URLConnection没有连接成功!");
	            	return 1;
	            }
	            else 
	            { 
	            
	            	InputStream  inputStream  = new BufferedInputStream(httpURLConnection.getInputStream());
	            	
	            	
	                // 写入到数据流
					 BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(fileFolder+"\\"+fileName));
					 // 设置流数据包的大小
					 byte[] buffer=new byte[64 * 1024];
						int length;
						while((length=inputStream.read(buffer,0,buffer.length))>0)
						{
							out.write(buffer,0,length);
						}
						out.flush();
						out.close();
				
	            } 

			} catch (FileNotFoundException e) {
				System.out.println("创建静态页面:"+fileName+"失败!"+e.getMessage());
			} 
			catch (IOException e) {
				System.out.println("创建静态页面:"+fileName+"失败!"+e.getMessage());
			}catch (Exception e) {
				System.out.println("创建静态页面:"+fileName+"失败!"+e.getMessage());
			}
			return 0;
	    }

}
