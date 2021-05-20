/**
 * 
 */

var insFrmElem = document.querySelector('#insFrm') //주소값을 얻어오는거 
var updFrmElem = document.querySelector('#updFrm') //주소값을 얻어오는거 

function delCmt(iboard, icmt){
	if(confirm('삭제하시겠습니까')){
		location.href=`/board/cmt?icmt=${icmt}&iboard=${iboard}`
	}
}

function updCmt(icmt, cmt){
	updFrm.icmt.value= icmt;
	updFrm.cmt.value= cmt;
	
	insFrm.className = 'hidden';
	updFrm.className = '';
}

function showInsFrm(){
			
		insFrm.className = '';
		updFrm.className = 'hidden';	

}