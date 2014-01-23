package com.isunlive.kuaipan.test;

import org.junit.Test;

import com.isunlive.kuaipan.KuaipanAPIFactory;
import com.isunlive.kuaipan.KuaipanAPI;
import com.isunlive.kuaipan.exception.KuaipanException;
import com.isunlive.kuaipan.modle.KuaipanUser;

public class TestAccountInfo {

	@Test
	public void testAccountInfo() throws KuaipanException {
		KuaipanAPI api = KuaipanAPIFactory.getInstance();
		
		KuaipanUser user = api.accountInfo();
		
		System.out.println(user);
	}

}
