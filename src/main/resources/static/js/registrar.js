// Call the dataTables jQuery plugin
$(document).ready(function() {
    //On ready
});

async function registrarUsuario() {
    let datos = {};
    datos.name = document.getElementById('txtNombre').value;
    datos.lastName = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let repetirPassword = document.getElementById('txtRepetirPassword').value;

    if (repetirPassword != datos.password) {
        alert('La contraseña que escribisite no coincide');
        return;
    }

    const request = await fetch('api/users', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos)
    });
}


