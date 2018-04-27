package com.work.nativies;

import com.work.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName(value = "address")
public class Address {
	public Integer id;
	public String province;
	public String city;
	public String country;

	public Address(Integer id, String province, String city, String country) {
		super();
		this.id = id;
		this.province = province;
		this.city = city;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city=" + city + ", country=" + country + "]";
	}
}
