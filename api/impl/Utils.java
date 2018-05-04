/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年1月5日 下午4:59:55
 *
 */
package com.cn.ipv6cloud.ceph.api.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.amazonaws.util.StringUtils;

/**
 * <p>
 * Title: Utils
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: HUN.lemon
 * </p>
 * 
 * @author lemon
 * @date 2018年1月5日
 * 
 */
public class Utils {
	/**
	 * 
	 * <p>
	 * Title: formatDfToJson
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String formatDfToJson(String str) {
		StringBuffer sb = new StringBuffer("{");
		if (!StringUtils.isNullOrEmpty(str)) {
			String[] arr = str.replaceAll(":", "").split("\n");
			String[] globalT = arr[1].trim().split("\\s{4}");
			String[] globalVal = arr[2].trim().split("\\s+");
			for (int i = 0; i < globalT.length; i++) {
				sb.append('"' + globalT[i].trim() + '"' + ":" + '"' + globalVal[i].trim() + '"' + ',');
			}
			sb.append('"' + arr[3].trim() + '"' + ":[");
			String[] poolsT = arr[4].trim().split("\\s{2,}");
			for (int i = 5; i < arr.length; i++) {
				String[] poolVal = arr[i].trim().split("\\s{2,}");
				sb.append('{');
				for (int j = 0; j < poolsT.length; j++) {
					sb.append('"' + poolsT[j].trim() + '"' + ":" + '"' + poolVal[j].trim() + '"' + ',');
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append("},");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("]}");
		}
		return sb.toString();
	}

	/**
	 * 
	 * <p>
	 * Title: formatClusterStatToJson
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String formatClusterStatToJson(String str) {
		StringBuffer sb = new StringBuffer("{");
		if (!StringUtils.isNullOrEmpty(str)) {
			String formatStr = str.replaceAll("\n", "  ");
			String pattern = "cluster(.*?)health(.*?)monmap(.*?)osdmap(.*?)pgmap(.*?)";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(formatStr);
			if (m.matches()) {
				sb.append('"' + "cluster" + '"' + ":" + '"' + m.group(1).trim() + '"' + ',');
				sb.append('"' + "health" + '"' + ":" + '"' + m.group(2).trim() + '"' + ',');
				String monmap = m.group(3).trim();
				String monpatt = "(.*?):\\s([0-9]*)\\smons\\sat\\s(.*?)election\\sepoch\\s([0-9]*),\\squorum(.*?)";
				Pattern rmon = Pattern.compile(monpatt);
				Matcher mon = rmon.matcher(monmap);
				if (mon.matches()) {
					sb.append('"' + "monmap" + '"' + ":{" + '"' + "name" + '"' + ":" + '"' + mon.group(1).trim() + '"'
							+ ",");
					sb.append('"' + "number" + '"' + ":" + '"' + mon.group(2).trim() + '"' + ",");
					String[] monlst = mon.group(3).replaceAll("\\{", "").replaceAll("\\}", "").trim().split(",");
					sb.append('"' + "mons" + '"' + ":[");
					int index = 0;
					for (String item : monlst) {
						sb.append("{" + '"' + "index" + '"' + ":" + '"' + index + '"' + "," + '"' + "name" + '"' + ":"
								+ '"' + item + '"' + "},");
						index++;
					}
					sb.deleteCharAt(sb.length() - 1);
					sb.append("],");
					sb.append('"' + "election_epoch" + '"' + ":" + '"' + mon.group(4).trim() + '"' + ",");
					String[] nodesinfo = mon.group(5).trim().split("\\s{1,}");
					String[] ids = nodesinfo[0].split(",");
					String[] nodes = nodesinfo[1].split(",");
					sb.append('"' + "nodes" + '"' + ":[");
					for (int i = 0; i < ids.length; i++) {
						sb.append("{" + '"' + "id" + '"' + ":" + '"' + ids[i] + '"' + "," + '"' + "node" + '"' + ":"
								+ '"' + nodes[i] + '"' + "},");
					}
					sb.deleteCharAt(sb.length() - 1);
					sb.append("]}");
				}
				String osdmap = m.group(4).trim();
				String osdpatt = "(.*?):\\s([0-9]*)\\sosds:\\s([0-9]*)\\sup,\\s([0-9]*)\\sin";
				Pattern rosd = Pattern.compile(osdpatt);
				Matcher osd = rosd.matcher(osdmap);
				sb.append("," + '"' + "osdmap" + '"' + ":");
				if (osd.matches()) {
					sb.append("{" + '"' + "name" + '"' + ":" + '"' + osd.group(1).trim() + '"');
					sb.append("," + '"' + "osd_num" + '"' + ":" + '"' + osd.group(2).trim() + '"');
					sb.append("," + '"' + "up_num" + '"' + ":" + '"' + osd.group(3).trim() + '"');
					sb.append("," + '"' + "in_num" + '"' + ":" + '"' + osd.group(4).trim() + '"' + "}");
				}
				String pgmap = m.group(5).trim();
				String pgpatt = "(.*?):\\s([0-9]*)\\spgs,\\s([0-9]*)\\spools,\\s(.*?)\\sdata,\\s(.*?)\\sobjects\\s(.*?)used,(.*?)avail\\s(.*?)";
				Pattern rpg = Pattern.compile(pgpatt);
				Matcher pg = rpg.matcher(pgmap);
				sb.append("," + '"' + "pgmap" + '"' + ":");
				if (pg.matches()) {
					sb.append("{" + '"' + "name" + '"' + ":" + '"' + pg.group(1).trim() + '"');
					sb.append("," + '"' + "pg_num" + '"' + ":" + '"' + pg.group(2).trim() + '"');
					sb.append("," + '"' + "pool_num" + '"' + ":" + '"' + pg.group(3).trim() + '"');
					sb.append("," + '"' + "data" + '"' + ":" + '"' + pg.group(4).trim() + '"');
					sb.append("," + '"' + "objects" + '"' + ":" + '"' + pg.group(5).trim() + '"');
					sb.append("," + '"' + "used" + '"' + ":" + '"' + pg.group(6).trim() + '"');
					sb.append("," + '"' + "avail" + '"' + ":" + '"' + pg.group(7).trim() + '"');
					sb.append("," + '"' + "pg_detail" + '"' + ":" + '"' + pg.group(8).trim() + '"' + "}}");
				}

			}

		}
		return sb.toString();
	}

	/**
	 * 
	 * <p>
	 * Title: formatVersion
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String formatVersion(String str) {
		StringBuffer sb = new StringBuffer("");
		String pattern = "ceph\\sversion\\s(.*?)\\(.*?";
		Pattern v = Pattern.compile(pattern);
		Matcher version = v.matcher(str.trim());
		if (version.matches()) {
			sb.append(version.group(1).trim());
		}
		return sb.toString();
	}

	/**
	 * 
	 * <p>
	 * Title: formatPoolsStatToJson
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String formatPoolsStatToJson(String str) {
		StringBuffer sb = new StringBuffer("{" + '"' + "pools_stat" + '"' + ':' + str + "}");
		return sb.toString();
	}

	public static String formatPoolStatToJson(String str) {
		String formatStr = str.replaceAll("\n", "  ");
		// String formatStr = "pool .rgw.buckets id 9 client io 2157 B/s wr, 4 op/s";
		StringBuffer sb = new StringBuffer("{");
		String nothpatt = "(.*)nothing\\sis\\sgoing\\son(.*)";
		String rwo = "(.*)client\\sio(.*)/s\\srd,(.*)/s\\swr,(.*)/s(.*)";
		String wo = "(.*)client\\sio(.*)/s\\swr,(.*)/s(.*)";
		String ro = "(.*)client\\sio(.*)/s\\srd,(.*)/s(.*)";
		Pattern rno = Pattern.compile(nothpatt);
		Matcher no = rno.matcher(formatStr);
		Pattern rwoy = Pattern.compile(rwo);
		Matcher y = rwoy.matcher(formatStr);
		Pattern wop = Pattern.compile(wo);
		Matcher wom = wop.matcher(formatStr);
		Pattern rop = Pattern.compile(ro);
		Matcher rom = rop.matcher(formatStr);
		if (no.matches()) {
			sb.append('"' + "rd" + '"' + ":0," + '"' + "wr" + '"' + ":0," + '"' + "op" + '"' + ":0}");
		} else if (y.matches()) {
			sb.append('"' + "rd" + '"' + ":" + formatSpeed(y.group(2).trim()) + "," + '"' + "wr" + '"' + ":"
					+ formatSpeed(y.group(3).trim()) + "," + '"' + "op" + '"' + ":" + formatSpeed(y.group(4).trim())
					+ "}");
		} else if (wom.matches()) {
			sb.append('"' + "rd" + '"' + ":0," + '"' + "wr" + '"' + ":" + formatSpeed(wom.group(2).trim()) + "," + '"'
					+ "op" + '"' + ":" + formatSpeed(wom.group(3).trim()) + "}");
		} else if (rom.matches()) {
			sb.append('"' + "rd" + '"' + ":" + formatSpeed(rom.group(2).trim()) + "," + '"' + "wr" + '"' + ":0," + '"'
					+ "op" + '"' + ":" + formatSpeed(rom.group(3).trim()) + "}");
		}
		return sb.toString();
	}

	/**
	 * 
	 * <p>
	 * Title: formatSpeed
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String formatSpeed(String str) {
		String nstr = "";
		if (isNumeric(str.replace("B", "").trim())) {
			nstr = "" + Integer.parseInt(str.replace("B", "").trim()) / 1024;
		}
		if (str.contains("k")) {
			int speed = Integer.parseInt(str.replace("kB", "").trim());
			nstr = "" + speed;
		} else if (str.contains("M")) {
			int speed = Integer.parseInt(str.replace("MB", "").trim()) * 1024;
			nstr = "" + speed;
		}
		if (str.contains("op")) {
			nstr = str.replace("op", "").trim();
		}
		return nstr;
	}

	/**
	 * 
	 * <p>
	 * Title: isNumeric
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 
	 * <p>
	 * Title: formatOSDUse
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static String formatOSDUseToJson(String str) {
		StringBuffer sb = new StringBuffer("{" + '"' + "osd_utilization" + '"' + ":" + "[");
		String[] strArr = str.split("\n");
		if (strArr.length > 3) {
			for (int i = 1; i < strArr.length - 2; i++) {
				String[] osdinfo = strArr[i].trim().split("\\s{1,}");
				sb.append("{" + '"' + "ID" + '"' + ":" + osdinfo[0] + ",");
				sb.append('"' + "WEIGHT" + '"' + ":" + osdinfo[1] + ",");
				sb.append('"' + "REWEIGHT" + '"' + ":" + osdinfo[2] + ",");
				sb.append('"' + "SIZE" + '"' + ":" + osdinfo[3] + ",");
				sb.append('"' + "USE" + '"' + ":" + osdinfo[4] + ",");
				sb.append('"' + "AVAIL" + '"' + ":" + osdinfo[5] + ",");
				sb.append('"' + "%USE" + '"' + ":" + osdinfo[6] + ",");
				sb.append('"' + "VAR" + '"' + ":" + osdinfo[7] + "},");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("]}");
		}
		return sb.toString();
	}

	public static String formatPGByOSD(String str, String id) {
		StringBuffer sb = new StringBuffer(
				"{" + '"' + "osd_id" + '"' + ":" + id + "," + '"' + "pg_osd" + '"' + ":" + "[");
		String[] strArr = str.split("\n");
		if (strArr.length > 1) {
			for (int i = 1; i < strArr.length; i++) {
				String[] osdinfo = strArr[i].trim().split("\\t");
				if (osdinfo.length == 21) {
					sb.append("{" + '"' + "pg_stat" + '"' + ":" + '"' + osdinfo[0] + '"' + ",");
					sb.append('"' + "objects" + '"' + ":" + '"' + osdinfo[1] + '"' + ",");
					sb.append('"' + "mip" + '"' + ":" + '"' + osdinfo[2] + '"' + ",");
					sb.append('"' + "degr" + '"' + ":" + '"' + osdinfo[3] + '"' + ",");
					sb.append('"' + "misp" + '"' + ":" + '"' + osdinfo[4] + '"' + ",");
					sb.append('"' + "unf" + '"' + ":" + '"' + osdinfo[5] + '"' + ",");
					sb.append('"' + "bytes" + '"' + ":" + '"' + osdinfo[6] + '"' + ",");
					sb.append('"' + "log" + '"' + ":" + '"' + osdinfo[7] + '"' + ",");
					sb.append('"' + "disklog" + '"' + ":" + '"' + osdinfo[8] + '"' + ",");
					sb.append('"' + "state" + '"' + ":" + '"' + osdinfo[9] + '"' + ",");
					sb.append('"' + "state_stamp" + '"' + ":" + '"' + osdinfo[10] + '"' + ",");
					sb.append('"' + "v" + '"' + ":" + '"' + osdinfo[11] + '"' + ",");
					sb.append('"' + "reported" + '"' + ":" + '"' + osdinfo[12] + '"' + ",");
					sb.append('"' + "up" + '"' + ":" + '"' + osdinfo[13] + '"' + ",");
					sb.append('"' + "up_primary" + '"' + ":" + '"' + osdinfo[14] + '"' + ",");
					sb.append('"' + "acting" + '"' + ":" + '"' + osdinfo[15] + '"' + ",");
					sb.append('"' + "acting_primary" + '"' + ":" + osdinfo[16] + ",");
					sb.append('"' + "last_scrub" + '"' + ":" + '"' + osdinfo[17] + '"' + ",");
					sb.append('"' + "scrub_stamp" + '"' + ":" + '"' + osdinfo[18] + '"' + ",");
					sb.append('"' + "last_deep_scrub" + '"' + ":" + '"' + osdinfo[19] + '"' + ",");
					sb.append('"' + "deep_scrub_stamp" + '"' + ":" + '"' + osdinfo[20] + '"' + "},");
				}
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("]}");
		}
		return sb.toString();
	}
	public static String formatOSDPerf(String str) {
		StringBuffer sb = new StringBuffer(
				"{" + '"' + "osd_commit_apply" + '"' + ":"  + "[");
		String[] strArr = str.split("\n");
		
		if (strArr.length > 1) {
			for (int i = 1; i < strArr.length; i++) {
				String[] osdinfo = strArr[i].trim().split("\\s{1,}");
				if (osdinfo.length == 3) {
					sb.append("{" + '"' + "osd_id" + '"' + ":" + '"' + osdinfo[0] + '"' + ",");
					sb.append('"' + "fs_commit_latency" + '"' + ":" + '"' + osdinfo[1] + '"' + ",");
					sb.append('"' + "fs_apply_latency" + '"' + ":" + '"' + osdinfo[2] + '"' + "},");
				}
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("]}");
		}
		return sb.toString();
	}
	public static String formatOSDTree(String str) {
		return str;
	}
}
