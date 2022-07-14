window.addEventListener('load', function () {

    const url = '/turnos';
    const settings = {
        method: 'GET'
    }

    fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            for(turno of data){

                var table = document.getElementById("odontologoTable");
                var turnoRow =table.insertRow();
                let tr_id = 'tr_' + turno.id;
                turnoRow.id = tr_id;

                let deleteLink='<a id=\"a_delete_'+turno.id+'\"'+
                    ' href=\"#\" onclick=\"deleteTurnoBy('+turno.id+')\"'+
                    ' class=\"link-danger\">Borrar</a>';

                let updateLink='<a id=\"a_update_'+turno.id+'\"'+
                    ' href=\"../update_turno.html\"'+
                    ' class=\"link-danger\">Actualizar</a>';

                turnoRow.innerHTML =
                    '<td class=\"td_id\">' + turno.id + '</td>' +
                    '<td class=\"td_apellidoNombrePaciente\">' + turno.paciente.apellido.toUpperCase() + " " + turno.paciente.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_DNIpaciente\">' + turno.paciente.dni + '</td>' +
                    '<td class=\"td_apellidoNombreOdontologo\">' + turno.odontologo.apellido.toUpperCase() + " " + turno.odontologo.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_matricula\">' + turno.odontologo.matricula.toUpperCase() + '</td>'+
                    '<td class=\"td_fechaCita\">' + turno.fecha + '</td>'+
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