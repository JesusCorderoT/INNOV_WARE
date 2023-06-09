/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var xhr;

function createObjeto() {
    if (window.ActiveXObject) {
        xhr = new ActiveXObject("Microsoft.XMLHttp");

    } else if ((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined) {
        xhr = new XMLHttpRequest();

    } else {
        alert("su navegador no soporta AJAX");
        return;

    }
}

var divInicial = "inicio";

function DinamicoDiv(divActual) {
    // alert("Dinamico activado");
    document.getElementById(divActual).style.display = "block";
    if (divInicial != divActual) {
        document.getElementById(divInicial).style.display = "none";
    }
    divInicial = divActual;
}


////////////////////////////////////////////////////////////////////////////////

function formRegistrarProducto() {
    createObjeto();
    //alert("Objeto creado");
    enviarPeticionFormRegistrarProducto();
}

function enviarPeticionFormRegistrarProducto() {
    // alert("Enviando peticion");
    xhr.open("GET", "Form_Registrar_Productos1", true);
    xhr.onreadystatechange = verificarDetallesFormRegistrarProducto;
    // alert("Peticion enviada");
    xhr.send(null);
}

function verificarDetallesFormRegistrarProducto() {
    //alert("Peticion recibida");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaTodosLosProcudtos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function registrarProducto() {
    // alert("Registrar Obra");
    createObjeto();
    //alert("objeto creado");
    enviarRegistrarProducto();
    //alert("Creado");
}

function enviarRegistrarProducto() {
    //alert("Variables entrando");
    var nombrePro = document.getElementById("nombreProducto").value;
    // alert(nombrePro);
    var costo = document.getElementById("costo").value;
    // alert(costo);
    var imagen = document.getElementById("imagen").value;
    //alert(imagen);
    var descripcion = document.getElementById("descripcion").value;
    // alert(descripcion);
    xhr.open("GET", "Registrar_Producto?nombreProducto=" + nombrePro + "&costo=" + costo + "&imagen=" + imagen + "&descripcion=" + descripcion, true);
    xhr.onreadystatechange = verificaRegistrarProducto;
    xhr.send(null);
}

function verificaRegistrarProducto() {
    // alert("verificado");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaRegistrarProducto").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////

function formMostrarTodosLosProductos() {
    createObjeto();
    //alert("Objeto creado");
    enviarPeticionMostrarTodosLosProductos();
}

function enviarPeticionMostrarTodosLosProductos() {
    // alert("Enviando peticion");
    xhr.open("GET", "Mostrar_Todos_Los_Productos", true);
    xhr.onreadystatechange = verificarDetallesMostrarTodosLosProductos;
    // alert("Peticion enviada");
    xhr.send(null);
}

function verificarDetallesMostrarTodosLosProductos() {
    //alert("Peticion recibida");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaTodosLosProcudtos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function eliminarProductoChido(id) {
    // alert(id);
    createObjeto();
    var id_pro = id;
    peticioneliminarProductoChido(id_pro);

}

function peticioneliminarProductoChido(id_producto) {
    var id_produc = id_producto;

    // alert("Id dentro de la sugunda funcion"+id_produc);
    //alert("Titulo antes de get");
    xhr.open("GET", "Form_Eliminar_Producto?id_producto=" + id_produc, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificareliminarProductoChido;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificareliminarProductoChido() {
    // alert("Petición Regresaer Eliminar obras");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaElimianrProducto").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function eliminarProductoChido2() {
    //alert("Primera funcion");
    createObjeto();
    peticioneliminarProductoChido2();

}

function peticioneliminarProductoChido2() {
    var id_producto = document.getElementById("id_producto").value;
    ;
    var nombre_producto = document.getElementById("nombre_producto").value;

    // alert(id_producto);
    //alert(nombre_producto);
    //alert("Titulo antes de get");
    xhr.open("GET", "Eliminar_Producto?id_producto=" + id_producto + "&nombre_producto=" + nombre_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificareliminarProductoChido2;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificareliminarProductoChido2() {
    // alert("Petición Regresaer Eliminar obras");
    if (xhr.readyState === 4) {
        document.getElementById("RespEliminiacionCOrrecta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function formEditarProducto(id) {
    //alert("1");
    var id_pro = id;
    createObjeto();
    enviarPeticionformEditarProducto(id_pro);
}

function enviarPeticionformEditarProducto(id_producto) {

    var id_product = id_producto;
    // alert(id_product);
    xhr.open("GET", "Form_Editar_Producto?id_producto=" + id_product, true);
    xhr.onreadystatechange = verificarDetallesformEditarProducto;
    // alert("Peticion enviada");
    xhr.send(null);
}

function verificarDetallesformEditarProducto() {
    // alert("3");
    //alert("Peticion recibida");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaElimianrProducto").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function EditarProducto() {
    createObjeto();
    enviarPeticionEditarProducto();
}

function enviarPeticionEditarProducto() {
    var id_producto = document.getElementById("id_producto").value;
    alert(id_producto);
    var nombre_producto = document.getElementById("nombreProducto").value;
    alert(nombre_producto);
    var descripcion = document.getElementById("descripcion").value;
    alert(descripcion);
    var costo = document.getElementById("costo").value;
    alert(costo);
    var imagen = document.getElementById("imagen").value;
    alert(imagen);

    xhr.open("GET", "Editar_Producto?id_producto=" + id_producto + "&nombre_producto=" + nombre_producto + "&descripcion=" + descripcion + "&costo=" + costo + "&imagen=" + imagen, true);
    xhr.onreadystatechange = verificarDetallesEditarProducto;
    // alert("Peticion enviada");
    xhr.send(null);
}

function verificarDetallesEditarProducto() {
    //alert("3");
    //alert("Peticion recibida");
    if (xhr.readyState === 4) {
        document.getElementById("ProductoEditado").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function masOpcionesAgregarDescripcionProd(id) {
    //alert("objeto"); 
    //alert(id);
    var id_Pro = id;
    createObjeto();
    peticionOpcionesAgregarDescripcionProd(id_Pro);

}

function peticionOpcionesAgregarDescripcionProd(id_prod) {
    var id_producto = id_prod;
    //alert(id_producto);
    //alert("Titulo antes de get");
    xhr.open("GET", "Mas_Opciones?id_producto=" + id_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarOpcionesAgregarDescripcionProd;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarOpcionesAgregarDescripcionProd() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaElimianrProducto").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function eliminarDescripcion(id) {
    //alert("objeto"); 
    //alert(id);
    var id_Pro = id;
    createObjeto();
    peticioneliminarDescripcion(id_Pro);

}

function peticioneliminarDescripcion(id_prod) {
    var id_producto = id_prod;
    alert(id_producto);
    //alert("Titulo antes de get");
    xhr.open("GET", "Eliminar_Descripcion?id_producto=" + id_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificareliminarDescripcion;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificareliminarDescripcion() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function editarDescripcion(id) {
    //alert("objeto"); 
    //alert(id);
    var id_Pro = id;
    createObjeto();
    peticioneditarDescripcion(id_Pro);

}

function peticioneditarDescripcion(id_prod) {
    var id_producto = id_prod;
    alert(id_producto);
    //alert("Titulo antes de get");
    xhr.open("GET", "Form_Editar_Descripcion?id_producto=" + id_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificareditarDescripcion;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificareditarDescripcion() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function editarDescripcionFinal() {
    //alert("objeto"); 
    //alert(id);

    createObjeto();
    peticioneditarDescripcionFinal();

}

function peticioneditarDescripcionFinal() {
    var id_producto = document.getElementById("id_Pro1").value;
    alert(id_producto);
    var desc = document.getElementById("descripcionActual").value;
    alert(desc);
    alert("Titulo antes de get");
    xhr.open("GET", "Editar_Descripcion?id_producto=" + id_producto + "&descripcion=" + desc, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificareditarDescripcionFinal;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificareditarDescripcionFinal() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaEditarDesc").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////


function formRegistrarProducto2(id) {
    createObjeto();
    var id2 = id;
    alert("Objeto creado");
    enviarPeticionFormRegistrarProducto2(id2);
}

function enviarPeticionFormRegistrarProducto2(id_2) {
    var id_producto = id_2;
 //   alert(id_producto);
    xhr.open("GET", "Agregar_Descripcion?id_producto=" + id_producto, true);
    xhr.onreadystatechange = verificarDetallesFormRegistrarProducto2;
    // alert("Peticion enviada");
    xhr.send(null);
}

function verificarDetallesFormRegistrarProducto2() {
 //   alert("Peticion recibida");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


////////////////////////////////////////////////////////////////////////////////

function agregarDescripcionFinal() {
    //alert("objeto"); 
    //alert(id);

    createObjeto();
    peticionagregarDescripcionFinal();

}

function peticionagregarDescripcionFinal() {
    var id_producto = document.getElementById("id_Pro").value;
 //   alert(id_producto);
    var desc = document.getElementById("descripcionActual").value;
 //   alert(desc);
 //   alert("Titulo antes de get");
    xhr.open("GET", "Agregar_Descripcion_Final?id_producto=" + id_producto + "&descripcion=" + desc, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificaragregarDescripcionFinal;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificaragregarDescripcionFinal() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaEditarDesc").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function eliminarImagenProducto(id) {
    var id_pro = id;
    //alert("Primera funcion");
    createObjeto();
    peticioneliminarImagenProducto(id_pro);

}

function peticioneliminarImagenProducto(id_pro) {
    var id_producto = id_pro;
 //   alert(id_producto);
    xhr.open("GET", "Eliminar_Imagen?id_producto=" + id_producto, true);
    xhr.onreadystatechange = verificareliminarImagenProducto;

    xhr.send(null);
}

function verificareliminarImagenProducto() {
    // alert("Petición Regresaer Eliminar obras");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function formActualizarImagen(id) {
 //   alert("objeto");
 //   alert(id);
    var id_Pro = id;
    createObjeto();
    peticionformActualizarImagen(id_Pro);

}

function peticionformActualizarImagen(id_prod) {
    var id_producto = id_prod;
 //   alert(id_producto);
    //alert("Titulo antes de get");
    xhr.open("GET", "Form_Actualizar_Imagen?id_producto=" + id_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarformActualizarImagen;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarformActualizarImagen() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function actualizarImagen() {
    //alert("objeto"); 
    createObjeto();
    peticionactualizarImagen();

}

function peticionactualizarImagen() {
    var id_producto = document.getElementById("id_producto").value;
 //   alert(id_producto);
    var imagen = document.getElementById("imagen").value;
 //   alert(imagen);
 //   alert("Titulo antes de get");
    xhr.open("GET", "Actualizar_Imagen?id_producto=" + id_producto + "&imagen=" + imagen, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificaractualizarImagen;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificaractualizarImagen() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function formAgregarImagen1(id) {
 //   alert("objeto");
 //   alert(id);
    var id_Pro = id;
    createObjeto();
    peticionformAgregarImagen(id_Pro);

}

function peticionformAgregarImagen(id_prod) {
    var id_producto = id_prod;
    alert(id_producto);
    //alert("Titulo antes de get");
    xhr.open("GET", "Form_Agregar_Imagen?id_producto=" + id_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarformAgregarImagen;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarformAgregarImagen() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}



////////////////////////////////////////////////////////////////////////////////

function agregarImagen() {
    //alert("objeto"); 
    createObjeto();
    peticionagregarImagen();

}

function peticionagregarImagen() {
    var id_producto = document.getElementById("id_producto").value;
 //   alert(id_producto);
    var imagen = document.getElementById("imagen").value;
 //   alert(imagen);
 //   alert("Titulo antes de get");
    xhr.open("GET", "Agregar_Imagen?id_producto=" + id_producto + "&imagen=" + imagen, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificaragregarImagen;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificaragregarImagen() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function buscarProductoNombre() {
 //   alert("objeto");
    createObjeto();
    peticionbuscarProductoNombre();

}

function peticionbuscarProductoNombre() {
    var nombre_producto = document.getElementById("nombre_productoJ").value;
 //   alert(nombre_producto);

 //   alert("Titulo antes de get");
    xhr.open("GET", "Buscar_Producto_Por_Nombre?nombre_producto=" + nombre_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarbuscarProductoNombre;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarbuscarProductoNombre() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaTodosLosProcudtos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//////////////****************++++++++++++++++++++----------------------------//////////////////////////

function buscarProductoNombreUser() {
    //alert("objeto"); 
    createObjeto();
    peticionbuscarProductoNombreUser();

}

function peticionbuscarProductoNombreUser() {
    var nombre_producto = document.getElementById("nombre_producto").value;
    // alert(nombre_producto);

    //alert("Titulo antes de get");
    xhr.open("GET", "PruebasUser?nombre_producto=" + nombre_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarbuscarProductoNombreUser;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarbuscarProductoNombreUser() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaTodosLosProcudtos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function formAgregarPendiente(id, nom, desc, cost) {
    //alert("objeto"); 
    //alert(id);
    var id_Pro = id;
    var nombre = nom;
    var descr = desc;
    var costo = cost;
    createObjeto();
    peticionformAgregarPendiente(id_Pro, nombre, descr, costo);

}

function peticionformAgregarPendiente(id_Pro, nombre, descr, costo) {
    var id_producto = id_Pro;
    var nombre_producto = nombre;
    var descripcion = descr;
    var costo_Producto = costo;
 //   alert(id_producto);
    //alert("Titulo antes de get");
    xhr.open("GET", "PruebasUser?id_user=" + id_producto + "&nombre_producto=" + nombre_producto + "&descripcion=" + descripcion + "&costo=" + costo_Producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarformAgregarPendiente;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarformAgregarPendiente() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function añadirListaPendiente() {
    // alert("Registrar Obra");
    createObjeto();
    //alert("objeto creado");
    peticionañadirListaPendiente();
    //alert("Creado");
}

function peticionañadirListaPendiente() {
 //   alert("Variables entrando");
    var id_producto = document.getElementById("id_producto").value;
 //   alert(id_producto);
    var nombre_producto = document.getElementById("nombre_producto").value;
 //   alert(nombre_producto);
    var costo = document.getElementById("costo").value;
 //   alert(costo);
    var id_usuario = document.getElementById("iduser").value;
 //   alert(id_usuario);
    xhr.open("GET", "Agregar_Lista_Pendiente?id_producto=" + id_producto + "&nombre_producto=" + nombre_producto + "&costo=" + costo + "&iduser=" + id_usuario, true);
    xhr.onreadystatechange = verificaañadirListaPendiente;
    xhr.send(null);
}

function verificaañadirListaPendiente() {
    // alert("verificado");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaListaPendiente").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////


function ProductoDisponible(id) {
 //   alert("objeto");
    //alert(id);
    var aidi = id;
    createObjeto();
    peticionProductoDisponible(aidi);

}

function peticionProductoDisponible(aidi) {
    var id_producto = aidi;
 //   alert(id_producto);
 //   alert("Titulo antes de get");
    xhr.open("GET", "Producto_Disponible?id_producto=" + id_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarProductoDisponible;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarProductoDisponible() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////

function ProductoNoDisponible(id) {
 //   alert("objeto");
    //alert(id);
    var aidi = id;
    createObjeto();
    peticionProductoNoDisponible(aidi);

}

function peticionProductoNoDisponible(aidi) {
    var id_producto = aidi;
 //   alert(id_producto);
 //   alert("Titulo antes de get");
    xhr.open("GET", "Producto_NoDisponible?id_producto=" + id_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarProductoNoDisponible;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarProductoNoDisponible() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function formMasOpcionesCliente(id) {
    //alert("objeto");
    //alert(id);
    var aidi = id;
    createObjeto();
    peticionMasOpcionesCliente(aidi);

}

function peticionMasOpcionesCliente(aidi) {
    var id_producto = aidi;
    //alert(id_producto);
    //alert("Titulo antes de get");
    xhr.open("GET", "Mas_OpcionesCliente?id_producto=" + id_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarMasOpcionesCliente;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarMasOpcionesCliente() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////


function formGarantia(id) {
    //alert("objeto");
    //alert(id);
    var aidi = id;
    createObjeto();
    peticionformGarantia(aidi);

}

function peticionformGarantia(aidi) {
    var id_producto = aidi;
    //alert(id_producto);
    //alert("Titulo antes de get");
    xhr.open("GET", "Form_Garantia?id_producto=" + id_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarformGarantia;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarformGarantia() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//////////////////////////////////////////////////////////////


function GenerarGarantia(id) {
    //alert("objeto");
    //alert(id);
    var aidi = id;
    createObjeto();
    peticionGenerarGarantia(aidi);

}

function peticionGenerarGarantia(aidi) {
    var id_producto = aidi;
    var id_cliente = document.getElementById("id_cliente").value;
    var motivo = document.getElementById("motivoGarantia").value;
    //alert(id_producto);
    //alert(id_cliente);
    //alert(motivo);
    xhr.open("GET", "GenerarGarantiaBD?id_producto=" + id_producto + "&id_cliente=" + id_cliente + "&motivo=" + motivo, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarGenerarGarantia;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarGenerarGarantia() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("AnswerFormGarantia").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function AgregarCotizacion(id) {
    //alert("objeto");
    //alert(id);
    var aidi = id;
    createObjeto();
    peticionAgregarCotizacion(aidi);

}

function peticionAgregarCotizacion(aidi) {
    var id_producto = aidi;
    //var id_cliente = document.getElementById("id_cliente").value;
    //var motivo = document.getElementById("motivoGarantia").value;
    //alert(id_producto);
    //alert(id_cliente);
    //alert(motivo);
    xhr.open("GET", "Agregar_Lista_Cotizacion?id_producto=" + id_producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarAgregarCotizacion;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarAgregarCotizacion() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaElimianrProducto").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function RegistrarCotizacion() {
    //alert("objeto");
    createObjeto();
    peticionRegistrarCotizacion();

}

function peticionRegistrarCotizacion() {
    var descripcion = document.getElementById("descripcionCoti").value;
    var totalCotizacion = document.getElementById("totalCoti").value;
    var fecha = document.getElementById("fecha").value;
    var id_cliente = document.getElementById("id_cliente").value;
    //alert(descripcion);
    //alert(totalCotizacion);
    //alert(fecha);
    //alert(id_cliente);

    xhr.open("GET", "Agregar_A_CotiBD?descripcion=" + descripcion + "&totalCotizacion=" + totalCotizacion + "&fecha=" + fecha + "&id_cliente=" + id_cliente, true);

    xhr.onreadystatechange = verificarRegistrarCotizacion;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarRegistrarCotizacion() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("AnswerCotizacionBD").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function FormMisProductos() {
    // alert("objeto");
    createObjeto();
    peticionFormMisProductos();

}

function peticionFormMisProductos() {
    // var descripcion = document.getElementById("descripcionCoti").value;
    // var totalCotizacion = document.getElementById("totalCoti").value;
    // var fecha = document.getElementById("fecha").value;
    // var id_cliente = document.getElementById("id_cliente").value;
    //alert(descripcion);
    //alert(totalCotizacion);
    //alert(fecha);
    //alert(id_cliente);

    xhr.open("GET", "Form_Mis_Productos", true);

    xhr.onreadystatechange = verificarFormMisProductos;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarFormMisProductos() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaTodosLosProcudtos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

///////////////////////////////////////////////////////////////////////////////

function MostrarMisProductos() {
    // alert("objeto");
    createObjeto();
    peticionMostrarMisProductos();

}

function peticionMostrarMisProductos() {
    var id_usuarios = document.getElementById("id_para_productos").value;
    // var totalCotizacion = document.getElementById("totalCoti").value;
    // var fecha = document.getElementById("fecha").value;
    // var id_cliente = document.getElementById("id_cliente").value;
    //alert(descripcion);
    //alert(totalCotizacion);
    //alert(fecha);
    //alert(id_cliente);

    xhr.open("GET", "Mostrar_Mis_Productos?id_user=" + id_usuarios, true);

    xhr.onreadystatechange = verificarMostrarMisProductos;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarMostrarMisProductos() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("AnswerMisProductos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function calificaProductoLike(id) {
    //alert("objeto");
    createObjeto();
    var aidi = id;
    peticioncalificaProductoLike(aidi);

}

function peticioncalificaProductoLike(aidi) {
    //var id_usuarios = document.getElementById("id_para_productos").value;
    // var totalCotizacion = document.getElementById("totalCoti").value;
    // var fecha = document.getElementById("fecha").value;
    var id_producto = aidi;
    //alert(descripcion);
    //alert(totalCotizacion);
    //alert(fecha);
    //alert(id_cliente);
    //alert("xD");
    xhr.open("GET", "Calificacion_Buena?id_producto=" + id_producto, true);

    xhr.onreadystatechange = verificarcalificaProductoLike;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarcalificaProductoLike() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("AnswerCalificacion").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////


function calificaProductoDisLike(id) {
    //alert("objeto");
    createObjeto();
    var aidi = id;
    peticioncalificaProductoDisLike(aidi);

}

function peticioncalificaProductoDisLike(aidi) {
    //var id_usuarios = document.getElementById("id_para_productos").value;
    // var totalCotizacion = document.getElementById("totalCoti").value;
    // var fecha = document.getElementById("fecha").value;
    var id_producto = aidi;
    //alert(descripcion);
    //alert(totalCotizacion);
    //alert(fecha);
    //alert(id_cliente);
    //alert("xD");
    xhr.open("GET", "Calificacion_Mala?id_producto=" + id_producto, true);

    xhr.onreadystatechange = verificarcalificaProductoDisLike;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarcalificaProductoDisLike() {
    //alert("Verificacion");
    if (xhr.readyState === 4) {
        document.getElementById("AnswerCalificacion").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

////////////////////////////////////////////////////////////////////////////////

function  formularioAgregarPendiente(id, nom, desc, cost) {
    var id_Pro = id;
    var nombre = nom;
    var descr = desc;
    var costo = cost;
    createObjeto();
    peticionformAgregarPendiente1(id_Pro, nombre, descr, costo);

}

function peticionformularioAgregarPendiente(id_Pro, nombre, descr, costo) {
    var id_producto = id_Pro;
    var nombre_producto = nombre;
    var descripcion = descr;
    var costo_Producto = costo;
    //alert(id_producto);
    xhr.open("GET", "From_Mis_Productos?id_user=" + id_producto + "&nombre_producto=" + nombre_producto + "&descripcion=" + descripcion + "&costo=" + costo_Producto, true);
    //xhr.open("GET", "Pruebas", true);
    xhr.onreadystatechange = verificarformAgregarPendiente1;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarformularioAgregarPendiente() {
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaMasOpciones2").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}




////////////


function Prueba() {
    createObjeto();
    //alert("Objeto creado");
    prueba2();
}

function prueba2() {
    var nombre_producto = document.getElementById("nombre_producto").value;
    //alert(nombre_producto);
    //alert("Enviando peticion chida");
    xhr.open("GET", "Servlet_Universal?nombre_producto=" + nombre_producto, true);
    xhr.onreadystatechange = prueba3;
    // alert("Peticion enviada");
    xhr.send(null);
}

function prueba3() {
    //alert("Peticion recibida");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaTodosLosProcudtos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


/////////////////////////////////////////////


function Prueba1() {
    createObjeto();
    //alert("Objeto creado");
    prueba1_1();
}

function prueba1_1() {
    var nombre_producto = document.getElementById("nombre_producto").value;
    //alert(nombre_producto);
    //alert("Enviando peticion chida");
    xhr.open("GET", "Servlet_Universal?nombre_producto=" + nombre_producto, true);
    xhr.onreadystatechange = prueba1_1_1;
    // alert("Peticion enviada");
    xhr.send(null);
}

function prueba1_1_1() {
    //alert("Peticion recibida");
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaTodosLosProcudtos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

///////////////////////////////////////////////////////////////////////////////


function FormMostarGarantia(id) {
    //alert("objeto");
    createObjeto();
    var aidi = id;
    peticionFormMostrarGarantia(aidi);
}

function peticionFormMostrarGarantia(aidi) {
    var id_producto = aidi;
    //var descripcion = document.getElementById("problema_producto").value;
    // var fecha = document.getElementById("fecha").value;
    var id_producto = aidi;
    // alert(id_producto);
    //alert(descripcion);
    //alert(fecha);
    //alert(id_cliente);
    // alert("xD");
    xhr.open("GET", "Form_Mostrar_Garantia?id_producto=" + id_producto, true);

    xhr.onreadystatechange = verificarFormMotstrarGarantia;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificarFormMotstrarGarantia() {
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaTodosLosProcudtos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

/////////////////////////////////////////////////////////////////////////////////


function garantiaAtendida(id) {
    //alert("objeto");
    createObjeto();
    var aidi = id;
    peticiongarantiaAtendida(aidi);
}

function peticiongarantiaAtendida(aidi) {
    var id_producto = aidi;
    //var descripcion = document.getElementById("problema_producto").value;
    // var fecha = document.getElementById("fecha").value;
    var id_producto = aidi;
    // alert(id_producto);
    //alert(descripcion);
    //alert(fecha);
    //alert(id_cliente);
    // alert("xD");
    xhr.open("GET", "Garantia_Atendida?id_garantia=" + id_producto, true);

    xhr.onreadystatechange = verificargarantiaAtendida;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificargarantiaAtendida() {
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaTodosLosProcudtos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


///////////////////////////////////////////////////////////////////////////////



function garantiaAtendidaNo(id) {
    //alert("objeto");
    createObjeto();
    var aidi = id;
    peticiongarantiaAtendidaNo(aidi);
}

function peticiongarantiaAtendidaNo(aidi) {
    var id_producto = aidi;
    //var descripcion = document.getElementById("problema_producto").value;
    // var fecha = document.getElementById("fecha").value;
    var id_producto = aidi;
    // alert(id_producto);
    //alert(descripcion);
    //alert(fecha);
    //alert(id_cliente);
    // alert("xD");
    xhr.open("GET", "Garantia_No_Atendida?id_garantia=" + id_producto, true);

    xhr.onreadystatechange = verificargarantiaAtendidaNo;
    //alert("Elemento verificado");
    xhr.send(null);
}

function verificargarantiaAtendidaNo() {
    if (xhr.readyState === 4) {
        document.getElementById("RespuestaTodosLosProcudtos").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}