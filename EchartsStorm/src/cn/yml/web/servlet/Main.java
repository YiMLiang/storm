package cn.yml.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.yml.service.ymlProductService;
import cn.yml.web.bean.ymlProduct;

/**
 * Servlet implementation class Main
 */
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ymlProductService productService = new ymlProductService();

		/**
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		// 2. 查询商品信息
		List<ymlProduct> categories = productService.queryErrorAccount();
		System.out.println("gets!!" + categories);
		//
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(JSONArray.fromObject(categories).toString());
	}

}
