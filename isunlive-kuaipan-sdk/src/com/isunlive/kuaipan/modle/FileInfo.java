package com.isunlive.kuaipan.modle;

import java.io.File;
import java.net.URI;

public class FileInfo extends File {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String remotePath;
	private String remoteName;
	public String getRemotePath() {
		return remotePath;
	}

	public void setRemotePath(String remotePath) {
		this.remotePath = remotePath;
	}

	public String getRemoteName() {
		return remoteName;
	}

	public void setRemoteName(String remoteName) {
		this.remoteName = remoteName;
	}

	public FileInfo(String pathname) {
		super(pathname);
	}

	public FileInfo(String parent, String child) {

		super(parent, child);
	}

	public FileInfo(File parent, String child) {
		super(parent, child);
	}

	public FileInfo(URI uri) {
		super(uri);
	}
}
