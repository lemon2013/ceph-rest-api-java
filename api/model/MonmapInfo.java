/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年1月7日 下午5:21:24
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: MonmapInfo
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
public class MonmapInfo {
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("number")
	@Expose
	private String number;
	@SerializedName("mons")
	@Expose
	private List<MonInfo> mons=null;
	@SerializedName("election_epoch")
	@Expose
	private String electionEpoch;
	@SerializedName("nodes")
	@Expose
	private List<NodeInfo> nodes=null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public List<MonInfo> getMons() {
		return mons;
	}
	public void setMons(List<MonInfo> mons) {
		this.mons = mons;
	}
	public String getElectionEpoch() {
		return electionEpoch;
	}
	public void setElectionEpoch(String electionEpoch) {
		this.electionEpoch = electionEpoch;
	}
	public List<NodeInfo> getNodes() {
		return nodes;
	}
	public void setNodes(List<NodeInfo> nodes) {
		this.nodes = nodes;
	}
	
}
