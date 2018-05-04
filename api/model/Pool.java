/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年1月5日 下午6:41:25
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: Pool
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * @author lemon
 * @date 2018年1月5日
 * 
 */
public class Pool {
	@SerializedName("NAME")
	@Expose
	private String name;
	@SerializedName("ID")
	@Expose
	private String id;
	@SerializedName("USED")
	@Expose
	private String used;
	@SerializedName("%USED")
	@Expose
	private String usedPCT;
	@SerializedName("MAX AVAIL")
	@Expose
	private String maxAvail;
	@SerializedName("OBJECTS")
	@Expose
	private String objects;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public String getUsedPCT() {
		return usedPCT;
	}
	public void setUsedPCT(String usedPCT) {
		this.usedPCT = usedPCT;
	}
	public String getMaxAvail() {
		return maxAvail;
	}
	public void setMaxAvail(String maxAvail) {
		this.maxAvail = maxAvail;
	}
	public String getObjects() {
		return objects;
	}
	public void setObjects(String objects) {
		this.objects = objects;
	}
}
