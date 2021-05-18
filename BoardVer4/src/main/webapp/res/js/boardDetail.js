/**
 * 
 */
//댓글 수정
var insFrmElem = document.querySelector('#insFrm');//주소값얻어오는거
var updFrmElem = document.querySelector('#updFrm');//주소값얻어오는거



//댓글 삭제
function delCmt(iboard, icmt){
	if(confirm('삭제하시겠습니까')){
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`
	}
}

//메서드 수정하는거
function updCmt(icmt, cmt){
	
	console.log('icmt : %d', icmt)
	console.log('cmt : %s', cmt)
	updFrm.icmt.value = icmt;
	updFrm.cmt.value = cmt;
		
	insFrm.className = 'hidden';
	updFrm.className = '';	
		
}
//메서드보여주는거
function showInsFrm(){
			
		insFrm.className = '';
		updFrm.className = 'hidden';	

}