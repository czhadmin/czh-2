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
		private int cont;//������    ��ȡ
		private int dqy;//��ǰҳ  ��ȡ
		private int tiaoshu;//��ҳ���� ��ȡ
		private int shangpage;//��һҳ    ����
		private int xiayiye;//��һҳ	  ����
		private int pagesize;//��ҳ��    ����
		private List<T> mylis;//��ǰҳ�漯�� 
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
			this.xiayiye=this.dqy;//����ʼֵ
			this.shangpage=this.dqy;//����ʼֵ
			this.shangpage=this.shangpage<=1?1:this.dqy-1;//�����һҳС�ڵ���1��һҳ�͸���1���������ǰҳ��-1
			this.xiayiye=this.xiayiye>=this.pagesize?this.pagesize:this.dqy+1;//�����һҳ���ڵ�����ҳ�Ͱ���ҳ�븳����һҳ���������ǰҳ+1
		}

		
}
