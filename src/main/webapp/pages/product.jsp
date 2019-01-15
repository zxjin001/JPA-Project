<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理页面</title>
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../js/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css">
<link id="easyuiTheme" rel="stylesheet" type="text/css"
	href="../js/easyui/themes/insdep/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/insdep/easyui_animation.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/insdep/easyui_plus.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/insdep/insdep_theme_default.css">
</head>

<body>

	<!-- 组合条件查询 -->
	<form id="searchForm">
		商品名称：<input name="name" type="text" class="easyui-textbox" /> 商品现价：<input
			name="startPrice" type="text" class="easyui-textbox" /> 到<input
			name="endPrice" type="text" class="easyui-textbox" /> <a
			id="searchButton" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'"> 查询 </a>
	</form>

	<!-- 使用 datagrid 进行列表展示 -->
	<table id="list"></table>

	<!-- 窗口 -->
	<div id="editWin" class="easyui-window" title="商品编辑"
		data-options="width:450,height:200,closed:true">
		<form id="editForm" method="post">
			<!-- 携带 id 隐藏域，为了让后台识别是修改操作 -->
			<input type="hidden" name="id" />
			<table>
				<tr>
				<td>商品名称</td>
				<td><input name="name" type="text" class="easyui-textbox"
					data-options="required:true" /></td>
				<td>商品原价</td>
				<td><input name="orignalPrice" type="text" class="easyui-numberbox"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td>商品现价</td>
				<td><input name="currentPrice" type="text" class="easyui-textbox"
					data-options="required:true" /></td>
				<td>商品描述</td>
				<td><input name="description" type="text" class="easyui-textbox"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="3"><a id="save" class="easyui-linkbutton" 
					data-options="iconCls:'icon-save'">确定</a></td>
			</tr>
		</table>
			
		</form>
	</div>


	<script type="text/javascript">
		$(function() {

			//定义工具条
			var toolbar = [ {
				id : "addButton",
				text : "添加",
				iconCls : "icon-add"
			}, {
				id : "editButton",
				text : "编辑",
				iconCls : "icon-edit"
			}, {
				id : "removeButton",
				text : "删除",
				iconCls : "icon-remove"
			}, ];

			$("#list")
					.datagrid(
							{
								//该 url 要求返回 json 数组格式
								url : "${pageContext.request.contextPath}/product/listByPage.action",
								columns : [ [ {
									field : "id",
									title : "商品编号",
									checkbox : true
								}, {
									field : "name",
									title : "商品名称",
									width : 200
								}, {
									field : "orignalPrice",
									title : "商品原价",
									width : 120
								}, {
									field : "currentPrice",
									title : "商品现价",
									width : 120
								}, {
									field : "description",
									title : "描述",
									width : 200
								} ] ],
								//显示分页：向后台发送 page:当前页码， rows:页面大小（每页多少记录）
								pagination : true,
								//添加工具条
								toolbar : toolbar
							});
			//开始搜索
			$("#searchButton").click(function() {
				//使用 datagrid 的 load 方法（需要 json 格式）
				$("#list").datagrid("load", getFormData("searchForm"));
			});

			//将表单数据封装为 json
			function getFormData(form) {
				//把表单的参数徐硫化为字符串：name=10&weight=5&height=20
				var formValues = $("#" + form).serialize();
				//decodeURIComponent():JS 内置的参数编码的函数
				return conveterParamsToJson(decodeURIComponent(formValues));
			}
			;

			//把传统参数格式转换为 JSON 格式：name=10&weight=5&height=20
			function conveterParamsToJson(paramsAndValues) {
				//创建空的 JSON 对象
				var jsonObj = {};
				var param = paramsAndValues.split("&");
				console.log(param);
				for (var i = 0; param != null && i < param.length; i++) {
					var para = param[i].split("=");
					//给 JSON 对象添加属性和值
					jsonObj[para[0]] = para[1];

					console.log(para);
				}
				return jsonObj;
			}
			;
			//保存数据
			$("#save").click(function() {
				$("#editForm").form("submit",{
					url:"${pageContext.request.contextPath}/product/save.action",
					onSubmit:function(){
						//检查校验是否正确
						return $("#editForm").form("validate");
					},
					success:function(data){
						//data:字符串格式
						data = eval("(" + data + ")");
						if (data.success) {
							//刷新datagrid
							$("#list").datagrid("reload");
							//关闭窗口
							$("#editWin").window("close");
							
							$.messager.show({
								title:"提示",
								msg:"保存成功"
							});
						}else {
							$.messager.alert("提示","保存失败：" + data.msg, "error");
						}
						
					}
				});
			});
			
			//打开窗口
			$("#addButton").click(function() {
				$("editForm").form("clear");
				$("#editWin").window("open");
			});
			
			//点击编辑，弹出编辑窗口
			$("#editButton").click(function() {
				//判断用户至少选择一个
				var rows = $("#list").datagrid("getSelections");
				if (rows.length != 1) {
					$.messager.alert("提示", "编辑操作只能选择一条数据", "warnning");
					return;
				}
				//填充表单
				$("#editForm").form("load", "${pageContext.request.contextPath}/product/findById.action?id="+rows[0].id);
				//打开窗口
				$("#editWin").window("open");
			});
			
			//点击删除，删除数据
			$("#removeButton").click(function() {
				var ids="";
				var rows = $("#list").datagrid("getSelections");
				var idArray = new Array();
				$(rows).each(function(i){
					idArray.push(rows[i].id);
				});
				
				$.messager.confirm("提示","确认删除吗？一旦删除不能恢复！", 
						function(value){
							if (value) {
								ids=idArray.join(",");
								
								//发送后台
								$.post("${pageContext.request.contextPath}/product/delete.action"
									,{ids:ids},function(data){
										if (data.success) {
											//刷新datagrid
											$("#list").datagrid("reload");
											$.messager.show({
												title:"提示",
												msg:"删除成功"
											});
										}else {
											$.messager.alert("提示","删除失败：" + data.msg, "error");
										}
								 })
						}
				});
		
			  });
		});
	</script>
</body>
</html>