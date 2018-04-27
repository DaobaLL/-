package com.work.nativies;

import java.util.Date;

import com.work.annotation.TableName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//人员基本信息类
@Setter
@Getter
@TableName(value = "person")

public class Person {
	private Long       id;
	private String     name;
	private Date       birthday;
	private Long 	   id_rank;
	private Long       id_party;
	private Long       id_address;      //地址
	private Date       militaryTime; //入伍时间
	private String     gend;         //性别	
	private Date       partyTime;
	private String     remark;       //备注
	

	public Person() {
		super();
	}


	public Person(Long id, String name, Date birthday, Long id_rank, Long id_party, Long id_address, Date militaryTime,
			String gend, Date partyTime, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.id_rank = id_rank;
		this.id_party = id_party;
		this.id_address = id_address;
		this.militaryTime = militaryTime;
		this.gend = gend;
		this.partyTime = partyTime;
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthday=" + birthday + ", id_rank=" + id_rank + ", id_party="
				+ id_party + ", id_address=" + id_address + ", militaryTime=" + militaryTime + ", gend=" + gend
				+ ", partyTime=" + partyTime + ", remark=" + remark + "]";
	}


	
	
}
