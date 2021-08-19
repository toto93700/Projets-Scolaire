const allStars = document.querySelectorAll(".fa-star");
const rating=document.querySelector('.rating');
const ratingJquery = $(".rating");

init();

// pour chaque étoile (span) on ajoute un event listener
function init()
{
    allStars.forEach((star) =>{
        star.addEventListener("click",saveRating)
        star.addEventListener("mouseover",addCSS);
        star.addEventListener("mouseleave",removeCSS);

    })
}


async function saveRating(e)
{
  
    removeEventListenerToAllStars();
    rating.innerText=e.target.dataset.star;

    //version fetch
    //var toto = await fetch('/soumetVote.php').then(response=> response.text());
    //console.log("fetch method :"+toto);

    //version jquery
    $.post("soumetVote.php",
    {
        rating:e.target.dataset.star
    },
    function(data,status){
        $("test").html(data);
    });
           
}



function removeEventListenerToAllStars(){
    allStars.forEach((star)=>
    {
        star.removeEventListener("click",saveRating);
        star.removeEventListener("mouseover",addCSS);
        star.removeEventListener("mouseleave",removeCSS);
        
    })
}

function addCSS(e,css="checked")
{
    const overedStar=e.target;
    overedStar.classList.add(css);
    const previousSiblings=getPreviousSiblings(overedStar);
    previousSiblings.forEach(elem=>elem.classList.add(css));
    
}
function removeCSS(e,css="checked"){
    const overedStar=e.target;
    overedStar.classList.remove(css);
    const previousSiblings=getPreviousSiblings(overedStar);
    previousSiblings.forEach((elem)=>elem.classList.remove(css));
    

}
function getPreviousSiblings(elem)
{
   
    let siblings=[];
    const spanNodeType=1;
    while(elem=elem.previousSibling){
        if(elem.nodeType == spanNodeType){
            siblings=[elem, ...siblings];
        }
    }
    return siblings;
    
}


