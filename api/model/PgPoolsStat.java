/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月10日 上午10:22:40
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: PGPoolInfo
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
public class PgPoolsStat {
	@SerializedName("pools_stat")
	@Expose
	private List<PoolStat> poolsStat=null;

	public List<PoolStat> getPoolsStat() {
		return poolsStat;
	}

	public void setPoolsStat(List<PoolStat> poolsStat) {
		this.poolsStat = poolsStat;
	}
}
