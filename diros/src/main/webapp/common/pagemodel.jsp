<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="tabPaging" align="center">
	&nbsp;共${paging.allCount}条
	<input type='submit'   title="首页" value="首页" onclick="gotoPage(1)"/>
	<input type='submit'  title="上一页" value="上一页" onclick="gotoPage(${paging.currPage-1})"/>
	 <span id="showpage">${paging.currPage}</span> /${paging.maxPage}
	<input type='submit'   title="下一页"  value="下一页" onclick="gotoPage(${paging.currPage+1})"/>
	<input type='submit'   title="尾页" value="尾页"  onclick="gotoPage(${paging.maxPage})"/>
	<input type="hidden" id="currPage" name="currPage" value="${paging.currPage}">
</div>
<script type="text/javascript">
function gotoPage(currPage){
	if(/^\d+$/.test(currPage)&&currPage>0&&currPage<='${paging.maxPage}'){
		document.getElementById("currPage").value=currPage;
		document.getElementById("showpage").innerHTML=currPage; 
	}
}
</script>