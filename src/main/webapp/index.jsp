<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ECShop后台 - 首页</title>
		<link href="favicon.ico" rel="icon" type="image/x-icon" />
		<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
		<link id="easyuiTheme" rel="stylesheet" type="text/css" href="js/easyui/themes/insdep/easyui.css">
		<link rel="stylesheet" type="text/css" href="js/easyui/themes/insdep/easyui_animation.css">
		<link rel="stylesheet" type="text/css" href="js/easyui/themes/insdep/easyui_plus.css">
		<link rel="stylesheet" type="text/css" href="js/easyui/themes/insdep/insdep_theme_default.css">
		
		<!-- 导入ztree的资源文件 -->
		<script type="text/javascript" src="js/ztree/js/jquery.ztree.all.min.js"></script>
		<link rel="stylesheet" type="text/css" href="js/ztree/css/metroStyle/metroStyle.css">
		
		<script type="text/javascript">
			$(function() {
				
				var setting = {
						data: {
							simpleData: {
								enable: true,
							}
						},
						//绑定回调函数
						callback:{
							onClick:onClickTreeNode
						}
				};
				
				//异步方式加载bos系统的菜单数据
				
				$.post("data/menu.json",function(data){ // data：后台返回数据
					$.fn.zTree.init($("#treeDemo"), setting, data);
				},"json");
				
				
				$("#btnCancel").click(function(){
					$('#editPwdWindow').window('close');
				});
				
				$("#btnEp").click(function(){
					alert("修改密码");
				});
				
				// 设置全局变量 保存当前正在右键的tabs 标题 
				var currentRightTitle  ;
			});
			
			// 退出登录
			function logoutFun() {
				$.messager
				.confirm('系统提示','您确定要退出本次登录吗?',function(isConfirm) {
					if (isConfirm) {
						location.href = '#';
					}
				});
			}
			// 修改密码
			function editPassword() {
				$('#editPwdWindow').window('open');
			}
			
			//点击树的节点后触发的函数
			//event:事件对象  event.pageX event.pageY
			//treeId:点击的树节点的id
			//treeNode:点击的树节点对象
			function onClickTreeNode(event,treeId,treeNode){
				if(treeNode.pageUrl!=null && treeNode.pageUrl!="#"){
					//树节点的名称
					var name = treeNode.name;
					//获取pageUrl属性，就是连接的url地址
					var pageUrl = treeNode.pageUrl;
					
					//判断面板是否已经存在
					if( $("#tabs").tabs("exists",name)){
						//存在
						//选择面板
						$("#tabs").tabs("select",name);
					}else{
						//不存在
						//创建面板
						$("#tabs").tabs("add",{
							//标题
							title:name,
							//关闭按钮
							closable:true,
							content:"<iframe src='"+pageUrl+"' style='width:100%;height:100%' frameborder='0' scrolling='auto'></iframe>"
						});
					}	
				}
			}
			
		</script>
	</head>

	<body class="easyui-layout">
		<!-- 顶部 -->
		<div data-options="region:'north',border:false" style="height:70px;">
			<div>
				<img src="./images/logo.png" border="0">
			</div>
			<div id="sessionInfoDiv" style="position: absolute;right: 5px;top:10px;">
				[<strong>郑大法</strong>]，欢迎你！
			</div>
			<div style="position: absolute; right: 5px; bottom: 10px; ">
				<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a>
			</div>
			<!-- 控制面板 -->
			<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
				<div onclick="editPassword();">修改密码</div>
				<div class="menu-sep"></div>
				<div onclick="logoutFun();">退出系统</div>
			</div>
		</div>
		
		
		<!-- 左边菜单 -->
		<div data-options="region:'west',split:true,title:'菜单导航'" style="width:200px">
			<!-- 加载菜单树 -->
			<ul id="treeDemo" class="ztree"></ul>
		</div>
		
		
		<!-- 中间编辑区域 -->
		<div data-options="region:'center'">
			<div id="tabs" fit="true" class="easyui-tabs" border="false">
				<div title="起始页" id="subWarp" style="width:100%;height:100%;overflow:hidden">
					欢迎登录ECShop系统
				</div> 
			</div>
		</div>
		
		<!-- 底部版权 -->
		<div data-options="region:'south',border:false" style="height:50px;padding:10px;">
			<table style="width: 100%;">
				<tbody>
					<tr>
						<td style="width: 400px;">
							<div style="color: #999; font-size: 8pt;text-align: center;">
								ECShop系统 | Powered by <a href="http://http://www.mapeak.com/" target="_blank">郑大法</a> | QQ：895720933
							</div>
						</td>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!--修改密码窗口-->
		<div id="editPwdWindow" class="easyui-window" title="修改密码" collapsible="false" minimizable="false" modal="true" closed="true" resizable="false" maximizable="false" icon="icon-save" style="width: 300px; height: 160px; padding: 5px;
        background: #fafafa">
			<div class="easyui-layout" fit="true">
				<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
					<table cellpadding=3>
						<tr>
							<td>新密码：</td>
							<td>
								<input id="txtNewPass" type="Password" class="txt01" />
							</td>
						</tr>
						<tr>
							<td>确认密码：</td>
							<td>
								<input id="txtRePass" type="Password" class="txt01" />
							</td>
						</tr>
					</table>
				</div>
				<div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
					<a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确定</a>
					<a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
				</div>
			</div>
		</div>

		<div id="mm" class="easyui-menu" style="width:120px;">
			<div data-options="name:'Close'">关闭当前窗口</div>
			<div data-options="name:'CloseOthers'">关闭其它窗口</div>
			<div class="menu-sep"></div>
			<div data-options="iconCls:'icon-cancel',name:'CloseAll'">关闭全部窗口</div>
		</div>

	</body>

</html>