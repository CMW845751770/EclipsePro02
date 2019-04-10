package cn.edu.tju.pojo;

import java.io.Serializable;
import java.util.List;

public class PageInfo implements Serializable
{
	private int pageSize ; //һҳ��ʾ����
	private int pageNumber ;//Ŀǰ�ǵڼ�ҳ
	private int pageStart ;//��ʼҳ��
	private long total ; //��ҳ��
	private List<?> list ;
	private long count ; ///������
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	} 
	public PageInfo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PageInfo [pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", pageStart=" + pageStart + ", total="
				+ total + ", list=" + list + ", count=" + count + "]";
	}
	
	
}
