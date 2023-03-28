<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row justify-content-center my-5 mx-2">
	<div class="col-md-5">
		<div class="card text-center">
			<div class="card-title my-2 py-3">
				<h1>로그인</h1>
			</div>
			<div class="card-body">
				<form name="frm">
					<input type="text" class="form-control mb-2" name="uid" value="user01"/>
					<input type="password" class="form-control mb-2" name="upass" value="pass"/>
					<button class="btn btn-primary">로그인</button>
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/modal.jsp"></jsp:include>
<script>

$(frm).on("submit",function(e){
	e.preventDefault();
	let uid = $(frm.uid).val();
	let upass = $(frm.upass).val();
	if(uid===""){
		$("#alert .modal-body").html("아이디를 입력해주세요!");
		$("#alert").modal("show")
	}else if(upass==""){
		$("#alert .modal-body").html("비밀번호를 입력해주세요!");
		$("#alert").modal("show")
	}else{
		//로그인체크
		$.ajax({
			type:"post",
			url:"/login",
			data:{uid:uid,upass:upass},
			success:function(data){
				if(data==0){
					$("#alert .modal-body").html("존재하지 않는 아이디입니다!");
					$("#alert").modal("show")
				}else if(data==2){
					$("#alert .modal-body").html("비밀번호가 틀립니다.!");
					$("#alert").modal("show")
				}else{
					location.href = "/";
				}
			}
		})
	}
})

</script>