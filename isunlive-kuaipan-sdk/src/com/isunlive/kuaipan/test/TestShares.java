package com.isunlive.kuaipan.test;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.isunlive.kuaipan.KuaipanAPIFactory;
import com.isunlive.kuaipan.KuaipanAPI;
import com.isunlive.kuaipan.exception.KuaipanException;
import com.isunlive.kuaipan.modle.KuaipanPublicLink;

public class TestShares {

	@Test
	public void testMetadata() 
			throws UnsupportedEncodingException, KuaipanException {
		KuaipanAPI api = KuaipanAPIFactory.getInstance();
		
		// empty folder
		String folder = "/空文件夹mYfIlEΙΝλ" + System.currentTimeMillis();
		api.createFolder(folder);
		
		String path = folder+"/文件1.txt";
		String content = KPTestUtility.upload(api, path);
		
		String link_url = null;
		KuaipanPublicLink link = api.shares(path, null, null);
		link_url = link.url;
		assertTrue(link.url.startsWith("http://www.kuaipan"));
		assertTrue(link.access_code == null);
		
		System.out.println(link_url);
		
		String access_code = "aaaaaa";
		link = api.shares(path, null, access_code);
		assertTrue(link.url.equals(link.url));
		assertTrue(link.access_code.equals(access_code));
		System.out.println(link_url);
	}
}
