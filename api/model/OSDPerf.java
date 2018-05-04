/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月16日 下午3:56:34
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: OSDPerf
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * @author lemon
 * @date 2018年3月16日
 * 
 */
public class OSDPerf {
	@SerializedName("osd_commit_apply")
	@Expose
	private List<OSDCommitApply> osdPerfLst=null;

	public List<OSDCommitApply> getOsdPerfLst() {
		return osdPerfLst;
	}

	public void setOsdPerfLst(List<OSDCommitApply> osdPerfLst) {
		this.osdPerfLst = osdPerfLst;
	}
}
