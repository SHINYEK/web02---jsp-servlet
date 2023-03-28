<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<img src="http://via.placeholder.com/1500X150" width="100%"/>
<div>
	<a href="/">Home</a>
	<a href="/posts">게시글</a>
	<a href="/users">사용자목록</a>
	<c:if test="${uid!=null}"><a href="/logout" id="logout">로그아웃</a><span>${uid}</span></c:if>
	<c:if test="${uid==null}"><a href="/login">로그인</a></c:if>
</div>
<jsp:include page="/modal.jsp"></jsp:include>
<script>
	$("#confirm").on("click","#yes",function(){
		$.ajax({
			type:"get",
			url:"/logout",
			success:function(){
				location.href="/";
			}
		})
	})
	
	$("#logout").on("click", function(e){
		e.preventDefault();
		$("#confirm .modal-body").html("로그아웃하실래요?");
		$("#confirm").modal("show");		
	})
</script>