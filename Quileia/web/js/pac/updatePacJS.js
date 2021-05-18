setDefaultValue("tipoIDPaciente");
document.getElementsByName("identificacionPaciente")[0].addEventListener('keyup', function () {isNumber();});

/**
 * Check if it's a number and don't allow string characters
 * @return {undefined}
 */
function isNumber()
{
    var input = document.getElementsByName("identificacionPaciente")[0];
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

// // Bootstrap validation
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
                    if (element.getAttribute("name") === "historiaClinicaPaciente")
                    {
                        element.classList.remove("is-invalid");
                        element.classList.add("is-valid");
                    }
                    else if (element.value.localeCompare("") !== 0)
                    {
                        if (element.getAttribute("name").localeCompare("identificacionPaciente") === 0)
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