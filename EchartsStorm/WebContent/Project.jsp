<%@page import="cn.xdl.web.bean.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ECharts</title>
<script type="text/javascript" src='js/echarts.js'></script>
<script type="text/javascript" src='js/jquery.js'></script>
</head>
<body>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="width: 600px; height: 400px;"></div>


	<!-- <div id="main"
		style="position: relative; overflow: hidden; width: 871px; height: 351px; padding: 0px; margin: 0px; border-width: 0px; cursor: default;"">
		<canvas
			style="position: absolute; left: 0px; top: 0px; width: 871px; height: 351px; -moz-user-select: none; padding: 0px; margin: 0px; border-width: 0px;">

		</canvas>
	</div> -->
</body>
<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('main'));
	// 显示标题，图例和空的坐标轴
	myChart.setOption({
		title : {
			text : '异常账户统计'
		},
		tooltip : {
			show : true
		},
		legend : {
		//data:['数量']
		},
		xAxis : {
			data : []
		},
		yAxis : {},
		series : [ {
			name : '数量',
			type : 'bar',
			data : []
		} ]
	});

	myChart.showLoading();//数据加载完之前先显示一段简单的loading动画

	//myChart.setOption(option); // 使用刚指定的配置项和数据显示图表。

	var names = []; //异常账户数组（实际用来盛放X轴坐标值）
	var nums = []; //数量数组（实际用来盛放Y坐标值）
	
	// alert("get!!");
	function create(){
	$.ajax({
		type : "post",
		//async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
		url : "Main", //请求发送到TestServlet处
		data : {},
		success : function(result) {
			//alert(result);
			//请求成功时执行该函数内容，result即为服务器返回的json对象
			if (result) {
				for ( var i = 0; i < result.length; i++) {
					names.push(i); //挨个取出类别并填入类别数组
					nums.push(result[i].count); //挨个取出销量并填入销量数组
				}

				myChart.hideLoading(); //隐藏加载动画

				myChart.setOption({ //加载数据图表
					xAxis : {
						data : names
					},
					series : [ {
						// 根据名字对应到相应的系列
						name : '数量',
						data : nums
					} ]
				});
				names=[];
				nums=[];
			}

		},
		dataType : "json", //返回数据形式为json
		cache : false,
		error : function(errorMsg) {
			//请求失败时执行该函数
			alert("图表请求数据失败!");
			myChart.hideLoading();
		}
	});
	}
	
	$(function (){
		setInterval("create()",30000);
	});
</script>
</html>