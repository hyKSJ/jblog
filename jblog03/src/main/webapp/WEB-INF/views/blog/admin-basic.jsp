<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>${map.blogVo.title}</h1>
			<ul>
				<li><a href="${pageContext.request.contextPath}/${authUser.id}">홈으로</a></li>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected">기본설정</li>
					<li><a
						href="${pageContext.request.contextPath}/${authUser.id}/admin/category">카테고리</a></li>
					<li><a
						href="${pageContext.request.contextPath}/${authUser.id}/admin/write">글작성</a></li>
				</ul>
				<form
					action="${pageContext.request.contextPath}/${authUser.id}/updateblog"
					method="post" enctype="multipart/form-data">
					<table class="admin-config">
						<tr>
							<td class="t">블로그 제목</td>
							<td><input type="text" size="40" name="title"></td>
						</tr>
						<tr>
							<td class="t">로고이미지</td>
							<td><c:choose>
									<c:when test="${map.blogVo.image == 'image' }">
										<img
											src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
									</c:when>
									<c:otherwise>
										<img
											src="${pageContext.request.contextPath}${map.blogVo.image}">
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td><input type="file" name="f"></td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td class="s"><input type="submit" value="기본설정 변경"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>