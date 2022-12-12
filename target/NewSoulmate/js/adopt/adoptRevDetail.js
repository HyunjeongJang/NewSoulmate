$('#replySubmit').on('click',submitReply);
function submitReply(){
    let replyContent=$('#replyInput').val();
    if(replyContent.length==0){
        alert('댓글내용을 입력해주세요');
        $('#replyInput').focus();
        return;
    }
    reply.replyContent=replyContent;
    $.ajax({
        url :'replyInsert.bo',
        type:'post',
        data:{"reply":JSON.stringify(reply)},
        success:(result)=>{
            if(result>0){
                alert('댓글등록성공');
                location.reload();
            }else{
                alert('댓글등록실패',result)
            }
        },
        error:(result)=>{
            console.log(result)
        }
    });
}
$('.replyDelete').click((e)=>{
    let rno=  $(e.target).attr('ref');
    if(confirm('정말삭제하시겠습니까?')){
        $.ajax({
            url:"replyDelete.bo",
            type:'post',
            data:{rno:rno},
            success:(result)=>{
                if(result>0){
                    alert("댓글삭제성공")
                    location.reload()
                }else{
                    alert("댓글삭제실패")
                }
            },
            error:(e)=>{console.log(e)}

        })


    }
})

