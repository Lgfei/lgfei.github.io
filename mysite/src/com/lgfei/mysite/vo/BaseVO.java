package com.lgfei.mysite.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 基类VO
 * @author GitHub4Lgfei
 * @date 2015-5-19
 */
public class BaseVO implements Serializable{

	private static final long serialVersionUID = -6351164974700510303L;
	
	private String enableFlag;
	private Long createBy;	
	private Date createDate;
	private Long lastUpdateBy;	
	private Date lastUpdateDate;
	
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(Long lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
}
