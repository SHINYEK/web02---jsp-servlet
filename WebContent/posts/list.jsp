<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row justify-content-center my-5 mx-2">
	<div class="col-md-10">
	<h1 class="text-center">게시글</h1>
	<c:if test="${uid != null}"><a href="/posts/insert"><button data-bs-target="#staticBackfrop" class="btn btn-primary mb-2">글쓰기</button></a></c:if>
		<table class="table table-striped">
			<tr>
				<td>id</td>
				<td>제목</td>
				<td>작성일</td>
				<td>작성자</td>
			</tr>
		<c:forEach items="${list}" var="post">	
			<tr>
				<td>${post.id}</td>
				<td><a href="/posts/read?id=${post.id}">${post.title}</a></td>
				<td>${post.date}</td>
				<td>${post.writer}</td>
			</tr>		
		</c:forEach>
		</table>
	</div>	
</div>
