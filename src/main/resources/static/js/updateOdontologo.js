window.addEventListener('load', function () {

    //invocamos utilizando la función fetch la API peliculas con el método POST que guardará
    //la película que enviaremos en formato JSON
    const url = '/odontologos';

    //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
    //los datos que el usuario cargará de la nueva pelicula
    const formularioUpdateOdontologo = document.querySelector('#update_odontologo');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formularioUpdateOdontologo.addEventListener('submit', function (event) {

        //creamos un JSON que tendrá los datos de la nueva película
        const formDataUpdateOdontologo = {
            id: parseInt(document.querySelector('#id_odontologo').value),
            apellido: document.querySelector('#apellido').value,
            nombre: document.querySelector('#nombre').value,
            matricula: document.querySelector('#matricula').value,
        };

        const settingsUpdateOdontologo = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataUpdateOdontologo)
        }

        fetch(url, settingsUpdateOdontologo)
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
        document.querySelector('#apellido').value = "";
        document.querySelector('#nombre').value = "";
        document.querySelector('#matricula').value = "";

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