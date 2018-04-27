package com.work.hander.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.Iterator;

import com.work.hander.IResultSetHandler;

//将结果集中的一行数据封装成一个对象
public class BeanHandler<T> implements IResultSetHandler<T> {
	private Class<T> classType;// 把结果集中的一行数据，封装成什么类型的对象

	public BeanHandler(Class<T> classType) {
		this.classType = classType;
	}

	@Override
	public T handle(ResultSet rSet) throws Exception {
		// 1.创建对应类的一个对象
		T obj = classType.newInstance();
		// 2.取出结果集中当前光标所在行的某一列数据
		PropertyDescriptor[] pds = Introspector.getBeanInfo(classType,Object.class).getPropertyDescriptors();
		
		if (rSet.next()) {
			for (PropertyDescriptor pd : pds) {
				// 获取对象的属性名，属性名和列名相同
				String columnName = pd.getName();
				Object val = rSet.getObject(columnName);
				// 3.调用该对象的setter方法，把某一列的数据，设置进去
				pd.getWriteMethod().invoke(obj, val);
			}
		}
		return obj;
	}

}
