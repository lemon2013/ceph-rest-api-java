/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月17日 上午10:09:01
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: OSDLocation
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * 
 * @author lemon
 * @date 2018年3月17日
 * 
 */
public class OSDLocation {
	@SerializedName("osd")
	@Expose
	private String osd;
	@SerializedName("ip")
	@Expose
	private String ip;
	@SerializedName("crush_location")
	@Expose
	private CrushLocation crushLocation;

	public String getOsd() {
		return osd;
	}

	public void setOsd(String osd) {
		this.osd = osd;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public CrushLocation getCrushLocation() {
		return crushLocation;
	}

	public void setCrushLocation(CrushLocation crushLocation) {
		this.crushLocation = crushLocation;
	}
}
