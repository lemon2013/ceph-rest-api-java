/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月16日 下午3:53:43
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: OSDCommitApply
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
public class OSDCommitApply {
	@SerializedName("osd_id")
	@Expose
	private String osdId;
	@SerializedName("fs_commit_latency")
	@Expose
	private String fsCommitLatency;
	@SerializedName("fs_apply_latency")
	@Expose
	private String fsApplyLatency;
	public String getOsdId() {
		return osdId;
	}
	public void setOsdId(String osdId) {
		this.osdId = osdId;
	}
	public String getFsCommitLatency() {
		return fsCommitLatency;
	}
	public void setFsCommitLatency(String fsCommitLatency) {
		this.fsCommitLatency = fsCommitLatency;
	}
	public String getFsApplyLatency() {
		return fsApplyLatency;
	}
	public void setFsApplyLatency(String fsApplyLatency) {
		this.fsApplyLatency = fsApplyLatency;
	}
}
