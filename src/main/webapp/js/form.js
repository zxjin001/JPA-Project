//把传统参数格式转换为json格式 ： name=10&minWeight=5&maxWeight=20  -> {name:xxx,minWeight:xxx,maxWeight:xx}
function conveterParamsToJson(paramsAndValues) {  
	//创建空的json对象
    var jsonObj = {};  
  
    var param = paramsAndValues.split("&");
    for ( var i = 0; param != null && i < param.length; i++) {  
        var para = param[i].split("=");  
        //给json对象添加属性和值
        jsonObj[para[0]] = para[1];  
    }  
  
    return jsonObj;  
}  
 
/**
 * 将表单数据封装为json
 * @param form
 * @returns
 */
function getFormData(form) {  
	//把表单的参数序列化为字符串：name=10&minWeight=5&maxWeight=20
    var formValues = $("#" + form).serialize();
    //decodeURIComponent(): js内置的传参编码的函数
    return conveterParamsToJson(decodeURIComponent(formValues));  
}  