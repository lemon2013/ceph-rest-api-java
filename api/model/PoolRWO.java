/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月14日 上午10:40:11
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: PoolRWO
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * @author lemon
 * @date 2018年3月14日
 * 
 */
public class PoolRWO {
	@SerializedName("rd")
	@Expose
	private String rd;
	@SerializedName("wr")
	@Expose
	private String wr;
	@SerializedName("op")
	@Expose
	private String op;
	public String getRd() {
		return rd;
	}
	public void setRd(String rd) {
		this.rd = rd;
	}
	public String getWr() {
		return wr;
	}
	public void setWr(String wr) {
		this.wr = wr;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
}
