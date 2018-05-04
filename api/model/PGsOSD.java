/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月15日 上午10:59:27
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: PGsOSD
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * @author lemon
 * @date 2018年3月15日
 * 
 */
public class PGsOSD {
	@SerializedName("osd_id")
	@Expose
	private String osdId;
	@SerializedName("pg_osd")
	@Expose
	private List<PGInfo> pgOsd=null;
	public String getOsdId() {
		return osdId;
	}
	public void setOsdId(String osdId) {
		this.osdId = osdId;
	}
	public List<PGInfo> getPgOsd() {
		return pgOsd;
	}
	public void setPgOsd(List<PGInfo> pgOsd) {
		this.pgOsd = pgOsd;
	}
}
