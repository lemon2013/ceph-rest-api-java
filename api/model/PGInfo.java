/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月15日 上午10:59:55
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: PGInfo
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
public class PGInfo {
	@SerializedName("pg_stat")
	@Expose
	private String pgStat;
	@SerializedName("objects")
	@Expose
	private String objects;
	@SerializedName("mip")
	@Expose
	private String mip;
	@SerializedName("degr")
	@Expose
	private String degr;
	@SerializedName("misp")
	@Expose
	private String misp;
	@SerializedName("unf")
	@Expose
	private String unf;
	@SerializedName("bytes")
	@Expose
	private String bytes;
	@SerializedName("log")
	@Expose
	private String log;
	@SerializedName("disklog")
	@Expose
	private String disklog;
	@SerializedName("state")
	@Expose
	private String state;
	@SerializedName("state_stamp")
	@Expose
	private String stateStamp;
	@SerializedName("v")
	@Expose
	private String v;
	@SerializedName("reported")
	@Expose
	private String reported;
	@SerializedName("up")
	@Expose
	private String up;
	@SerializedName("up_primary")
	@Expose
	private String upPrimary;
	@SerializedName("acting")
	@Expose
	private String acting;
	@SerializedName("acting_primary")
	@Expose
	private String actingPrim;
	@SerializedName("last_scrub")
	@Expose
	private String lastScrub;
	@SerializedName("scrub_stamp")
	@Expose
	private String scrubStamp;
	@SerializedName("last_deep_scrub")
	@Expose
	private String lastDeepScrub;
	@SerializedName("deep_scrub_stamp")
	@Expose
	private String deepScrubStamp;
	public String getPgStat() {
		return pgStat;
	}
	public void setPgStat(String pgStat) {
		this.pgStat = pgStat;
	}
	public String getObjects() {
		return objects;
	}
	public void setObjects(String objects) {
		this.objects = objects;
	}
	public String getMip() {
		return mip;
	}
	public void setMip(String mip) {
		this.mip = mip;
	}
	public String getDegr() {
		return degr;
	}
	public void setDegr(String degr) {
		this.degr = degr;
	}
	public String getMisp() {
		return misp;
	}
	public void setMisp(String misp) {
		this.misp = misp;
	}
	public String getUnf() {
		return unf;
	}
	public void setUnf(String unf) {
		this.unf = unf;
	}
	public String getBytes() {
		return bytes;
	}
	public void setBytes(String bytes) {
		this.bytes = bytes;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public String getDisklog() {
		return disklog;
	}
	public void setDisklog(String disklog) {
		this.disklog = disklog;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStateStamp() {
		return stateStamp;
	}
	public void setStateStamp(String stateStamp) {
		this.stateStamp = stateStamp;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getReported() {
		return reported;
	}
	public void setReported(String reported) {
		this.reported = reported;
	}
	public String getUp() {
		return up;
	}
	public void setUp(String up) {
		this.up = up;
	}
	public String getUpPrimary() {
		return upPrimary;
	}
	public void setUpPrimary(String upPrimary) {
		this.upPrimary = upPrimary;
	}
	public String getActing() {
		return acting;
	}
	public void setActing(String acting) {
		this.acting = acting;
	}
	public String getActingPrim() {
		return actingPrim;
	}
	public void setActingPrim(String actingPrim) {
		this.actingPrim = actingPrim;
	}
	public String getLastScrub() {
		return lastScrub;
	}
	public void setLastScrub(String lastScrub) {
		this.lastScrub = lastScrub;
	}
	public String getScrubStamp() {
		return scrubStamp;
	}
	public void setScrubStamp(String scrubStamp) {
		this.scrubStamp = scrubStamp;
	}
	public String getLastDeepScrub() {
		return lastDeepScrub;
	}
	public void setLastDeepScrub(String lastDeepScrub) {
		this.lastDeepScrub = lastDeepScrub;
	}
	public String getDeepScrubStamp() {
		return deepScrubStamp;
	}
	public void setDeepScrubStamp(String deepScrubStamp) {
		this.deepScrubStamp = deepScrubStamp;
	}
	
}
