package com.work.nativies;

import com.work.annotation.TableName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//党组织关系
@Setter
@Getter
@ToString
@TableName(value = "party")
public class Party {

	private Integer id;
	private String partyName;

	public Party(Integer id, String partyName) {
		this.id = id;
		this.partyName = partyName;
	}

	public Party() {
		super();
	}

}
