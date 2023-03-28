<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="row justify-content-center my-5 mx-2">
		<div class="col-md-6 ">
			<div class="card">
				<div class="card-body text-center">
					<h1>글수정</h1>
					<form name="frm">
						<input type="hidden" name="id" value="${post.id}" />
						<input type="text" name="writer" value="user01" class="form-control my-2"/>
						<input type="text" name="title" placeholder="제목" value="${post.title}" class="form-control my-2"/>
						<textarea rows="10" name="body" class="form-control my-2">${post.body}</textarea>
						<button data-bs-target="#staticBackfrop" class="btn btn-primary">글수정</button>
					</form>
				</div>
			</div>
		</div>
</div>
<jsp:include page="/modal.jsp"></jsp:include>


<script>
	$("#confirm").on('click',"#yes",function(){
		frm.action = "/posts/update";
		frm.method = "post";
		frm.submit();
	})

	$(frm).on('submit',function(e){
		e.preventDefault();
		var title = $(frm.title).val();
		if(title==""){
			alert("제목을 입력하세요!");
			$(frm.title).focus();
		}else{
			$("#confirm .modal-body").html("글을 수정하실래요?");
			$("#confirm").modal("show");
			
		}
	})
</script>
