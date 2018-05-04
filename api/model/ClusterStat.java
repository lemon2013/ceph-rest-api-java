/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年1月7日 下午5:20:17
 *
 */
package com.cn.ipv6cloud.ceph.api.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: ClusterStat
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * @author lemon
 * @date 2018年1月7日
 * 
 */
public class ClusterStat {
	@SerializedName("cluster")
	@Expose
	private String cluster;
	@SerializedName("health")
	@Expose
	private String health;
	@SerializedName("monmap")
	@Expose
	private MonmapInfo monmap=null;
	@SerializedName("osdmap")
	@Expose
	private OsdmapInfo osdmap=null;
	@SerializedName("pgmap")
	@Expose
	private PgmapInfo pgmap=null;
	public String getCluster() {
		return cluster;
	}
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public MonmapInfo getMonmap() {
		return monmap;
	}
	public void setMonmap(MonmapInfo monmap) {
		this.monmap = monmap;
	}
	public OsdmapInfo getOsdmap() {
		return osdmap;
	}
	public void setOsdmap(OsdmapInfo osdmap) {
		this.osdmap = osdmap;
	}
	public PgmapInfo getPgmap() {
		return pgmap;
	}
	public void setPgmap(PgmapInfo pgmap) {
		this.pgmap = pgmap;
	}
	
}
