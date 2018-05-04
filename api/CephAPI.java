/**
 *  Copyright (C) 2017 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2017年12月26日 下午5:05:23
 *
 */
package com.cn.ipv6cloud.ceph.api;

import java.util.List;

import com.cn.ipv6cloud.ceph.api.model.ClusterStat;
import com.cn.ipv6cloud.ceph.api.model.Df;
import com.cn.ipv6cloud.ceph.api.model.OSDLocation;
import com.cn.ipv6cloud.ceph.api.model.OSDPerf;
import com.cn.ipv6cloud.ceph.api.model.OSDsUti;
import com.cn.ipv6cloud.ceph.api.model.PGsOSD;
import com.cn.ipv6cloud.ceph.api.model.PgPoolsStat;
import com.cn.ipv6cloud.ceph.api.model.PoolRWO;

/**
 * <p>
 * Title: CephAPI
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * 
 * @author lemon
 * @date 2017年12月26日
 * 
 */
public interface CephAPI {
	/**
	 * 
	 * <p>
	 * Title: getHealth
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	String getHealth();

	/**
	 * 
	 * <p>
	 * Title: getDf
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	Df getDf();

	/**
	 * 
	 * <p>
	 * Title: getOSDTree
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	String getOSDTree();

	/**
	 * 
	 * <p>
	 * Title: getFSID
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	String getFSID();

	/**
	 * 
	 * <p>
	 * Title: getDumpInfo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	String getDumpInfo();

	/**
	 * 
	 * <p>
	 * Title: getMDSStat
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	String getMDSStat();

	/**
	 * 
	 * <p>
	 * Title: getMONStat
	 * </p>
	 * <p>
	 * Description: summarize monitor status
	 * </p>
	 * 
	 * @return
	 */
	String getMONStat();

	/**
	 * 
	 * <p>
	 * Title: getMONStatReport
	 * </p>
	 * <p>
	 * Description: report status of monitors
	 * </p>
	 * 
	 * @return
	 */
	String getMONStatReport();

	/**
	 * 
	 * <p>
	 * Title: getOSDUtilization
	 * </p>
	 * <p>
	 * Description: show OSD utilization
	 * </p>
	 * 
	 * @return
	 */
	OSDsUti getOSDUtilization();
	/**
	 * 
	 * <p>
	 * Title: getOSDBasicUtilization
	 * </p>
	 * <p>
	 * Description: get basic pg distribution stats
	 * </p>
	 * @return
	 */
	String getOSDBasicUtilization();

	/**
	 * 
	 * <p>
	 * Title: getOSDDump
	 * </p>
	 * <p>
	 * Description: print summary of OSD map
	 * </p>
	 * 
	 * @return
	 */
	String getOSDDump();

	/**
	 * 
	 * <p>
	 * Title: getOSDLocation
	 * </p>
	 * <p>
	 * Description: find osd <id> in the CRUSH map and show its location
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	OSDLocation getOSDLocation(int id);
	/**
	 * 
	 * <p>
	 * Title: getMaxOSD
	 * </p>
	 * <p>
	 * Description: show largest OSD id
	 * </p>
	 * @return
	 */
	String getMaxOSD();
	/**
	 * 
	 * <p>
	 * Title: getOSDLst
	 * </p>
	 * <p>
	 * Description: show all OSD ids
	 * </p>
	 * @return
	 */
	List<String> getOSDLst();
	/**
	 * 
	 * <p>
	 * Title: getPoolLst
	 * </p>
	 * <p>
	 * Description: list pools
	 * </p>
	 * @return
	 */
	String getPoolLst();
	/**
	 * 
	 * <p>
	 * Title: getOSDMetadata
	 * </p>
	 * <p>
	 * Description: fetch metadata for osd <id>
	 * </p>
	 * @param id
	 * @return
	 */
	String getOSDMetadata(int id);
	/**
	 * 
	 * <p>
	 * Title: getOSDPerfSummary
	 * </p>
	 * <p>
	 * Description: print dump of OSD perf summary stats
	 * </p>
	 * @return
	 */
	OSDPerf getOSDPerfSummary();
	/**
	 * 
	 * <p>
	 * Title: getPGPoolsInfo
	 * </p>
	 * <p>
	 * Description: show pg pools info in json only
	 * </p>
	 * @return
	 */
	PgPoolsStat getPGPoolsInfo();
	/**
	 * 
	 * <p>
	 * Title: getPGDump
	 * </p>
	 * <p>
	 * Description: show human-readable version of pg map in json only
	 * </p>
	 * @return
	 */
	String getPGDump();
	/**
	 * 
	 * <p>
	 * Title: getPGStat
	 * </p>
	 * <p>
	 * Description: show placement group status.
	 * </p>
	 * @return
	 */
	String getPGStat();
	/**
	 * 
	 * <p>
	 * Title: call
	 * </p>
	 * <p>
	 * Description: public method for client call
	 * </p>
	 * @param url
	 * @return
	 */
	String call(String url);
	/**
	 * 
	 * <p>
	 * Title: getClusterStat
	 * </p>
	 * <p>
	 * Description: show cluster status
	 * </p>
	 * @return
	 */
	ClusterStat getClusterStat();
	/**
	 * 
	 * <p>
	 * Title: getVersion
	 * </p>
	 * <p>
	 * Description: show mon daemon version
	 * </p>
	 * @return
	 */
	String getVersion();
	/**
	 * 
	 * <p>
	 * Title: getOSDVersion
	 * </p>
	 * <p>
	 * Description: report version of OSD
	 * </p>
	 * @param id osdid or pgid
	 * @return
	 */
	String getOSDVersion(int id);
	/**
	 * 
	 * <p>
	 * Title: getReport
	 * </p>
	 * <p>
	 * Description: report full status of cluster, optional title tag strings
	 * </p>
	 * @param tag
	 * @return
	 */
	String getReport(String tag);
	/**
	 * 
	 * <p>
	 * Title: getReport
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 */
	String getReport();
	/**
	 * 
	 * <p>
	 * Title: getOSDCrushDump
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 */
	String getOSDCrushDump();
	/**
	 * 
	 * <p>
	 * Title: getPoolStats
	 * </p>
	 * <p>
	 * Description: obtain stats from all pools
	 * </p>
	 * @return
	 */
	String getPoolStats();
	/**
	 * 
	 * <p>
	 * Title: getPoolStats
	 * </p>
	 * <p>
	 * Description: obtain stats from specified pool
	 * </p>
	 * @param name
	 * @return
	 */
	PoolRWO getPoolStats(String name);
	/**
	 * 
	 * <p>
	 * Title: getPgByOSD
	 * </p>
	 * <p>
	 * Description: list pg on osd [osd]
	 * </p>
	 * @param name
	 * @return
	 */
	PGsOSD getPgByOSD(String name);
}
