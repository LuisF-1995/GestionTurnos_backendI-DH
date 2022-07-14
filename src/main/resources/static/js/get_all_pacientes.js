window.addEventListener('load', function () {
    //con fetch invocamos a la API de peliculas con el método GET
    //nos devolverá un JSON con una colección de peliculas
    const url = '/pacientes';
    const settings = {
        method: 'GET'
    }

    fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            for(paciente of data){
                var table = document.getElementById("odontologoTable");
                var pacienteRow =table.insertRow();
                let tr_id = 'tr_' + paciente.id;
                pacienteRow.id = tr_id;

                let deleteLink='<a id=\"deletePaciente_'+paciente.id+'\"'+
                ' href=\"#\" onclick=\"deletePacienteBy('+paciente.id+')\"'+
                ' class=\"link-danger\">Borrar</a>';

                let updateLink='<a id=\"a_update_'+paciente.id+'\"'+
                    ' href=\"../update_paciente.html\"'+
                    ' class=\"link-danger\">Actualizar</a>';


                //armamos cada columna de la fila
                //datos del paciente
                //como ultima columna el boton eliminar
                pacienteRow.innerHTML =
                    '<td class=\"td_id\">' + paciente.id + '</td>' +
                    '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_email\">' + paciente.email + '</td>'+
                    '<td class=\"td_dni\">' + paciente.dni + '</td>'+
                    '<td class=\"td_fechaIngreso\">' + paciente.fechaIngreso + '</td>'+

                    '<td class=\"td_domicilio\">' + paciente.domicilio.calle.toUpperCase() + " " +  paciente.domicilio.numero + ", " +
                                                    paciente.domicilio.localidad.toUpperCase() + "-"+paciente.domicilio.provincia.toUpperCase() +'</td>'+

                    '<td>'+deleteLink+'</td>'+
                    '<td>'+updateLink+'</td>';

            };

        })

    /*
(function(){
    let pathname = window.location.pathname;
    if (pathname == "/peliculaList.html") {
        document.querySelector(".nav .nav-item a:last").addClass("active");
    }
})

     */


})