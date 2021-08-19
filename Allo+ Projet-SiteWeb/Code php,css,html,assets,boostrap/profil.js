

function init(){
    var allColorsBoxs = document.getElementsByName("color");
    allColorsBoxs.forEach(box=> {
        if(box.checked){
            console.log(box);
        }
    });
}