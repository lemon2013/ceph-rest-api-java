/**
 *  Copyright (C) 2017 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2017年12月26日 下午5:09:14
 *
 */
package com.cn.ipv6cloud.ceph.api.impl;


import com.cn.ipv6cloud.ceph.api.CephAPI;
import com.cn.ipv6cloud.ceph.api.model.ClusterStat;
import com.cn.ipv6cloud.ceph.api.model.Df;
import com.cn.ipv6cloud.ceph.api.model.OSDLocation;
import com.cn.ipv6cloud.ceph.api.model.OSDPerf;
import com.cn.ipv6cloud.ceph.api.model.OSDsUti;
import com.cn.ipv6cloud.ceph.api.model.PGsOSD;
import com.cn.ipv6cloud.ceph.api.model.PgPoolsStat;
import com.cn.ipv6cloud.ceph.api.model.PoolRWO;
import com.cn.tbmsm.util.ConstantsUtil;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * Title: CephAPIImpl
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * @author lemon
 * @date 2017年12月26日
 * 
 */
public class CephAPIImpl implements CephAPI{
	private static final Gson gson = new Gson();
	private String apiurl;
	OkHttpClient httpClient;
	public CephAPIImpl(String url) {
		apiurl = url;
		httpClient = new OkHttpClient();
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getHealth
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getHealth()
	 */
	@Override
	public String getHealth() {
		return call("health");
	}
	public static void main(String[] args) throws IOException {
		CephAPI api = new CephAPIImpl(ConstantsUtil.CEPH_REST_API);
		System.out.println(api.getPGPoolsInfo());
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getDf
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getDf()
	 */
	@Override
	public Df getDf() {
		String response = call("df");
		String json = Utils.formatDfToJson(response);
		return gson.fromJson(json, Df.class);
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getOSDTree
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getOSDTree()
	 */
	@Override
	public String getOSDTree() {
		String str = call("osd/tree");
		String json = Utils.formatOSDTree(str);
		return json;
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getFSID
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getFSID()
	 */
	@Override
	public String getFSID() {
		return call("fsid");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getDumpInfo
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getDumpInfo()
	 */
	@Override
	public String getDumpInfo() {
		return call("mds/dump");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getMDSStat
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getMDSStat()
	 */
	@Override
	public String getMDSStat() {
		return call("mds/stat");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getMONStat
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getMONStat()
	 */
	@Override
	public String getMONStat() {
		return call("mon/stat");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getMONStatReport
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getMONStatReport()
	 */
	@Override
	public String getMONStatReport() {
		return call("mon_status");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getOSDUtilization
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getOSDUtilization()
	 */
	@Override
	public OSDsUti getOSDUtilization() {
		String str = call("osd/df");
		String json = Utils.formatOSDUseToJson(str);
		return gson.fromJson(json, OSDsUti.class);
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getOSDDump
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getOSDDump()
	 */
	@Override
	public String getOSDDump() {
		return call("osd/dump");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getOSDLocation
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @param id
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getOSDLocation(int)
	 */
	@Override
	public OSDLocation getOSDLocation(int id) {
		String str = call("osd/find?id="+id);
		String json =str.replaceAll("\n", "");
		json = json.replaceAll("\\s{1,}", "");
		return gson.fromJson(json, OSDLocation.class);
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getMaxOSD
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getMaxOSD()
	 */
	@Override
	public String getMaxOSD() {
		return call("osd/getmaxosd");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getOSDLst
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getOSDLst()
	 */
	@Override
	public List<String> getOSDLst() {
		List<String> lst = new ArrayList<String>();
		String str = call("osd/ls");
		if(str.trim().length()>0) {
			String[] arr = str.split("\n");
			for(String item:arr) {
				lst.add(item);
			}
		}
		return lst;
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getPoolLst
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getPoolLst()
	 */
	@Override
	public String getPoolLst() {
		return call("osd/lspools");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getOSDMetadata
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @param id
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getOSDMetadata(int)
	 */
	@Override
	public String getOSDMetadata(int id) {
		return call("osd/metadata?id="+id);
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getOSDPerfSummary
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getOSDPerfSummary()
	 */
	@Override
	public OSDPerf getOSDPerfSummary() {
		String json = Utils.formatOSDPerf(call("osd/perf"));
		return gson.fromJson(json, OSDPerf.class);
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getOSDBasicUtilization
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getOSDBasicUtilization()
	 */
	@Override
	public String getOSDBasicUtilization() {
		return call("osd/utilization");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getPGPoolsInfo
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getPGPoolsInfo()
	 */
	@Override
	public PgPoolsStat getPGPoolsInfo() {
		String str = call("pg/dump_pools_json");
		String json = Utils.formatPoolsStatToJson(str);
		return gson.fromJson(json, PgPoolsStat.class);
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getPGStat
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getPGStat()
	 */
	@Override
	public String getPGStat() {
		return call("pg/stat");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: call
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @param url
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#call(java.lang.String)
	 */
	@Override
	public String call(String url) {
		Request request = new Request.Builder()
                .url(apiurl+url)
                .build();
        Response response;
		try {
			response = httpClient.newCall(request).execute();
	        ResponseBody body = response.body();
	        return body.string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getClusterStat
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getClusterStat()
	 */
	@Override
	public ClusterStat getClusterStat() {
		String str = call("status");
		String json = Utils.formatClusterStatToJson(str.trim());
		return gson.fromJson(json, ClusterStat.class);
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getVersion
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getVersion()
	 */
	@Override
	public String getVersion() {
		String str = call("version");
		return Utils.formatVersion(str);
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getOSDVersion
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @param id
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getOSDVersion(int)
	 */
	@Override
	public String getOSDVersion(int id) {
		return call("tell/"+id+"/version");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getReport
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @param tag
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getReport(java.lang.String)
	 */
	@Override
	public String getReport() {
		return call("report");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getReport
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @param tag
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getReport(java.lang.String)
	 */
	@Override
	public String getReport(String tag) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getPGDump
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getPGDump()
	 */
	@Override
	public String getPGDump() {
		return call("pg/dump_json");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getOSDCrushDump
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getOSDCrushDump()
	 */
	@Override
	public String getOSDCrushDump() {
		// TODO Auto-generated method stub
		return call("osd/crush/dump");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getPoolStats
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getPoolStats()
	 */
	@Override
	public String getPoolStats() {
		return call("osd/pool/stats");
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getPoolStats
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @param name
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getPoolStats(java.lang.String)
	 */
	@Override
	public PoolRWO getPoolStats(String name) {
		String str = call("osd/pool/stats?name="+name);
		String json = Utils.formatPoolStatToJson(str);
		return gson.fromJson(json, PoolRWO.class);
	}
	/* (non-Javadoc)
	 * <p>
	 * Title: getPgByOSD
	 * </p>
	 * <p>
	 * Description: 
	 * </p>
	 * @param name
	 * @return
	 * @see com.cn.ipv6cloud.ceph.api.CephAPI#getPgByOSD(java.lang.String)
	 */
	@Override
	public PGsOSD getPgByOSD(String name) {
		String str = call("pg/ls-by-osd?osd="+name);
		String json = Utils.formatPGByOSD(str, name);
		return gson.fromJson(json, PGsOSD.class);
	}
}
