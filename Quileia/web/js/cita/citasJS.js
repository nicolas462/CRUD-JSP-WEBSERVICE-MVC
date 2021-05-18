setToday();
sethrs("horaAsignadaCita");
setmns("minutoAsignadoCita");
document.getElementsByName("documentoMedicoCita")[0].addEventListener('keyup', function () {isNumber("documentoMedicoCita");});
document.getElementsByName("documentoPacienteCita")[0].addEventListener('keyup', function () {isNumber("documentoPacienteCita");});

/**
 * Set hours 00 - 24
 * @param {type} nameElement
 * @return {undefined}
 */
function sethrs(nameElement)
{
    var hour = document.getElementsByName(nameElement);

    for(i = 0; i < 24 ; i++)
    {
        var opt = document.createElement("option");
        var formattedNumber = ("0" + i).slice(-2);
        opt.value = formattedNumber;
        opt.text = formattedNumber;
        hour[0].appendChild(opt);
    }
}

/**
 * Set minutes 00 - 59
 * @param {type} nameElement
 * @return {undefined}
 */
function setmns(nameElement)
{
    var minutes = document.getElementsByName(nameElement);

    for(i = 0; i <= 59 ; i++)
    {
        var opt = document.createElement("option");
        var formattedNumber = ("0" + i).slice(-2);
        opt.value = formattedNumber;
        opt.text = formattedNumber;
        minutes[0].appendChild(opt);
    }
}

function setToday()
{
    var dateLabel = document.getElementsByName("fechaSolicitadaCita")[0];
    dateLabel.value = getToday();
}

function getToday()
{
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0');
    var yyyy = today.getFullYear();

    today = yyyy + '-' + mm + '-' + dd;
    return today;
}

function validateDate()
{
    var fechaAsignadaCita = document.getElementsByName("fechaAsignadaCita")[0].value;
    return (fechaAsignadaCita.valueOf() >= getToday().valueOf()) ? true : false;
}

/**
 * Check if it's a number and don't allow string characters
 * @return {undefined}
 */
function isNumber(elementName)
{
    var input = document.getElementsByName(elementName)[0];
    var inputValue = input.value;
    var lastChar = input.value.slice(-1);
    
    if(isNaN(lastChar))
        input.value = inputValue.substring(0,inputValue.length - 1);
}

// Bootstrap validation
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
  'use strict';

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation');

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) 
        {
      form.addEventListener('submit', function (event) 
      {
        Array.prototype.slice.call(form)
                .forEach(function (element)
                {
                    if (element.value.localeCompare("") !== 0)
                    {
                        if (element.getAttribute("name").localeCompare("documentoPacienteCita") === 0
                                || element.getAttribute("name").localeCompare("documentoMedicoCita") === 0)
                        {
                            if (element.value % 1 === 0) // it's a number without decimals
                            {
                                element.classList.remove("is-invalid");
                                element.classList.add("is-valid");
                            } else
                            {
                                element.classList.remove("is-valid");
                                element.classList.add("is-invalid");
                                event.preventDefault();
                                event.stopPropagation();
                            }
                        }
                        else if(element.getAttribute("name").localeCompare("fechaAsignadaCita") === 0)
                        {
                            if (!validateDate())
                            {
                                alert("La fecha no debe ser pasada.");
                                element.classList.remove("is-valid");
                                element.classList.add("is-invalid");                                
                                event.preventDefault();
                                event.stopPropagation();                                
                            }                                
                        }
                        else
                        {
                            element.classList.remove("is-invalid");
                            element.classList.add("is-valid");
                        }
                    }
                    else
                    {
                        element.classList.remove("is-valid");
                        element.classList.add("is-invalid");
                        event.preventDefault();
                        event.stopPropagation();                    
                    }
                });
      }, false);
    });
})();
