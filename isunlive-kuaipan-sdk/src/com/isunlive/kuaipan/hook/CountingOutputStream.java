package com.isunlive.kuaipan.hook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;

public class CountingOutputStream extends FileOutputStream {

  public CountingOutputStream (File file) throws FileNotFoundException
  {
    super (file);
  }

 
//	@Override
//	public void write(int arg0) throws IOException {
//		System.out.println("INFO - "+arg0+" bytes are written.");
//	}

}
