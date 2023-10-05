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
			<h1>${map.blogVo.title }</h1>
			<ul>
				<c:choose>
					<c:when test="${empty authUser }">
						<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
						<c:if test="${authUser.id == map.blogId}">
							<li><a
								href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">블로그
									관리</a></li>
						</c:if>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${map.list3[map.postNo].title}</h4>
					<p>${map.list3[map.postNo].contents}
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${map.list3 }" var="vo" varStatus="status">
						<li><a
							href="${pageContext.request.contextPath}/${map.blogId }/${vo.categoryNo }/${status.index }">${vo.title}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<c:choose>
					<c:when test="${map.blogVo.image == 'image' }">
						<img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
					</c:when>
					<c:otherwise>
						<img src="${pageContext.request.contextPath}${map.blogVo.image}">
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${map.list2 }" var="vo" varStatus="status">
					<li><a
						href="${pageContext.request.contextPath}/${map.blogId }/${vo.no }">${vo.name}</a></li>
				</c:forEach>
			</ul>
		</div>

		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>