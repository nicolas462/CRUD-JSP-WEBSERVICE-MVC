popUp();
setPageNumbers();
disablePages();

document.getElementById("searchByIdentificacion").addEventListener("click", function (){
    getParams("identificacionParam", "identificacion");
});

document.getElementById("searchByNombre").addEventListener("click", function (){
    getParams("nombreParam", "nombre");
});

document.getElementById("searchByEps").addEventListener("click", function (){
    getParams("epsParam", "eps");
});

/**
 * get params and column to find
 * @param {type} idElement
 * @param {type} column
 * @return {undefined}
 */
function getParams(idElement, column)
{
    var param = document.getElementById(idElement).value;
    window.location.href = "Acciones?action=searchPaciente&param="+param+"&column="+column;
}

/**
 * Get attributte idMedico from clicked object.
 * @param {type} event
 * @return {undefined}
 */function getIdPaciente(event)
{
    var id = event.target.getAttribute("id");
    document.getElementById("deleteModalbtn").addEventListener("click", function() {
           window.location.href = "Acciones?action=deletePaciente&id="+id; 
    });
}



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
        var myModal = new bootstrap.Modal(document.getElementById('failModal'), {
            keyboard: false
        })
        myModal.show();
    }
    
    if(div.classList.contains("3"))
    {
        // modal activation      
        var myModal = new bootstrap.Modal(document.getElementById('existsModal'), {
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