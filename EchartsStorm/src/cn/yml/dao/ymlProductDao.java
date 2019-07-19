package cn.yml.dao;
import java.util.List;
import cn.yml.web.bean.ymlProduct;

public interface ymlProductDao {
	/**
	 * 查询商品信息
	 * 
	 * @param cid 类别id
	 * @param pageSize  查询的条数
	 * @param pageNum	页码
	 * @param orderField	排序的字段
	 * @param orderStyle 排序的方式
	 * @return  商品列表
	 */
	List<ymlProduct> queryErrorAccount();
}
