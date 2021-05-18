popUp();
setPageNumbers();
disablePages();
/**
 * Shows modal alert by the class inside div
 * @return {undefined}
 */
function popUp()
{
    var div = document.getElementsByClassName("container")[0];
    if(div.classList.contains("1"))
    {
        // modal activation      
        var myModal = new bootstrap.Modal(document.getElementById('successModal'), {
            keyboard: false
        })
        myModal.show();
    }
    
    if(div.classList.contains("2"))
    {
        // modal activation      
        var myModal = new bootstrap.Modal(document.getElementById('failPacienteModal'), {
            keyboard: false
        })
        myModal.show();
    }
    
    if(div.classList.contains("3"))
    {
        // modal activation      
        var myModal = new bootstrap.Modal(document.getElementById('failMedicoModal'), {
            keyboard: false
        })
        myModal.show();
    }
    
    if(div.classList.contains("4"))
    {
        // modal activation      
        var myModal = new bootstrap.Modal(document.getElementById('failModal'), {
            keyboard: false
        })
        myModal.show();
    }
    
    if(div.classList.contains("5"))
    {
        // modal activation      
        var myModal = new bootstrap.Modal(document.getElementById('failAvailableModal'), {
            keyboard: false
        })
        myModal.show();
    }      
}

function disablePages()
{
    var querySize = document.getElementById("querySize").value;
    var firstPage = document.getElementById("firstPage-btn");    
    var secondPage = document.getElementById("secondPage-btn");
    var thirdPage = document.getElementById("thirdPage-btn");
    var nextPage = document.getElementById("nextPage");
    var prevPage = document.getElementById("prevPage");
    
    if( +querySize < 10 && firstPage.parentElement.classList.contains("active"))
    {
        secondPage.parentElement.classList.add("disabled");
        thirdPage.parentElement.classList.add("disabled");
        nextPage.parentElement.classList.add("disabled");
    }
    else if( +querySize < 10)
    {
       thirdPage.parentElement.classList.add("disabled");
       nextPage.parentElement.classList.add("disabled");
       prevPage.parentElement.classList.remove("disabled");
    }
}

function setPageNumbers()
{
    var currentPage = document.getElementById("page").value;
    var firstPage = document.getElementById("firstPage-btn");
    var secondPage = document.getElementById("secondPage-btn");
    var thirdPage = document.getElementById("thirdPage-btn");
    
    if (+currentPage != 0 && + +currentPage != 1)
    {
        firstPage.text = +currentPage;
        secondPage.text = +currentPage + 1;
        thirdPage.text = +currentPage + 2;
    }
    
    if (+currentPage != 0)
    {
        firstPage.parentElement.classList.remove("active");
        secondPage.parentElement.classList.add("active");
    }
}