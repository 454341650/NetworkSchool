package com.zc.util;

import java.io.File;

public class HtmlDelete {

    public HtmlDelete(){
	}

    /**
     * 
     * @param filePath 要删除的文件的绝对路径
     */
	public  void deleteFile(String filePath){
		
	    try {
				 File fileDe=new File(filePath);
				if(fileDe.exists())
				{
					if(!fileDe.delete())
					{
						System.out.println("\n\n\n删除"+filePath+"失败");
					}
				}
			
			} catch (Exception e) {
				System.out.println("删除"+filePath+"失败!"+e.getMessage());
			} 
			
	    }
	/**
	 * 删除文件及文件夹.
	 * @param filePath 要删除的文件夹的绝对路径
	 * @param isDeleFolder 删除完文件后是否删除文件夹 true:是 false：否
	 */
   public  void deleteFiles(String filePath,boolean isDeleFolder){
		
	    try {
				 File fileDe=new File(filePath);
				 if(fileDe.exists())
				{
				    File   fs[]=fileDe.listFiles();   
			        for(int   i=0;i<fs.length;i++){   
			            fs[i].delete();   
			        }   
			        if(isDeleFolder){
			        	 fileDe.delete();    
			        }
				}

			} catch (Exception e) {
				System.out.println("删除"+filePath+"失败!"+e.getMessage());
			} 
			
	    }

}
