package com.example.demo.domain;

import java.io.Serializable;
public class City implements Serializable{
    @Override
	public String toString() {
		return "City [id=" + id + ", provinceId=" + provinceId + ", cityName=" + cityName + ", description="
				+ description + "]";
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(int id, int provinceId, String cityName, String description) {
		super();
		this.id = id;
		this.provinceId = provinceId;
		this.cityName = cityName;
		this.description = description;
	}

	/**
     * 城市编号
     */
    private int id;

    /**
     * 省份编号
     */
    private int provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
