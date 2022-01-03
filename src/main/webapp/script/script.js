

var modal_btn =document.getElementById("modal-btn");
var modal=document.getElementById("modal");
var modal_close=document.getElementById("modal-close");

modal_btn.addEventListener("click",function (){
    modal.setAttribute("class","container mx-auto")
});
modal_close.addEventListener("click", function (){
    modal.setAttribute("class","hidden")
});


