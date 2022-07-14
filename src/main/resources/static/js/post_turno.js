window.addEventListener('load', function () {

    const url = '/turnos';

    const formulario = document.querySelector('#add_new_odontologo');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formulario.addEventListener('submit', function (event) {

        const formData = {

            odontologo: {
                         id: parseInt(document.querySelector('#id_odontologo').value)
                         },
            paciente: {
                        id: parseInt(document.querySelector('#id_paciente').value)
                        },
            fecha: document.querySelector('#fecha_turno').value
        };

        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                //Si no hay ningun error se muestra un mensaje diciendo que la pelicula
                //se agrego bien
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Odontologo agregado </div>'

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();

            })
            .catch(error => {
                //Si hay algun error se muestra un mensaje diciendo que la pelicula
                //no se pudo guardar y se intente nuevamente
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                //se dejan todos los campos vacíos por si se quiere ingresar otro odontologo
                resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#id_odontologo').value = "";
        document.querySelector('#id_paciente').value = "";
        document.querySelector('#fecha_turno').value = "";
    }
/*
    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/peliculaList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();

     */
});