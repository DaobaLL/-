package com.work.hander;

import java.sql.ResultSet;
//结果集处理器，规范处理结果集的方法名称
public interface IResultSetHandler<T> {
	T handle(ResultSet rSet) throws Exception;
}
