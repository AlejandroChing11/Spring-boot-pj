// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios();

  $('#usuarios').DataTable();
});

async function cargarUsuarios() {

      const request = await fetch('api/users', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      const usuarios = await request.json();





      let listadoHtml = '';
      for (let usuario of usuarios) {
        
        let botonEliminar = '<a href="#" onClick="eliminarUsuarios('+ usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'

        let telefonoTexto = usuario.telefono == null ? '-' : usuario.telefono
          let usuarioHTML = 
              '<tr><td>' + usuario.id + '</td><td>' + usuario.name + ' ' + usuario.lastName + '</td><td>' 
              + usuario.email + '</td><td>' + telefonoTexto
              + '</td><td>'+ botonEliminar + '</td></tr>'
          listadoHtml += usuarioHTML
      }
document.querySelector("#usuarios tbody").outerHTML = listadoHtml; 


}


async function eliminarUsuarios(id) {
  if (!confirm("¿Desea eliminar este usuario? ")) {
      return;
  }


  const request = await fetch('api/users/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });

  location.reload();


}
