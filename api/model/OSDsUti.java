/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月14日 下午4:39:00
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: OSDsUti
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
public class OSDsUti {
	@SerializedName("osd_utilization")
	@Expose
	private List<OSDUti> osdLst=null;

	public List<OSDUti> getOsdLst() {
		return osdLst;
	}

	public void setOsdLst(List<OSDUti> osdLst) {
		this.osdLst = osdLst;
	}
}
