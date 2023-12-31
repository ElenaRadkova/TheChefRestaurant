const reservationId = document.getElementById('reservationId').value

const commentCtnr = document.getElementById('commentCtnr')

const allComments = []

const displayComments = (comments) => {
    commentCtnr.innerHTML = comments.map(
        (c)=> {
            return asComment(c)
        }
    ).join('')
}

function asComment(c) {
    let commentHtml = `<div id="commentCtnr-${c.commentId}">`
        commentHtml += `<h4>${c.user} (${c.created})</h4><br>`
        commentHtml += `<p>${c.message}</p>`
        commentHtml += `</div>`
    return commentHtml
}

fetch(`http://localhost:8080/api/${reservationId}/comments`)
    .then(response=> response.json())
    .then(data =>{
        for(let comment of data) {
            allComments.push(comment)
        }
        displayComments(allComments)
    })

