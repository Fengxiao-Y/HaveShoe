package com.yidu.avg.pojo;


public class Order {
	private Integer soId;
	private String soTime;
	private Integer usId;
	private Integer marId; 
	private Integer counts; 
	private double subtotal; 
	private Integer spId;
	public Integer getSoId() {
		return soId;
	}
	public void setSoId(Integer soId) {
		this.soId = soId;
	}
	public Integer getUsId() {
		return usId;
	}
	public void setUsId(Integer usId) {
		this.usId = usId;
	}
	public Integer getMarId() {
		return marId;
	}
	public void setMarId(Integer marId) {
		this.marId = marId;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getSpId() {
		return spId;
	}
	public void setSpId(Integer spId) {
		this.spId = spId;
	}
	public String getSoTime() {
		return soTime;
	}
	public void setSoTime(String soTime) {
		this.soTime = soTime;
	}
	@Override
	public String toString() {
		return "Order [soId=" + soId + ", soTime=" + soTime + ", usId=" + usId + ", marId=" + marId + ", counts="
				+ counts + ", subtotal=" + subtotal + ", spId=" + spId + "]";
	}
		
}
