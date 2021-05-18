sethrs("horaInicioMedico");
sethrs("horaFinMedico");
setmns("minutosInicioMedico");
setmns("minutosFinMedico");
setDefaultValue("horaInicioMedico");
setDefaultValue("horaFinMedico");
setDefaultValue("minutosInicioMedico");
setDefaultValue("minutosFinMedico");
setDefaultValue("tipoIDMedico");
document.getElementsByName("identificacionMedico")[0].addEventListener('keyup', function () {isNumber();});
document.getElementsByName("anosExpMedico")[0].addEventListener('keyup', function () {isFloat();});


/**
 * Check if it's a number and only allow '.' and numbers
 * @return {undefined}
 */
function isFloat()
{
    var input = document.getElementsByName("anosExpMedico")[0];
    var inputValue = input.value;
    var lastChar = input.value.slice(-1);
    
    if(isNaN(lastChar) && lastChar.localeCompare(".") !== 0)
        input.value = inputValue.substring(0,inputValue.length - 1);
}

/**
 * Check if it's a number and don't allow string characters
 * @return {undefined}
 */
function isNumber()
{
    var input = document.getElementsByName("identificacionMedico")[0];
    var inputValue = input.value;
    var lastChar = input.value.slice(-1);
    
    if(isNaN(lastChar))
        input.value = inputValue.substring(0,inputValue.length - 1);
}

/**
 * Set the value extracted from the query into select
 * @param {type} nameElement
 * @return {undefined}
 */
function setDefaultValue(nameElement)
{
    var select = document.getElementsByName(nameElement)[0];
    var defaultOptValue = select.firstElementChild.value;

    if(defaultOptValue !== "")
    {
        select.firstElementChild.remove();
        select.value = defaultOptValue;   
    }
}

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
                        if (element.getAttribute("name").localeCompare("identificacionMedico") === 0)
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
                        else if (element.getAttribute("name") === "anosExpMedico")
                        {
                            if (!isNaN(parseFloat(element.value))) // it's a float
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