/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月10日 上午10:25:29
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: PoolInfo
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * @author lemon
 * @date 2018年3月10日
 * 
 */
public class PoolStat {
	@SerializedName("poolid")
	@Expose
	private String poolID;
	@SerializedName("stat_sum")
	@Expose
	private PoolStatSum statSum;
	@SerializedName("log_size")
	@Expose
	private int logSize;
	@SerializedName("ondisk_log_size")
	@Expose
	private int ondiskLogSize;
	@SerializedName("up")
	@Expose
	private int up;
	@SerializedName("acting")
	@Expose
	private int actiong;
	public String getPoolID() {
		return poolID;
	}
	public void setPoolID(String poolID) {
		this.poolID = poolID;
	}
	public PoolStatSum getStatSum() {
		return statSum;
	}
	public void setStatSum(PoolStatSum statSum) {
		this.statSum = statSum;
	}
	public int getLogSize() {
		return logSize;
	}
	public void setLogSize(int logSize) {
		this.logSize = logSize;
	}
	public int getOndiskLogSize() {
		return ondiskLogSize;
	}
	public void setOndiskLogSize(int ondiskLogSize) {
		this.ondiskLogSize = ondiskLogSize;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public int getActiong() {
		return actiong;
	}
	public void setActiong(int actiong) {
		this.actiong = actiong;
	}
}
