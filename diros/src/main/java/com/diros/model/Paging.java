package com.diros.model;

public class Paging {
	private  Integer maxPage;//最大页数
	private  Integer currPage=1;//当前页
	private  Integer counts=5;//每一页显示的个数
	//附加的
	private Integer nextPage;//下一页
	private Integer prePage;//上一页
	private Integer startRow;//开始行
	private Integer allCount;//总数

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	public void setMaxPage(String maxPage) {
		if (maxPage==null||maxPage.equals("")) {
			this.maxPage = 0;
		}else {
			this.maxPage = Integer.parseInt(maxPage);
		}
	}
	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public void setCurrPage(String currPage) {
		if (currPage==null||currPage.equals("")) {
			this.currPage = 0;
		}else {
			this.currPage = Integer.parseInt(currPage);
		}
	}
	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public void setCounts(String counts) {
		if (counts==null||counts.equals("")) {
			this.counts = 0;
		}else {
			this.counts = Integer.parseInt(counts);
		}
	}
	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public void setNextPage(String nextPage) {
		if (nextPage==null||nextPage.equals("")) {
			this.nextPage = 0;
		}else {
			this.nextPage = Integer.parseInt(nextPage);
		}
	}
	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public void setPrePage(String prePage) {
		if (prePage==null||prePage.equals("")) {
			this.prePage = 0;
		}else {
			this.prePage = Integer.parseInt(prePage);
		}
	}
	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public void setStartRow(String startRow) {
		if (startRow==null||startRow.equals("")) {
			this.startRow = 0;
		}else {
			this.startRow = Integer.parseInt(startRow);
		}
	}
	public Integer getAllCount() {
		return allCount;
	}

	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
	}
	public void setAllCount(String allCount) {
		if (allCount==null||allCount.equals("")) {
			this.allCount = 0;
		}else {
			this.allCount = Integer.parseInt(allCount);
		}
	}
	@Override
	public String toString() {
		return "Paging [maxPage=" + maxPage + ", currPage=" + currPage
				+ ", counts=" + counts + ", nextPage=" + nextPage
				+ ", prePage=" + prePage + ", startRow=" + startRow
				+ ", allCount=" + allCount + "]";
	}
	


}
