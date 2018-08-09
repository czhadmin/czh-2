package com.accp.qqemail.entity;

import java.util.List;

public class pageba<T> {

		public int getCont() {
			return cont;
		}
		public void setCont(int cont) {
			this.cont = cont;
		}
		public int getPagesize() {
			return pagesize;
		}
		public void setPagesize(int pagesize) {
			this.pagesize = pagesize;
		}
		public int getDqy() {
			return dqy;
		}
		public void setDqy(int dqy) {
			this.dqy = dqy;
		}
		public int getTiaoshu() {
			return tiaoshu;
		}
		public void setTiaoshu(int tiaoshu) {
			this.tiaoshu = tiaoshu;
		}
		public int getShangpage() {
			return shangpage;
		}
		public void setShangpage(int shangpage) {
			this.shangpage = shangpage;
		}
		public int getXiayiye() {
			return xiayiye;
		}
		public void setXiayiye(int xiayiye) {
			this.xiayiye = xiayiye;
		}
		public List<T> getMylis() {
			return mylis;
		}
		public void setMylis(List<T> mylis) {
			this.mylis = mylis;
		}
		private int cont;//总条数    获取
		private int dqy;//当前页  获取
		private int tiaoshu;//分页条数 获取
		private int shangpage;//上一页    计算
		private int xiayiye;//下一页	  计算
		private int pagesize;//总页码    计算
		private List<T> mylis;//当前页面集合 
//		public String toString() {
//			// TODO Auto-generated method stub
//			return "{cont:'"+this.cont+"',dqy:'"+this.dqy+"',tiaoshu:'"+this.tiaoshu+"',shangpage:'"+this.shangpage+"',xiayiye:'"+this.xiayiye+"',pagesize:'"+this.pagesize+"',list:"+mylis+",}";
//		}
		public pageba(int cont, int dqy, int tiaoshu, List<T> mylis) {
			super();
			this.cont = cont;
			this.dqy = dqy;
			this.tiaoshu = tiaoshu;
			this.mylis = mylis;
			int page = (int)Math.ceil(this.cont/this.tiaoshu);
			this.pagesize = this.cont%this.tiaoshu==0?page:page+1;
			this.xiayiye=this.dqy;//赋初始值
			this.shangpage=this.dqy;//赋初始值
			this.shangpage=this.shangpage<=1?1:this.dqy-1;//如果上一页小于等于1上一页就赋个1，如果不当前页就-1
			this.xiayiye=this.xiayiye>=this.pagesize?this.pagesize:this.dqy+1;//如果下一页大于等于总页就把总页码赋给下一页，如果不当前页+1
		}

		
}
