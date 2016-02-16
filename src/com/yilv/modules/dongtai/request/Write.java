package com.yilv.modules.dongtai.request;

import java.util.List;

import com.yilv.base.common.entity.BaseEntity;

public class Write extends BaseEntity<Write> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;
	private String position;
	private String range;
	private List<String> images;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

}
