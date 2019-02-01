package cn.yml.service;
import java.util.List;
import cn.yml.dao.ymlProductDao;
import cn.yml.dao.factory.ymlProductDaoFactory;
import cn.yml.web.bean.ymlProduct;

/*
 *处理商品相关的业务
 */
public class ymlProductService {
	private ymlProductDao dao;
	public ymlProductService() {
		super();
		this.dao = ymlProductDaoFactory.getymlProductInstance();
	}
	/**
	 * 查询商品信息
	 * 
	 * @param cid
	 * @param pageSize
	 * @param pageNum
	 * @param orderField
	 * @param orderStyle
	 * @return
	 */
	public List<ymlProduct> queryErrorAccount() {		
		return dao.queryErrorAccount();
	}
}
