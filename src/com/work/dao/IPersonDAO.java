package com.work.dao;

import java.util.List;

import com.work.nativies.Person;

//各类方法的接口
public interface IPersonDAO {
	// personHander.savePerson(Person person):
	// personHander.deletePerson(integer id):
	// personHander.updatePerson(Person person):
	// personHander.getPersonByID(integer id):
	// personHander.getPersonsByParty(List<Party> parties):
	// personHander.getPersonsByBirthdayBefore(Date birthday):
	// personHander.getPersonsByBirthdayAfter(Date birthday):
	// personHander.getPersonsByBirthdayIn(Date birthday1,Date birthday2):
	// personHander.getPersonsByAddress(List<Address> addresses):
	// personHander.getPersonsByNameLike(String name):
	// personHander.getPersonsByRemarkLike(String remark):

	/**
	 * 根据id查询人员信息
	 * @param id 
	 */
	Person getPersonByID(Long id);
	/**
	 * 存储对象到对象对应类的表中
	 * @param object 需要存储的对象
	 */
	void save(Object object);
}
