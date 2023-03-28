<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<div class="row justify-content-center my-5">
	<div class="col-md-6 ">
		<div class="card">
			<div class="card-body">
				<h1>게시글정보</h1>
				<h4>[${post.id}] ${post.title}</h4>
				<h4>작성자: ${post.writer}</h4>
				<hr/>
				<p>${post.body}</p>
				<c:if test="${uid==post.writer}">
					<div class="text-center">
						<button data-bs-target="#staticBackfrop" class="btn btn-primary" id="btnUpdate">수정</button>
						<button data-bs-target="#staticBackfrop" class="btn btn-danger"  id="btnDelete">삭제</button>
					</div>
				</c:if>
				
			</div>
		</div>
	</div>
</div>



<script>
	$("#confirm").on("click","#yes",function(){
		$.ajax({
	        type: "post",
	        url: "/posts/delete",
	        data: {id: ${post.id}},
	        success: function() {
	            location.href = "/posts";
	        }
	    });
	})
	$("#btnDelete").on("click", function() {
		$("#confirm .modal-body").html(`${post.id}번 게시물을 삭제하실래요?`);
		$("#confirm").modal("show");	    
	});
	
	$("#btnUpdate").on("click",function(){
		location.href = `/posts/update?id=${post.id}`
	})
</script>