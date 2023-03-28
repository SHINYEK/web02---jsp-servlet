<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<div class="row justify-content-center my-5">
	<div class="col-md-6 text-center">
		<div class="card">
			<div class="card-body">
				<h1>글쓰기</h1>
				<form name="frm">
					<input type="text" name="writer" value="${uid}" class="form-control my-2"/>
					<input type="text" name="title" placeholder="제목" class="form-control my-2"/>
					<textarea rows="10" name="body" class="form-control my-2"></textarea>
					<button data-bs-target="#staticBackfrop" class="btn btn-primary">글등록</button>
				</form>
			</div>
		</div>
		
	</div>
</div>

<script>
	$("#confirm").on("click","#yes",function(){
		frm.action = "/posts/insert";
		frm.method = "post";
		frm.submit();
	})

	$(frm).on('submit',function(e){
		e.preventDefault();
		var title = $(frm.title).val();
		if(title==""){
			$("#alert .modal-body").html("제목을 입력하세요!");
			$("#alert").modal("show");
		}else{
			$("#confirm .modal-body").html("저장하실래요?");
			$("#confirm").modal("show");
		}
	})
</script>
