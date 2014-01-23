package com.isunlive.kuaipan.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.isunlive.kuaipan.KuaipanAPIFactory;
import com.isunlive.kuaipan.KuaipanAPI;
import com.isunlive.kuaipan.exception.KuaipanException;
import com.isunlive.kuaipan.exception.KuaipanServerException;
import com.isunlive.kuaipan.modle.KuaipanFile;

public class TestMove {

	@Test
	public void testMove() throws KuaipanException {
		KuaipanAPI api = KuaipanAPIFactory.getInstance();

//		System.out.println(file);
		
		String path_root = "/移动mYfIΝλ"+System.currentTimeMillis();
		String path_from = path_root + "/移动前IΝ";
		String path_to = path_root + "/移动后IΝ";
		KuaipanFile file = api.createFolder(path_from);
		
		try {
			file = api.move(path_from, path_root);
			assertTrue(false);
		} catch (KuaipanServerException e) {
			assertTrue(e.code == 403);
			assertTrue(e.msg.equals("file exist"));
		}
		
		file = api.move(path_from, path_to);
		
		assertTrue(KPTestUtility.isExisted(path_to, api));
		assertTrue(!KPTestUtility.isExisted(path_from, api));
	}

}
