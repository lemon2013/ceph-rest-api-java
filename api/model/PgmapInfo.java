/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年1月7日 下午5:44:22
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: PgmapInfo
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
public class PgmapInfo {
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("pg_num")
	@Expose
	private String pgNum;
	@SerializedName("pool_num")
	@Expose
	private String poolNum;
	@SerializedName("data")
	@Expose
	private String data;
	@SerializedName("objects")
	@Expose
	private String objects;
	@SerializedName("used")
	@Expose
	private String used;
	@SerializedName("avail")
	@Expose
	private String avail;
	@SerializedName("pg_detail")
	@Expose
	private String pgDetail;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPgNum() {
		return pgNum;
	}
	public void setPgNum(String pgNum) {
		this.pgNum = pgNum;
	}
	public String getPoolNum() {
		return poolNum;
	}
	public void setPoolNum(String poolNum) {
		this.poolNum = poolNum;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getObjects() {
		return objects;
	}
	public void setObjects(String objects) {
		this.objects = objects;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
	}
	public String getPgDetail() {
		return pgDetail;
	}
	public void setPgDetail(String pgDetail) {
		this.pgDetail = pgDetail;
	}
}
