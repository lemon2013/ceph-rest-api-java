/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年1月7日 下午5:37:27
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: OsdmapInfo
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * @author lemon
 * @date 2018年1月7日
 * 
 */
public class OsdmapInfo {
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("osd_num")
	@Expose
	private String osdNum;
	@SerializedName("up_num")
	@Expose
	private String upNum;
	@SerializedName("in_num")
	@Expose
	private String inNum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOsdNum() {
		return osdNum;
	}
	public void setOsdNum(String osdNum) {
		this.osdNum = osdNum;
	}
	public String getUpNum() {
		return upNum;
	}
	public void setUpNum(String upNum) {
		this.upNum = upNum;
	}
	public String getInNum() {
		return inNum;
	}
	public void setInNum(String inNum) {
		this.inNum = inNum;
	}
}
