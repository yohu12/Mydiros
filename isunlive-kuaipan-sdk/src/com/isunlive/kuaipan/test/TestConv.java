package com.isunlive.kuaipan.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;

import com.isunlive.kuaipan.KuaipanAPIFactory;
import com.isunlive.kuaipan.KuaipanAPI;
import com.isunlive.kuaipan.KuaipanAPI.ConvType;
import com.isunlive.kuaipan.KuaipanAPI.ConvView;
import com.isunlive.kuaipan.exception.KuaipanAuthExpiredException;
import com.isunlive.kuaipan.exception.KuaipanException;
import com.isunlive.kuaipan.exception.KuaipanIOException;
import com.isunlive.kuaipan.exception.KuaipanServerException;
import com.isunlive.kuaipan.hook.CountingOutputStream;
import com.isunlive.kuaipan.modle.FileInfo;
import com.isunlive.kuaipan.modle.KuaipanFile;
import com.isunlive.kuaipan.modle.KuaipanHTTPResponse;

public class TestConv {

	@Test
	public void testThumbnail() throws IOException, KuaipanException {
		KuaipanAPI api = KuaipanAPIFactory.getInstance();
		String path = "测试图片.gif";
		
		File f = new File("res/test.gif");
		long size = f.length();
		
		InputStream is = null;
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			assertTrue(false);
		}
		
		KuaipanFile file_before = api.uploadFile(path, is, size, true, null);
		try {
			is.close();
		} catch (IOException e) {}
		System.out.println(file_before);
		
		CountingOutputStream os = new CountingOutputStream(new File("./test.jpg"));
		KuaipanHTTPResponse resp = api.thumbnail(path, os, null);
		os.close();
//		KPTestUtility.openBrowser(resp.url.url);
		
		System.out.println (resp.url.url);
	}
	
	
	@Test
	public void testDocumentView() throws IOException, KuaipanException {
		KuaipanAPI api = KuaipanAPIFactory.getInstance();
		String path = "/测试文档2.doc";
		
		File f = new File("res/test.doc");
		long size = f.length();
		
		InputStream is = null;
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			assertTrue(false);
		}
		
		KuaipanFile file_before = api.uploadFile(path, is, size, true, null);
		try {
			is.close();
		} catch (IOException e) {}
		System.out.println(file_before);
		
		CountingOutputStream os = new CountingOutputStream(new File("./"));
		KuaipanHTTPResponse resp = api.documentView(ConvType.DOC, ConvView.IPAD, path, os, null);
		os.close();
		System.out.println (resp.url.url);
//		KPTestUtility.openBrowser(resp.url.url);		
	}
	
	public static void main(String []s) throws IOException, KuaipanException {
	    new TestConv().testDocumentView();
	}
	
	@Test
	public void testPicView ()
  {
	  KuaipanAPI api=KuaipanAPIFactory.getInstance ();
	  InputStream is = null;
	 FileInfo fileInfo=new FileInfo("./test.gif");
	 fileInfo.setRemotePath("/测试图片.gif");
    try
    {
      CountingOutputStream os = new CountingOutputStream(fileInfo);
      KuaipanHTTPResponse resp = api.thumbnail(128,128,"/测试图片.gif", os, null);
  
      os.close();
           
      System.out.println (resp.url.url);
    }
    
    catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
  }
}
