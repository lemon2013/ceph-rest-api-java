/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月14日 下午4:33:55
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: OSDUti
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
public class OSDUti {
	@SerializedName("ID")
	@Expose
	private String id;
	@SerializedName("WEIGHT")
	@Expose
	private String weight;
	@SerializedName("REWEIGHT")
	@Expose
	private String reweight;
	@SerializedName("SIZE")
	@Expose
	private String size;
	@SerializedName("USE")
	@Expose
	private String use;
	@SerializedName("AVAIL")
	@Expose
	private String avail;
	@SerializedName("%USE")
	@Expose
	private String useper;
	@SerializedName("VAR")
	@Expose
	private String var;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getReweight() {
		return reweight;
	}
	public void setReweight(String reweight) {
		this.reweight = reweight;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
	}
	public String getUseper() {
		return useper;
	}
	public void setUseper(String useper) {
		this.useper = useper;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
}
