package com.zj.book.bean;

import java.util.Date;
import java.util.List;

import com.zj.book.utils.DateUtil;

public class Seckill {

	private Long seckillId;
	
	private String name;
	
	private Integer number;
	
	private Date startTime;
	
	private Date endTime;
	
	private Date createTime;
	
	
	//秒杀列表
	private List<Successkilled> successKilleds;
	

	public Long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(Long seckillId) {
		this.seckillId = seckillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	/*public Date getStartTime() {
		return startTime;
	}*/
	public String getStartTime() {
		return DateUtil.formatByDate(startTime);
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return DateUtil.formatByDate(endTime);
	}
/*	public Date getEndTime() {
		return endTime;
	}
*/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCreateTime() {
		return DateUtil.formatByDate(createTime);
	}
	/*public Date getCreateTime() {
		return createTime;
	}*/

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

	public List<Successkilled> getSuccessKilleds() {
		return successKilleds;
	}

	public void setSuccessKilleds(List<Successkilled> successKilleds) {
		this.successKilleds = successKilleds;
	}

	@Override
	public String toString() {
		return "Seckill [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", createTime=" + createTime + ", successKilleds=" + successKilleds.size() + "]";
	}

	
	
	
}
