window.addEventListener('load', function () {
        //con fetch invocamos a la API de peliculas con el método GET
        //nos devolverá un JSON con una colección de peliculas
        const url = '/odontologos';
        const settings = {
            method: 'GET'
        }

        fetch(url,settings)
            .then(response => response.json())
            .then(data => {
                //recorremos la colección de peliculas del JSON
                for(odontologo of data){
                    //por cada pelicula armaremos una fila de la tabla
                    //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pelicula
                    var table = document.getElementById("odontologoTable");
                    var odontologoRow =table.insertRow();
                    let tr_id = 'tr_' + odontologo.id;
                    odontologoRow.id = tr_id;

                    let deleteLink='<a id=\"a_delete_'+odontologo.id+'\"'+
                        ' href=\"#\" onclick=\"deleteBy('+odontologo.id+')\"'+
                        ' class=\"link-danger\">Borrar</a>';

                    let updateLink='<a id=\"a_update_'+odontologo.id+'\"'+
                        ' href=\"../update_odontologo.html\"'+
                        ' class=\"link-danger\">Actualizar</a>';

                    //armamos cada columna de la fila
                    //como primer columna pondremos el boton modificar
                    //luego los datos de la pelicula
                    //como ultima columna el boton eliminar
                    odontologoRow.innerHTML =
                        '<td class=\"td_id\">' + odontologo.id + '</td>' +
                        '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>' +
                        '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                        '<td class=\"td_matricula\">' + odontologo.matricula + '</td>'+
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