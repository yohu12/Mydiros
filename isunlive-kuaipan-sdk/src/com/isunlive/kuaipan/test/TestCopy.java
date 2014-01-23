package com.isunlive.kuaipan.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.isunlive.kuaipan.KuaipanAPIFactory;
import com.isunlive.kuaipan.KuaipanAPI;
import com.isunlive.kuaipan.exception.KuaipanAuthExpiredException;
import com.isunlive.kuaipan.exception.KuaipanException;
import com.isunlive.kuaipan.exception.KuaipanIOException;
import com.isunlive.kuaipan.exception.KuaipanServerException;
import com.isunlive.kuaipan.modle.KuaipanFile;

public class TestCopy {

	@Test
	public void testMove() throws KuaipanException {
		KuaipanAPI api = KuaipanAPIFactory.getInstance();

//		System.out.println(file);
		
		String path_root = "/复制mYfIΝλ"+System.currentTimeMillis();
		String path_from = path_root + "/复制前IΝ";
		String path_to = path_root + "/复制后IΝ";
		KuaipanFile file = api.createFolder(path_from);
		
		try {
			file = api.copy(path_from, path_root);
			assertTrue(false);
		} catch (KuaipanServerException e) {
			assertTrue(e.code == 403);
			assertTrue(e.msg.equals("file exist"));
		}
		
		file = api.copy(path_from, path_to);
		
		System.out.println(file);
		assertTrue(KPTestUtility.isExisted(path_to, api));
		assertTrue(KPTestUtility.isExisted(path_from, api));
	}

}
