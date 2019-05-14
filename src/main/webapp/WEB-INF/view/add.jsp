<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表展示</title>
<!-- 引入css样式 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resource/css/mystyles.css">
<!-- 引入jquery -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery-3.0.0.min.js"></script>

<script type="text/javascript">
   //
   $(function(){
	   //获取所有品牌   
	   $.ajax({
		   type:"get",
		   url:"getBrandList",
		   success:function(list){
		    	for(var i in list){
		    		$("#bid").append("<option value='"+list[i].bid+"'>"+list[i].bname+"</option>")
		    	}   
		   }
		   
	   })
	   //获取所有分类
	    $.ajax({
		   type:"get",
		   url:"getKindList",
		   success:function(list){
		    	for(var i in list){
		    		$("#kid").append("<option value='"+list[i].kid+"'>"+list[i].kname+"</option>")
		    	}   
		   }
		   
	   })
	  
	   
	   
   })
   
   
   //增加
   function add(){
	 //序列化表单数据带文件
	   var formData = new FormData($( "form" )[0]);
	   
	  $.ajax({
		  type:"post",
		  data:formData,
		// 告诉jQuery不要去处理发送的数据
		  processData : false,
		  // 告诉jQuery不要去设置Content-Type请求头
		  contentType : false,
		  url:"add",
		  success:function(obj){
			  if(obj){
				  alert("保存成功");
				  location.href="/list";
			  }else{
				  alert("保存失败");
			  }
			  
		  }
		  
	  }) 
	   
	   
	   
   }
</script>

</head>
<body>


	<form action="">
		<table>
			<tr>
				<td>商品名称<input type="text" name="name"></td>
			</tr>
			<tr>
				<td>价格<input type="text" name="price"></td>
			</tr>
			<tr>
				<td>分类<select id="kid" name="kid"></select></td>
			</tr>
			<tr>
				<td>品牌<select id="bid" name="bid"></select></td>
			</tr>
			<tr>
				<td>图片<input type="file" name="pic"></td>
			</tr>
			
				<tr>
				<td><input type="button" onclick="add()" value="增加">  </td>
				
				
			</tr>

		</table>

	</form>
</body>
</html>