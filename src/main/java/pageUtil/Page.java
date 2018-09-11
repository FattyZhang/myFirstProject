package pageUtil;
/**
 * 分页功能的实现
 * 想实现分页功能,我们需要用到的几个属性:
 * 1. 页数,及当前页数,需要自己计算,根据第几页总页数,每页几条数据 计算得出
 * 2. 总数,及需要进行分页的数据一共有多少条  数据库 查询得出
 * 3. 条数,及一页共需要展示多少条数据 如果没有值可以设置默认值
 * 6. 开始条数,及从第几条数据开始查询
 * @author Administrator
 *
 */
public class Page {
	/**  当前页数*/
	private Integer currentpage;
	/** 共多少页*/
	private Integer total;
	/** 每页需要展示的条数*/
	private Integer size;
	/** 开始条数*/
	private Integer start;
	/** 总数据数*/
	private Integer count;
	
	
	
	public Page() {
		super();
	}

	/**
	 * 
	 * @param size 每页需要展示的条数
	 * @param currentpage 当前页数
	 * @param count 总数据
	 */
	public Page(Integer size, Integer currentpage, Integer count) {
		this.size = size;
		//总页数
		int total = count/size;
		this.total = total%size == 0 ? total : total+1;
		this.currentpage = currentpage < 1 ? 1:currentpage > total ? total : currentpage;
		this.start = (currentpage-1)*size;
		this.count = count;
	}

	public Integer getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(Integer currentpage) {
		this.currentpage = currentpage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Page [currentpage=" + currentpage + ", total=" + total + ", size=" + size + ", start=" + start
				+ ", count=" + count + "]";
	}
	
	
	
}
