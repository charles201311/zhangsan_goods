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
 function query(){
	 location.href="/list?name="+$("[name='name']").val()
	 
 }
 
 function toAdd(){
	 location.href="toAdd";
	 
 }

</script>

</head>
<body>



用户名称:<input type="text" name="name" value="${name }">
   <input type="button" value="查询" onclick="query()">
         <input type="button" value="增加" onclick="toAdd()">
	<table>
		<tr>
			<td>序号</td>
			<td>商品名称</td>
			<td>价格</td>
			<td>分类</td>
			<td>品牌</td>
			<td>图片</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${list}" var="c" varStatus="i">
			<tr>
				<td>${i.index+1 }</td>
				<td>${c.name }</td>
				<td>${c.price }</td>
				<td>${c.kname }</td>
				<td>${c.bname}</td>
				<td><img alt="" src="/pic/${c.url}"></td>
				<td>修改|删除</td>
			</tr>
		</c:forEach>

       <tr >
       <td colspan="7">${page} </td>
       </tr>
	</table>
</body>
</html>