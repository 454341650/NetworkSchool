package com.zc.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * xml生成.
 *
 */
public class XmlProduce {

	
	
	public static Boolean creatXml(String xmlStr,String saveFolder,String xmlName) {
	        boolean rtnValue = false;
	        try {
	        	//xmlStr=new String(xmlStr.getBytes("iso-8859-1"),"gbk"); 
	        	//xmlStr=new String(xmlStr.getBytes("gbk"),"UTF-8"); 
	        	File dirFile = new File(saveFolder);
	            if(!dirFile.exists()){
	            	dirFile.mkdirs();
	            }
	            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(saveFolder + "\\"+ xmlName),"utf-8");
	           // OutputStream out = new FileOutputStream(folder + "\\"
	                   // + name);
	           // DataOutputStream dos = new DataOutputStream(out);
	            out.write(xmlStr);
	            
	            out.close();
	            out.close();
	            rtnValue = true;
	            System.out.println("已成功生成Xml => "+saveFolder + "\\"+ xmlName);
	        } catch (IOException e) {
	        	e.printStackTrace();
	            rtnValue = false;
	        }
	        return rtnValue;

	    }
	 
	 public static void parserXml(String xmlpath,String code)
	 {
		  double all = 0d;
		  double nt = 0d;
		  double out = 0d;
		  double contract =0d;
		  double nt_contract = 0d;
		  double all_tax = 0d;
		  double in = 0d;
		 SAXReader saxReader = new SAXReader();
		 try {
			
			Document document = saxReader.read(new File(xmlpath));
			Element root = document.getRootElement();
			for ( Iterator iter = root.elementIterator(); iter.hasNext(); ) 
			{
				 Element element = (Element) iter.next();
				 Attribute timeAttr = element.attribute("time");
				 Attribute allAttr = element.attribute("all");
				 Attribute ntAttr = element.attribute("nt");
				 Attribute outAttr = element.attribute("out");
				 Attribute contractAttr = element.attribute("contract");
				 Attribute nt_contractAttr = element.attribute("nt_contract");
				 Attribute all_taxAttr = element.attribute("all_tax");
				 Attribute inAttr = element.attribute("in");
				 Attribute codeAttr = element.attribute("code");
				 if(codeAttr !=null)
				 {
					 if(code.equals(codeAttr.getValue()))
					 {
						 if(allAttr != null)
							 all += Double.parseDouble(allAttr.getValue());
						 if(ntAttr != null)
							 nt += Double.parseDouble(ntAttr.getValue());
						 if(outAttr != null)
							 out += Double.parseDouble(outAttr.getValue());
						 if(contractAttr != null)
							 contract += Double.parseDouble(contractAttr.getValue());
						 if(nt_contractAttr != null)
							 nt_contract += Double.parseDouble(nt_contractAttr.getValue());
						 if(all_taxAttr != null)
							 all_tax += Double.parseDouble(all_taxAttr.getValue());
						 if(inAttr != null)
							 in += Double.parseDouble(inAttr.getValue());
						 
					 }
						

				 }
				// System.out.println(timeAttr.getValue()+"|"+codeAttr.getValue()+"： "+ArithUtil.add2(all,0) +"\t"+ ArithUtil.add2(nt,0) +"\t" +  ArithUtil.add2(out,0) +"\t" + ArithUtil.add2(contract,0) + "\t" + ArithUtil.add2(nt_contract,0) +"\t" + ArithUtil.add(all_tax,0));
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	 }
	 public  void parserXml2(String xmlpath)
	 {
		  double all = 0d;
		  double nt = 0d;
		  double invoice = 0d;
		  double nt_invoice =0d;
		  double profit = 0d;
		  double web_profit = 0d;
		  double all_tax = 0d;
		  double invoice_tax = 0d;
		  double nt_web_profit = 0d;
		  SAXReader saxReader = new SAXReader();
		  
		 try {
			Document document = saxReader.read(new File(xmlpath));
			Element root = document.getRootElement();
			for ( Iterator iter = root.elementIterator(); iter.hasNext(); ) 
			{
				 Element element = (Element) iter.next();
				 Attribute codeAttr = element.attribute("code");
				 Attribute timeAttr = element.attribute("time");
				 Attribute allAttr = element.attribute("all");
				 Attribute ntAttr = element.attribute("nt");
				 Attribute invoiceAttr = element.attribute("invoice");
				 Attribute nt_invoiceAttr = element.attribute("nt_invoice");
				 Attribute profitAttr = element.attribute("profit");
				 Attribute web_profitAttr = element.attribute("web_profit");
				 Attribute all_taxAttr = element.attribute("all_tax");
				 Attribute invoice_taxAttr = element.attribute("invoice_tax");
				 Attribute nt_web_profitAttr = element.attribute("nt_web_profit");
				 
				 /*all = ArithUtil.add(all, Double.parseDouble(allAttr.getValue()));
				 nt = ArithUtil.add(nt, Double.parseDouble(ntAttr.getValue()));
				 invoice = ArithUtil.add(invoice, Double.parseDouble(invoiceAttr.getValue()));
				 nt_invoice = ArithUtil.add(nt_invoice, Double.parseDouble(nt_invoiceAttr.getValue()));
				 profit = ArithUtil.add(profit, Double.parseDouble(profitAttr.getValue()));
				 web_profit = ArithUtil.add(web_profit, Double.parseDouble(web_profitAttr.getValue()));
				 all_tax = ArithUtil.add(all_tax, Double.parseDouble(all_taxAttr.getValue()));
				 invoice_tax = ArithUtil.add(invoice_tax, Double.parseDouble(invoice_taxAttr.getValue()));
				 nt_web_profit = ArithUtil.add(nt_web_profit, Double.parseDouble(nt_web_profitAttr.getValue()));*/
				 
				 all += Double.parseDouble(allAttr.getValue());
				 nt += Double.parseDouble(ntAttr.getValue());
				 invoice += Double.parseDouble(invoiceAttr.getValue());
				 nt_invoice += Double.parseDouble(nt_invoiceAttr.getValue());
				 profit += Double.parseDouble(profitAttr.getValue());
				 web_profit += Double.parseDouble(web_profitAttr.getValue());
				 all_tax += Double.parseDouble(all_taxAttr.getValue());
				 invoice_tax += Double.parseDouble(invoice_taxAttr.getValue());
				 nt_web_profit += Double.parseDouble(nt_web_profitAttr.getValue());

			}
			//System.out.println(xmlpath+" :读取完毕！");
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	 }
	 public static void main(String[] args) {
		String filepath = "F:\\workspace\\javaworkspace\\Myeclipse6.5\\BigData\\WebRoot\\archive\\purchase\\purchaseStructure\\department\\0208\\productType\\"; 
		long beforeT = System.currentTimeMillis();
		File file = new File(filepath);
		if(file.isDirectory())
		{
			File [] targetFilesAry = file.listFiles();
			for(int i =0 ; i<targetFilesAry.length; i++)
			{
				XmlProduce.parserXml(filepath,targetFilesAry[i].getAbsolutePath());
				System.out.println(targetFilesAry[i].getAbsolutePath());
			}
			System.out.println(targetFilesAry.length);
		}
		//System.out.println(ArithUtil.add2(all,0) +"\t"+ ArithUtil.add2(nt,0) +"\t" +  ArithUtil.add2(out,0) +"\t" + ArithUtil.add2(contract,0) + "\t" + ArithUtil.add2(nt_contract,0) +"\t" + ArithUtil.add(all_tax,0));
		long afterT = System.currentTimeMillis();
		System.out.println("开始时间："+beforeT);
		System.out.println("完成时间："+afterT);
		System.out.println("执行时间："+(afterT - beforeT));
		//XmlProduce.parserXml("F:\\workspace\\javaworkspace\\Myeclipse6.5\\BigData\\WebRoot\\archive\\purchase\\purchaseStructure\\department\\0245\\productType\\2010-09-30.xml");
	}
}
