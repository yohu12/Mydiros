package com.isunlive.kuaipan.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.isunlive.kuaipan.KuaipanAPIFactory;
import com.isunlive.kuaipan.KuaipanAPI;
import com.isunlive.kuaipan.exception.KuaipanException;
import com.isunlive.kuaipan.modle.KuaipanFile;

public class TestDelete {

	@Test
	public void testMove() throws KuaipanException {
		KuaipanAPI api = KuaipanAPIFactory.getInstance();

//		System.out.println(file);
		
		String path_root = "/删除mYfIΝλ"+System.currentTimeMillis();
		String path = path_root + "/删除IΝ";
		KuaipanFile file = api.createFolder(path);
		
		
		file = api.delete(path);
		
		assertTrue(!KPTestUtility.isExisted(path, api));
		assertTrue(KPTestUtility.isExisted(path_root, api));
	}

}
