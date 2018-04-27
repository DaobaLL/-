package com.work.hibernate;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import com.work.annotation.TableName;

import util.DruidUtil;

//模拟Hibernate，做一各通用的SQL语句处理器
//string sql = ""
//object[] params = {}
//DruidUtil.update(sql,params)
public class HibernateMock {
	public static void save(Object object) throws Exception {
		try {
			// INSERT INTO t_student (`name`, `age`) VALUES (?,?)
			// 获取传入类的表名
			String tableName = object.getClass().getSimpleName();
			TableName table = object.getClass().getAnnotation(TableName.class);
			if (null != table) {
				tableName = table.value();
			}
			StringBuilder sql = new StringBuilder();
			StringBuilder columnSql = new StringBuilder();// 需要拼入得参数
			StringBuilder placeHolderSql = new StringBuilder();// 拼接占位符:?,?
			List<Object> params = new ArrayList<>();// 装传入的参数
			for (Object object2 : params) {
				System.out.println(object2);
			}
			BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass(), Object.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				String propertyName = pd.getName();
				if (!"id".equals(pd)) {
					columnSql.append(propertyName).append(",");
					placeHolderSql.append("?").append(",");
					// 获取属性的值，调用属性的getter方法
					Object val = pd.getReadMethod().invoke(object);
					params.add(val);
				}
			}
			// 删除最后一个逗号
			columnSql.deleteCharAt(columnSql.length() - 1);
			placeHolderSql.deleteCharAt(placeHolderSql.length() - 1);
			sql.append("INSERT INTO ").append(tableName).append(" (");
			sql.append(columnSql).append(") VALUE (").append(placeHolderSql).append(")");
			//将sql语句传入连接池
			DruidUtil.update(sql.toString(), params.toArray());
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void get(Object object)throws Exception{
		
	}
	public static void main(String[] args) throws Exception {
	}

}
