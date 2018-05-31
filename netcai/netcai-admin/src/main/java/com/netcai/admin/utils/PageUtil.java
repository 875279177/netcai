package com.netcai.admin.utils;

import java.io.Serializable;

/**
 * 分页工具类
 * 
 * @author administrator
 * @since 1.0
 * @version 1.0 PageUtil.java 2014年4月25日 下午1:52:49
 */
@SuppressWarnings("unused")
public class PageUtil implements Serializable {
	private static final long serialVersionUID = 1L;

	private int pageRecord;// 每页面的记录数
	private int totalRecord;// 总记录数
	private int totalPage;// 总页数
	private int currentPage = 1;// 当前页
	private int prePage;// 上一页
	private int nextPage;// 下一页
	private int pageNumStart;// 页码显示开始listbegin;
	private int pageNumEnd;// 页码显示结束listend;
	private int showPageNum = 10;// 显示页码个数，默认是10

	// 传给MySQL,limit start,end
	private int start;
	private int end;

	private Object object;

	public int getStart() {
		if (this.currentPage == 0)
			return 0;
		else
			return (this.currentPage - 1) * pageRecord;// +1
	}

	public int getEnd() {
		return this.pageRecord;
	}

	public PageUtil() {
	}

	public PageUtil(int pageRecord, int totalRecord, int currentPage) {
		this.pageRecord = pageRecord;
		this.totalRecord = totalRecord;
		this.currentPage = currentPage;
		// 设置总页数
		setTotalRecord(totalRecord);
		// 设置开始页
		setPageNumStart(pageNumStart);
		// 设置结束页
		setPageNumEnd(pageNumEnd);
		// 设置当前页
		setCurrentPage(currentPage);
	}

	public int getPageRecord() {
		return pageRecord;
	}

	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	// 设置总记录数
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		setTotalPage(this.totalRecord % this.pageRecord == 0 ? this.totalRecord / this.pageRecord
				: this.totalRecord / this.pageRecord + 1);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	// 获取当前页
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		// 如果当前页数大于总页数，即当前页等于总页面数
		if (currentPage > getTotalPage()) {
			this.currentPage = getTotalPage();
		} else {
			if (currentPage < 1) {
				this.currentPage = 1;// 如果当前页小于1，默认是1
			} else {
				this.currentPage = currentPage;
			}
		}
	}

	// 获取上一页
	public int getPrePage() {
		return this.getCurrentPage() - 1;
	}

	// 获取下一页
	public int getNextPage() {
		if (this.getCurrentPage() == this.getTotalPage()) {
			return this.nextPage = this.getCurrentPage();
		}
		return this.getCurrentPage() + 1;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPageNumStart() {
		return pageNumStart;
	}

	public void setPageNumStart(int pageNumStart) {
		// 显示页数的一半
		int halfPage = (int) Math.ceil((double) showPageNum / 2);
		if (halfPage >= currentPage) {
			this.pageNumStart = 1;
		} else {
			if (currentPage + halfPage > totalPage) {
				this.pageNumStart = (totalPage - showPageNum + 1) <= 0 ? 1 : (totalPage - showPageNum + 1);
			} else {
				this.pageNumStart = currentPage - halfPage + 1;
			}
		}
	}

	public int getPageNumEnd() {
		return pageNumEnd;
	}

	public void setPageNumEnd(int pageNumEnd) {

		// 显示页数的一半
		int halfPage = (int) Math.ceil((double) showPageNum / 2);
		if (halfPage >= currentPage) {
			this.pageNumEnd = showPageNum > totalPage ? totalPage : showPageNum;
		} else {
			if (currentPage + halfPage >= totalPage) {
				this.pageNumEnd = totalPage;
			} else {
				this.pageNumEnd = currentPage + halfPage;
			}
		}
	}

	public int getShowPageNum() {
		return showPageNum;
	}

	public void setShowPageNum(int showPageNum) {
		this.showPageNum = showPageNum;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}