package com.zc.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 该类用于上传文件
 * 
 */

@Component
public final class UploadFile {
	
	/**
	 * 检验并调用上传方法
	 * 
	 * savePath：保存在项目下的文件夹名；
	 * uploadFileName：上传的文件的名称；
	 * Upload：要上传的文件域;
	 * @return
	 * 1:上传文件太大；  
	 * 2:上传文件类型不正确；
	 * -1:上传文件损坏
	 */
	public int load(String savePath, String uploadFileName, File upload,int size,String[] typeList) throws IOException{
		
		if(!limitSize(upload, size))
			return 1;
		else if(!limitKind(uploadFileName,typeList))
			return 2; 
		
		createPackage(savePath);
		
		if(!loadFile(savePath, uploadFileName, upload))
			return -1;
		return 0;
	}
	/**
	 * 压缩上传图片
	 * 
	 * savePath：保存在项目下的文件夹名；
	 * uploadFileName：上传的文件的名称；
	 * Upload：要上传的文件域;
	 * width:宽度;
	 * height:高度;
	 * proportion:是否等比缩放
	 * @return
	 * 1:上传文件太大；  
	 * 2:上传文件类型不正确；
	 * -1:上传文件损坏
	 */
	public int compressImage(String savePath, String uploadFileName, File upload,int size,String[] typeList,int width,int height,boolean proportion) throws IOException{
		
		if(!limitSize(upload, size))
			return 1;
		else if(!limitKind(uploadFileName,typeList))
			return 2; 
		
		createPackage(savePath);
		
		if(!loadImage(savePath, uploadFileName, upload,width,height,proportion))
			return -1;
		return 0;
	}
	
	/**
	 * 上传文件
	 * 
	 * savePath：保存在项目下的文件夹名；
	 * uploadFileName：上传的文件的名称；
	 * Upload：要上传的文件域
	 */
	protected boolean loadFile(String savePath, String uploadFileName, File upload){

		FileOutputStream out = null;
		FileInputStream in = null;

		try {
			out = new FileOutputStream(this.realPath()+savePath + "//" + uploadFileName);
			in = new FileInputStream(upload);

			byte[] buffer = new byte[5*1024];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		}catch(IOException e){
			return false;
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (null != out) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
				}
			}
		}

		return true;
	}
	/**
	 * 上传图片
	 * 
	 * savePath：保存在项目下的文件夹名；
	 * uploadFileName：上传的文件的名称；
	 * Upload：要上传的文件域
	 * width：宽
	 * height：高
	 * proportion 是否等比缩放
	 */
	protected boolean loadImage(String savePath, String uploadFileName, File upload,int outputWidth,int outputHeight,boolean proportion){
        try {
        	Image img = ImageIO.read(upload);   
            // 判断图片格式是否正确   
            if (img.getWidth(null) == -1) {  
                return false; 
            } else {   
                int newWidth; int newHeight;   
                // 判断是否是等比缩放   
                if (proportion == true) {   
                    // 为等比缩放计算输出的图片宽度及高度   
                    double rate1 = ((double) img.getWidth(null)) / (double) outputWidth + 0.1;   
                    double rate2 = ((double) img.getHeight(null)) / (double) outputHeight + 0.1;   
                    // 根据缩放比率大的进行缩放控制   
                    double rate = rate1 > rate2 ? rate1 : rate2;   
                    newWidth = (int) (((double) img.getWidth(null)) / rate);   
                    newHeight = (int) (((double) img.getHeight(null)) / rate);   
                } else {   
                    newWidth = outputWidth; // 输出的图片宽度   
                    newHeight = outputHeight; // 输出的图片高度   
                }   
               BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);   
                 
               /* 
                * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 
                * 优先级比速度高 生成的图片质量比较好 但速度慢 
                */   
               tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);  
               FileOutputStream out = new FileOutputStream(this.realPath()+savePath + "\\" + uploadFileName);  
               // JPEGImageEncoder可适用于其他图片类型的转换   
               JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
               encoder.encode(tag);   
               out.close();   
    		   
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
            return true;
	}
	
	/**
	 * 备用（由于上传的文件其文件名同时也要保存到数据库中，即其文件名在服务层就因该确定)
	 * 重新组装文件名，以时间作为文件名
	 */
	public String fileName(String uploadFileName){
		Date date=new Date();
		SimpleDateFormat from = new SimpleDateFormat("yyyyMMddHHmmss");
		String end=uploadFileName.substring(uploadFileName.lastIndexOf(".")+1,uploadFileName.length());
		String fileName = from.format(date)+"."+end;
		return fileName;
	}
	
	
	/**
	 * 限制上传文件的大小
	 * 
	 * Upload:要上传的文件域
	 * size:要限制上传文件的大小
	 */
	protected boolean limitSize(File upload,int size){
		if (upload.length() > size)
			return false;
		return true;
	}
	/**
	 * 限制上传文件的类型
	 * 
	 * uploadFileName: 要上传的文件名称
	 */
	protected boolean limitKind(String uploadFileName,String[] typeList){
		String suffix = uploadFileName.substring((uploadFileName
				.lastIndexOf(".") + 1), uploadFileName.length());
		suffix = suffix.toLowerCase();
		for(int i=0;i<typeList.length;i++){
		if (suffix.equals(typeList[i].toLowerCase()))
			return true;
		}
		return false;
	}
	
	/**
	 * 创建文件夹，保存上传文件
	 * 
	 * savePath：上传文件存放文件夹名
	 */
	protected void createPackage(String savePath) {
		if (!new File(realPath()+savePath).isDirectory())// 如果不存在就创建文件夹
			new File(realPath()+savePath).mkdirs();
	}
	
	/**
	 * 获得根目录的绝对路径
	 */
	@SuppressWarnings("deprecation")
	public String realPath(){
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getRealPath("/");
	}


}
