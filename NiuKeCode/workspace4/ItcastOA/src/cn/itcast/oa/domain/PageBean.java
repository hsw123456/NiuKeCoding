package cn.itcast.oa.domain;

import java.util.List;

public class PageBean {
	//指定的或者是页面参数中获取的
	private int pageSize;// 每页显示多少条
	private int currentPage;// 当前页
	
	//查寻数据库
	private List recordList;// 本页的数据列表
	private int recordCount;// 总记录数
	
	//通过计算得到的结果
	private int pageCount;// 总页数
	private int beginPageIndex;// 页码列表的开始索引(包含)
	private int endPageIndex;// 页码列表的结束索引(包含)
	
	
	/**
	 * 只接受前四个必要的参数，其他属性可以通过计算得到
	 * @param pageSize
	 * @param currentPage
	 * @param recordList
	 * @param recordCount
	 */
	public PageBean(int pageSize, int currentPage, List recordList,
			int recordCount) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.recordList = recordList;
		this.recordCount = recordCount;
		//计算总页数
		pageCount = (recordCount + pageSize-1)/pageSize;
		//计算beginPageIndex,endPageIndex
		 //总页数不多于10页是则全部显示
		if(pageCount<=10){
			beginPageIndex = 1;
			endPageIndex = pageCount;
			
		}else {
			
			//总页数多于10页时则显示当前页附近的10个页码
			beginPageIndex = currentPage-4;
			endPageIndex = currentPage +5;
			//当前页的前面不足4个时，则显示前10个页码
				if(beginPageIndex < 1){
					beginPageIndex = 1;
					endPageIndex =10;
					
				}
				//当前页的后面页码不足5个时，则显示后10个页码
				if(endPageIndex >pageCount){
					
					beginPageIndex = pageCount-10 +1;
					endPageIndex = pageCount;
				}
		}
		
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	
	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

}
