/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2019-01-15 01:02:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>商品管理页面</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/easyui/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"../js/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../js/easyui/themes/icon.css\">\r\n");
      out.write("<link id=\"easyuiTheme\" rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../js/easyui/themes/insdep/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../js/easyui/themes/insdep/easyui_animation.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../js/easyui/themes/insdep/easyui_plus.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../js/easyui/themes/insdep/insdep_theme_default.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 组合条件查询 -->\r\n");
      out.write("\t<form id=\"searchForm\">\r\n");
      out.write("\t\t商品名称：<input name=\"name\" type=\"text\" class=\"easyui-textbox\" /> 商品现价：<input\r\n");
      out.write("\t\t\tname=\"startPrice\" type=\"text\" class=\"easyui-textbox\" /> 到<input\r\n");
      out.write("\t\t\tname=\"endPrice\" type=\"text\" class=\"easyui-textbox\" /> <a\r\n");
      out.write("\t\t\tid=\"searchButton\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-search'\"> 查询 </a>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 使用 datagrid 进行列表展示 -->\r\n");
      out.write("\t<table id=\"list\"></table>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 窗口 -->\r\n");
      out.write("\t<div id=\"editWin\" class=\"easyui-window\" title=\"商品编辑\"\r\n");
      out.write("\t\tdata-options=\"width:450,height:200,closed:true\">\r\n");
      out.write("\t\t<form id=\"editForm\" method=\"post\">\r\n");
      out.write("\t\t\t<!-- 携带 id 隐藏域，为了让后台识别是修改操作 -->\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" />\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>商品名称</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"name\" type=\"text\" class=\"easyui-textbox\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t\t<td>商品原价</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"orignalPrice\" type=\"text\" class=\"easyui-numberbox\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>商品现价</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"currentPrice\" type=\"text\" class=\"easyui-textbox\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t\t<td>商品描述</td>\r\n");
      out.write("\t\t\t\t<td><input name=\"description\" type=\"text\" class=\"easyui-textbox\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\"><a id=\"save\" class=\"easyui-linkbutton\" \r\n");
      out.write("\t\t\t\t\tdata-options=\"iconCls:'icon-save'\">确定</a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t//定义工具条\r\n");
      out.write("\t\t\tvar toolbar = [ {\r\n");
      out.write("\t\t\t\tid : \"addButton\",\r\n");
      out.write("\t\t\t\ttext : \"添加\",\r\n");
      out.write("\t\t\t\ticonCls : \"icon-add\"\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tid : \"editButton\",\r\n");
      out.write("\t\t\t\ttext : \"编辑\",\r\n");
      out.write("\t\t\t\ticonCls : \"icon-edit\"\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tid : \"removeButton\",\r\n");
      out.write("\t\t\t\ttext : \"删除\",\r\n");
      out.write("\t\t\t\ticonCls : \"icon-remove\"\r\n");
      out.write("\t\t\t}, ];\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\"#list\")\r\n");
      out.write("\t\t\t\t\t.datagrid(\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t//该 url 要求返回 json 数组格式\r\n");
      out.write("\t\t\t\t\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product/listByPage.action\",\r\n");
      out.write("\t\t\t\t\t\t\t\tcolumns : [ [ {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfield : \"id\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttitle : \"商品编号\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\tcheckbox : true\r\n");
      out.write("\t\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfield : \"name\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttitle : \"商品名称\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\twidth : 200\r\n");
      out.write("\t\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfield : \"orignalPrice\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttitle : \"商品原价\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\twidth : 120\r\n");
      out.write("\t\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfield : \"currentPrice\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttitle : \"商品现价\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\twidth : 120\r\n");
      out.write("\t\t\t\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfield : \"description\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttitle : \"描述\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\twidth : 200\r\n");
      out.write("\t\t\t\t\t\t\t\t} ] ],\r\n");
      out.write("\t\t\t\t\t\t\t\t//显示分页：向后台发送 page:当前页码， rows:页面大小（每页多少记录）\r\n");
      out.write("\t\t\t\t\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\t\t\t\t\t//添加工具条\r\n");
      out.write("\t\t\t\t\t\t\t\ttoolbar : toolbar\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t//开始搜索\r\n");
      out.write("\t\t\t$(\"#searchButton\").click(function() {\r\n");
      out.write("\t\t\t\t//使用 datagrid 的 load 方法（需要 json 格式）\r\n");
      out.write("\t\t\t\t$(\"#list\").datagrid(\"load\", getFormData(\"searchForm\"));\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t//将表单数据封装为 json\r\n");
      out.write("\t\t\tfunction getFormData(form) {\r\n");
      out.write("\t\t\t\t//把表单的参数徐硫化为字符串：name=10&weight=5&height=20\r\n");
      out.write("\t\t\t\tvar formValues = $(\"#\" + form).serialize();\r\n");
      out.write("\t\t\t\t//decodeURIComponent():JS 内置的参数编码的函数\r\n");
      out.write("\t\t\t\treturn conveterParamsToJson(decodeURIComponent(formValues));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t;\r\n");
      out.write("\r\n");
      out.write("\t\t\t//把传统参数格式转换为 JSON 格式：name=10&weight=5&height=20\r\n");
      out.write("\t\t\tfunction conveterParamsToJson(paramsAndValues) {\r\n");
      out.write("\t\t\t\t//创建空的 JSON 对象\r\n");
      out.write("\t\t\t\tvar jsonObj = {};\r\n");
      out.write("\t\t\t\tvar param = paramsAndValues.split(\"&\");\r\n");
      out.write("\t\t\t\tconsole.log(param);\r\n");
      out.write("\t\t\t\tfor (var i = 0; param != null && i < param.length; i++) {\r\n");
      out.write("\t\t\t\t\tvar para = param[i].split(\"=\");\r\n");
      out.write("\t\t\t\t\t//给 JSON 对象添加属性和值\r\n");
      out.write("\t\t\t\t\tjsonObj[para[0]] = para[1];\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tconsole.log(para);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn jsonObj;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t;\r\n");
      out.write("\t\t\t//保存数据\r\n");
      out.write("\t\t\t$(\"#save\").click(function() {\r\n");
      out.write("\t\t\t\t$(\"#editForm\").form(\"submit\",{\r\n");
      out.write("\t\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product/save.action\",\r\n");
      out.write("\t\t\t\t\tonSubmit:function(){\r\n");
      out.write("\t\t\t\t\t\t//检查校验是否正确\r\n");
      out.write("\t\t\t\t\t\treturn $(\"#editForm\").form(\"validate\");\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t\t//data:字符串格式\r\n");
      out.write("\t\t\t\t\t\tdata = eval(\"(\" + data + \")\");\r\n");
      out.write("\t\t\t\t\t\tif (data.success) {\r\n");
      out.write("\t\t\t\t\t\t\t//刷新datagrid\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#list\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t\t\t//关闭窗口\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#editWin\").window(\"close\");\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\ttitle:\"提示\",\r\n");
      out.write("\t\t\t\t\t\t\t\tmsg:\"保存成功\"\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}else {\r\n");
      out.write("\t\t\t\t\t\t\t$.messager.alert(\"提示\",\"保存失败：\" + data.msg, \"error\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//打开窗口\r\n");
      out.write("\t\t\t$(\"#addButton\").click(function() {\r\n");
      out.write("\t\t\t\t$(\"editForm\").form(\"clear\");\r\n");
      out.write("\t\t\t\t$(\"#editWin\").window(\"open\");\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//点击编辑，弹出编辑窗口\r\n");
      out.write("\t\t\t$(\"#editButton\").click(function() {\r\n");
      out.write("\t\t\t\t//判断用户至少选择一个\r\n");
      out.write("\t\t\t\tvar rows = $(\"#list\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t\t\tif (rows.length != 1) {\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"提示\", \"编辑操作只能选择一条数据\", \"warnning\");\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t//填充表单\r\n");
      out.write("\t\t\t\t$(\"#editForm\").form(\"load\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product/findById.action?id=\"+rows[0].id);\r\n");
      out.write("\t\t\t\t//打开窗口\r\n");
      out.write("\t\t\t\t$(\"#editWin\").window(\"open\");\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//点击删除，删除数据\r\n");
      out.write("\t\t\t$(\"#removeButton\").click(function() {\r\n");
      out.write("\t\t\t\tvar ids=\"\";\r\n");
      out.write("\t\t\t\tvar rows = $(\"#list\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t\t\tvar idArray = new Array();\r\n");
      out.write("\t\t\t\t$(rows).each(function(i){\r\n");
      out.write("\t\t\t\t\tidArray.push(rows[i].id);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$.messager.confirm(\"提示\",\"确认删除吗？一旦删除不能恢复！\", \r\n");
      out.write("\t\t\t\t\t\tfunction(value){\r\n");
      out.write("\t\t\t\t\t\t\tif (value) {\r\n");
      out.write("\t\t\t\t\t\t\t\tids=idArray.join(\",\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t//发送后台\r\n");
      out.write("\t\t\t\t\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/product/delete.action\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t,{ids:ids},function(data){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif (data.success) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//刷新datagrid\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#list\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\ttitle:\"提示\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tmsg:\"删除成功\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$.messager.alert(\"提示\",\"删除失败：\" + data.msg, \"error\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t })\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t  });\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}