/**
 *  Copyright (C) 2018 HUN.lemon. All right reserved.
 *
 *  
 *  https://lemon2013.github.io
 *
 *  created on 2018年3月10日 上午10:28:16
 *
 */
package com.cn.ipv6cloud.ceph.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Title: PoolStatSum
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
public class PoolStatSum {
	@SerializedName("num_bytes")
	@Expose
	private long numBytes;
	@SerializedName("num_objects")
	@Expose
	private long numObj;
	@SerializedName("num_bytes_clones")
	@Expose
	private long numBytesClones;
	@SerializedName("num_object_copies")
	@Expose
	private long numObjCopies;
	@SerializedName("num_objects_missing_on_primary")
	@Expose
	private long numObjMissPrimary;
	@SerializedName("num_objects_degraded")
	@Expose
	private long numObjDegraded;
	@SerializedName("num_objects_misplaced")
	@Expose
	private long numObjMisplaced;
	@SerializedName("num_objects_unfound")
	@Expose
	private long numObjUnfound;
	@SerializedName("num_objects_dirty")
	@Expose
	private long numObjDirty;
	@SerializedName("num_whiteouts")
	@Expose
	private long numWhiteouts;
	@SerializedName("num_read")
	@Expose
	private long numRead;
	@SerializedName("num_read_kb")
	@Expose
	private long numReadKB;
	@SerializedName("num_write")
	@Expose
	private long numWrite;
	@SerializedName("num_write_kb")
	@Expose
	private long numWriteKB;
	@SerializedName("num_scrub_errors")
	@Expose
	private long numScrubErr;
	@SerializedName("num_shallow_scrub_errors")
	@Expose
	private long numShallowScrubErr;
	@SerializedName("num_deep_scrub_errors")
	@Expose
	private long numDeepScrubErr;
	@SerializedName("num_objects_recovered")
	@Expose
	private long numObjRecovered;
	@SerializedName("num_bytes_recovered")
	@Expose
	private long numBytesRecovered;
	@SerializedName("num_keys_recovered")
	@Expose
	private long numKeysRecovered;
	@SerializedName("num_objects_omap")
	@Expose
	private long numObjOmap;
	@SerializedName("num_objects_hit_set_archive")
	@Expose
	private long numObjHitSetArch;
	@SerializedName("num_bytes_hit_set_archive")
	@Expose
	private long numBytesHitSetArch;
	public long getNumBytes() {
		return numBytes;
	}
	public void setNumBytes(long numBytes) {
		this.numBytes = numBytes;
	}
	public long getNumObj() {
		return numObj;
	}
	public void setNumObj(long numObj) {
		this.numObj = numObj;
	}
	public long getNumBytesClones() {
		return numBytesClones;
	}
	public void setNumBytesClones(long numBytesClones) {
		this.numBytesClones = numBytesClones;
	}
	public long getNumObjCopies() {
		return numObjCopies;
	}
	public void setNumObjCopies(long numObjCopies) {
		this.numObjCopies = numObjCopies;
	}
	public long getNumObjMissPrimary() {
		return numObjMissPrimary;
	}
	public void setNumObjMissPrimary(long numObjMissPrimary) {
		this.numObjMissPrimary = numObjMissPrimary;
	}
	public long getNumObjDegraded() {
		return numObjDegraded;
	}
	public void setNumObjDegraded(long numObjDegraded) {
		this.numObjDegraded = numObjDegraded;
	}
	public long getNumObjMisplaced() {
		return numObjMisplaced;
	}
	public void setNumObjMisplaced(long numObjMisplaced) {
		this.numObjMisplaced = numObjMisplaced;
	}
	public long getNumObjUnfound() {
		return numObjUnfound;
	}
	public void setNumObjUnfound(long numObjUnfound) {
		this.numObjUnfound = numObjUnfound;
	}
	public long getNumObjDirty() {
		return numObjDirty;
	}
	public void setNumObjDirty(long numObjDirty) {
		this.numObjDirty = numObjDirty;
	}
	public long getNumWhiteouts() {
		return numWhiteouts;
	}
	public void setNumWhiteouts(long numWhiteouts) {
		this.numWhiteouts = numWhiteouts;
	}
	public long getNumRead() {
		return numRead;
	}
	public void setNumRead(long numRead) {
		this.numRead = numRead;
	}
	public long getNumReadKB() {
		return numReadKB;
	}
	public void setNumReadKB(long numReadKB) {
		this.numReadKB = numReadKB;
	}
	public long getNumWrite() {
		return numWrite;
	}
	public void setNumWrite(long numWrite) {
		this.numWrite = numWrite;
	}
	public long getNumWriteKB() {
		return numWriteKB;
	}
	public void setNumWriteKB(long numWriteKB) {
		this.numWriteKB = numWriteKB;
	}
	public long getNumScrubErr() {
		return numScrubErr;
	}
	public void setNumScrubErr(long numScrubErr) {
		this.numScrubErr = numScrubErr;
	}
	public long getNumShallowScrubErr() {
		return numShallowScrubErr;
	}
	public void setNumShallowScrubErr(long numShallowScrubErr) {
		this.numShallowScrubErr = numShallowScrubErr;
	}
	public long getNumDeepScrubErr() {
		return numDeepScrubErr;
	}
	public void setNumDeepScrubErr(long numDeepScrubErr) {
		this.numDeepScrubErr = numDeepScrubErr;
	}
	public long getNumObjRecovered() {
		return numObjRecovered;
	}
	public void setNumObjRecovered(long numObjRecovered) {
		this.numObjRecovered = numObjRecovered;
	}
	public long getNumBytesRecovered() {
		return numBytesRecovered;
	}
	public void setNumBytesRecovered(long numBytesRecovered) {
		this.numBytesRecovered = numBytesRecovered;
	}
	public long getNumKeysRecovered() {
		return numKeysRecovered;
	}
	public void setNumKeysRecovered(long numKeysRecovered) {
		this.numKeysRecovered = numKeysRecovered;
	}
	public long getNumObjOmap() {
		return numObjOmap;
	}
	public void setNumObjOmap(long numObjOmap) {
		this.numObjOmap = numObjOmap;
	}
	public long getNumObjHitSetArch() {
		return numObjHitSetArch;
	}
	public void setNumObjHitSetArch(long numObjHitSetArch) {
		this.numObjHitSetArch = numObjHitSetArch;
	}
	public long getNumBytesHitSetArch() {
		return numBytesHitSetArch;
	}
	public void setNumBytesHitSetArch(long numBytesHitSetArch) {
		this.numBytesHitSetArch = numBytesHitSetArch;
	}
	
}
