package com.work.nativies;

import com.work.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName(value = "rank")
public class Rank {
	private Integer id;
	private String rankName;
	
	public Rank(Integer id, String rankName) {
		this.id = id;
		this.rankName = rankName;
	}
	public Rank() {
		super();
	}
	@Override
	public String toString() {
		return "Rank [id=" + id + ", rankName=" + rankName + "]";
	}
	

}
