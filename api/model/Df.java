/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年1月5日 下午6:32:00
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: Df
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * 
 * @author lemon
 * @date 2018年1月5日
 * 
 */
public class Df {
	@SerializedName("SIZE")
	@Expose
	private String size;
	@SerializedName("AVAIL")
	@Expose
	private String avail;
	@SerializedName("RAW USED")
	@Expose
	private String rawUsed;
	@SerializedName("%RAW USED")
	@Expose
	private String rawUsedPCT;
	@SerializedName("POOLS")
	@Expose
	private List<Pool> pools = null;
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
	}
	public String getRawUsed() {
		return rawUsed;
	}
	public void setRawUsed(String rawUsed) {
		this.rawUsed = rawUsed;
	}
	public String getRawUsedPCT() {
		return rawUsedPCT;
	}
	public void setRawUsedPCT(String rawUsedPCT) {
		this.rawUsedPCT = rawUsedPCT;
	}
	public List<Pool> getPools() {
		return pools;
	}
	public void setPools(List<Pool> pools) {
		this.pools = pools;
	}
}
