package cn.yml.dao.factory;

import cn.yml.dao.ymlProductDao;
import cn.yml.dao.impl.ymlProductDaoImpl;
/**
 * 这是一个工厂类用于获取impl实现类的对象
 */
public class ymlProductDaoFactory {
	public static ymlProductDao getymlProductInstance() {
		return new ymlProductDaoImpl();
	}
}
