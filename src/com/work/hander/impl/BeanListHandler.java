package com.work.hander.impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.work.hander.IResultSetHandler;
//将结果集中的多行数据，封装成一个list<>集合
public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
	private Class<T> classType;// 把结果集中的一行数据，封装成什么类型的对象

	public BeanListHandler(Class<T> classType) {
		this.classType = classType;
	}

	@Override
	public List<T> handle(ResultSet rSet) throws Exception {
		List<T> list = new ArrayList<>();
		while (rSet.next()) {
			// 将每一行分装成一个对象
			T obj = classType.newInstance();
			// 把每一行对应的对象，存储到集合List中
			list.add(obj);
			PropertyDescriptor[] pds = Introspector.getBeanInfo(classType, Object.class).getPropertyDescriptors();
			if (rSet.next()) {
				for (PropertyDescriptor pd : pds) {
					// 获取对象的属性名，属性名和列名相同
					String columnName = pd.getName();
					Object val = rSet.getObject(columnName);
					// 3.调用该对象的setter方法，把某一列的数据，设置进去
					pd.getWriteMethod().invoke(obj, val);
				}
			}
		}
		return list;
	}

}
