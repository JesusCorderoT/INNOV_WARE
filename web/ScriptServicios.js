
var xhr;

function crearObjeto() {
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

function DinamicoDiv(divActual)
{
    document.getElementById(divActual).style.display = 'block';
    if (divInicial != divActual) {
        document.getElementById(divInicial).style.display = 'none';
    }
    divInicial = divActual;
}
/// Registrar servicios
function formularioRegistar() {
    crearObjeto();
    enviapeticionFReg();
}

function enviapeticionFReg() {
    xhr.open("GET", "formRegistrar", true);
    xhr.onreadystatechange = verificarDetalleFReg;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificarDetalleFReg() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function registrarServicio(){
    //alert("bien");
    crearObjeto();
    peticionRegistrarServicio();
}

function peticionRegistrarServicio(){
    //alert("entramos");
    var nombreR= document.getElementById("nombre").value;
    var categoriaR= document.getElementById("categoria").value;
    var costoR= document.getElementById("costo").value;
    var imagenR= document.getElementById("imagen").value;
    //alert(nombreR+categoriaR+costoR+imagenR);
    xhr.open("GET", "RegistrarServicios?nombreR="+nombreR+" &costoR="+costoR+" &categoriaR="+categoriaR+" &imagenR="+imagenR, true);
    xhr.onreadystatechange = detalleRegistraServicios;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function detalleRegistraServicios(){
    if (xhr.readyState == 4) {
        document.getElementById("mostrarR").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Consulta de servicios
function formularioConsultarServicios() {
    crearObjeto();
    enviapeticionFConsultarS();
}

function enviapeticionFConsultarS() {
    xhr.open("GET", "formBuscarServicios", true);
    xhr.onreadystatechange = verificarDetalleConsultarS;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificarDetalleConsultarS() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//busqueda por nombre
function buscarServicioNombre(){
    crearObjeto();
    peticionBSNombre();
}

function peticionBSNombre(){
    var nombre=document.getElementById("nombre").value;
    //alert(nombre);
        xhr.open("GET", "BusquedaNombreServicios?nombre="+nombre, true);
    xhr.onreadystatechange = detalleBusquedaSNombre;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
    
}

function detalleBusquedaSNombre(){
     if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//busqueda por categoria
function busquedaServicioCategoria(){
    crearObjeto();
    peticionServicioCategoria();
}
function peticionServicioCategoria(){
        var categoria=document.getElementById("categoria").value;
   // alert(categoria);
        xhr.open("GET", "BusquedaCategoriaServicios?categoria="+categoria, true);
    xhr.onreadystatechange = detalleServicioCategoria;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleServicioCategoria(){
         if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//Mostrar todos los servicios
function mostrarServicios(){
    crearObjeto();
    peticionMostrarServicios();
}
function peticionMostrarServicios(){
        
   // alert(categoria);
        xhr.open("GET", "MostrarServicios", true);
    xhr.onreadystatechange = detalleMostrarServicios;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleMostrarServicios(){
         if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//busqueda por calificacion
function busquedaServicioCalificacion(){
    crearObjeto();
    peticionServicioCalificacion();
}
function peticionServicioCalificacion(){
        var calificacion=document.getElementById("calificacion").value;
    //alert(calificacion);
        xhr.open("GET", "BusquedaCalificacionServicios?calificacion="+calificacion, true);
    xhr.onreadystatechange = detalleServicioCalificacion;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleServicioCalificacion(){
         if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//Registro de descripcion de servicio

function formularioRegistrarDescripcionServicio() {
    crearObjeto();
    enviapeticionRegistroDescripcion();
}

function enviapeticionRegistroDescripcion() {
    xhr.open("GET", "formRegistrarDescripcion", true);
    xhr.onreadystatechange = verificarDetalleRegistarDescripcion;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificarDetalleRegistarDescripcion() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
function registrarDescripcionServicio(){
    //alert("bien");
    crearObjeto();
    peticionRegistrarDescripcionServicio();
}

function peticionRegistrarDescripcionServicio(){
    //alert("entramos");
    var idR= document.getElementById("id").value;
    var descripcionR= document.getElementById("descripcion").value;
    
    //alert(nombreR+categoriaR+costoR+imagenR);
    xhr.open("GET", "RegistrarDescripcionServicio?idR="+idR+" &descripcionR="+descripcionR, true);
    xhr.onreadystatechange = detalleRegistraDescripcionServicios;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function detalleRegistraDescripcionServicios(){
    if (xhr.readyState == 4) {
        document.getElementById("mostrarReg").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//buscar descripcion de servicio
function formularioBuscarDescripcionServicio() {
    crearObjeto();
    enviapeticionBusquedaDescripcion();
}

function enviapeticionBusquedaDescripcion() {
    xhr.open("GET", "formBuscarDescripcionServicio", true);
    xhr.onreadystatechange = verificarDetalleBuscarDescripcion;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificarDetalleBuscarDescripcion() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Busqueda por palabra
function busquedaDescripcionServicioPalabra(){
    //alert("uno");
    crearObjeto();
    peticionDescripcionServicioPalabra();
}
function peticionDescripcionServicioPalabra(){
        var palabra=document.getElementById("palabra").value;
    //alert(palabra);
        xhr.open("GET", "BusquedaDescripcionPalabra?palabra="+palabra, true);
    xhr.onreadystatechange = detalleDescripcionServicioPalabra;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleDescripcionServicioPalabra(){
         if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//Busqueda por nombre del servicio
function busquedaDescripcionServicioNombre(){
    //alert("entramos");
    crearObjeto();
    peticionDescripcionServicioNombre();
}
function peticionDescripcionServicioNombre(){
        var name=document.getElementById("name").value;
    alert(name);
        xhr.open("GET", "BusquedaDescripcionNombre?name="+name, true);
    xhr.onreadystatechange = detalleDescripcionServicioNombre;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleDescripcionServicioNombre(){
         if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Eliminar Servicios
function confirmarEliminacion(){
    crearObjeto();
    peticionConfirmarEliminacion();
}

function peticionConfirmarEliminacion(){
    var id=document.getElementById("id").value;
    xhr.open("GET","ConfirmarEliminacionServicio?id="+id,true);
    xhr.onreadystatechange=detalleConfirmarEliminar;
    xhr.send(null);       
}

function detalleConfirmarEliminar(){
     if (xhr.readyState === 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
function eliminarServicioConf(){
    alert("vamos bien xdxd");
    crearObjeto();
    eliminacionFinalServicio();
}
function eliminacionFinalServicio(){
    //alert("si baja mami si baja");
    var id= document.getElementById("id").value;
    var confirmacion=document.getElementById("confirmacion").value;
   
    alert(id+confirmacion);
    xhr.open("GET", "EliminarServicio?id="+id+" &confirmacion="+confirmacion, true);
    xhr.onreadystatechange = detalleConfEliminar;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleConfEliminar(){
   
            if (xhr.readyState === 4) {
        document.getElementById("mensajeConfirmacion").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//Actualizar servicio
function formActualizarServicio(){
    //alert("vamos bien xdxd")
    crearObjeto();
    peticionActualizarServicio();
}
function peticionActualizarServicio(){
    var id=document.getElementById("id").value;
    var costo=document.getElementById("costo").value;
    var nombre=document.getElementById("name").value;
    var categoria=document.getElementById("cate").value;
    //alert(id+costo+nombre+categoria);
    //alert(nombre);
    xhr.open("GET", "FormActualizarServicio?id="+id+" &costo="+costo+" &nombre="+nombre+" &categoria="+categoria, true);
    xhr.onreadystatechange = detalleActualizarServicio;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleActualizarServicio(){
   
            if (xhr.readyState == 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    
    }
}

function actualizarServicio(){
    crearObjeto();
    peticionActualizarServicioFin();
}

function peticionActualizarServicioFin(){
     var id=document.getElementById("id").value;
    var costo=document.getElementById("costoN").value;
    var nombre=document.getElementById("nombreN").value;
    var categoria=document.getElementById("categoriaN").value;
    //alert(id+costo+nombre+categoria);
    //alert(categoria);
    xhr.open("GET", "ActualizarServicio?id="+id+" &costo="+costo+" &nombre="+nombre+" &categoria="+categoria, true);
    xhr.onreadystatechange = detalleActualizarServicio;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function detalleActualizarServicioFin(){
    if (xhr.readyState == 4) {
        document.getElementById("mensajeConfirmacion").innerHTML = "<em>" + xhr.responseText + "</em>";
    
    }
}
//Actualizar descripcion del servicio

function formActualizarDescripcion(){
    //alert("vamos bien xdxd")
    crearObjeto();
    peticionActualizarDescripcion();
}
function peticionActualizarDescripcion(){
    var id=document.getElementById("id").value;
    var descripcion=document.getElementById("descripcion").value;

    //alert(id+costo+nombre+categoria);
    //alert(id+descripcion);
    xhr.open("GET", "FormActualizarDescripcion?id="+id+" &descripcion="+descripcion, true);
    xhr.onreadystatechange = detalleActualizarServicio;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleActualizarDescripcion(){
   
            if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    
    }
}
function actualizarDescripcion(){
    crearObjeto();
    peticionActualizarDescServicio();
}

function peticionActualizarDescServicio(){
    var descripcion=document.getElementById("descripcion").value;
    var id=document.getElementById("id").value;
    
    //alert(descripcion+id);
    xhr.open("GET", "ActualizarDescripcionServicio?descripcion="+descripcion+" &id="+id, true);
    xhr.onreadystatechange = detalleActualizarDescripcionServicio;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function detalleActualizarDescripcionServicio(){
    if (xhr.readyState == 4) {
        document.getElementById("mensajeC").innerHTML = "<em>" + xhr.responseText + "</em>";
    
    }
}
//Eliminar descripcion de servicio


function confirmarEliminacionDescripcion(){
    crearObjeto();
    peticionConfirmarEliminacion();
}

function peticionConfirmarEliminacion(){
    var id=document.getElementById("id").value;
    xhr.open("GET","ConfirmarEliminacionDescripciondeServicio?id="+id,true);
    xhr.onreadystatechange=detalleConfirmarEliminar;
    xhr.send(null);       
}

function detalleConfirmarEliminar(){
     if (xhr.readyState == 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
function eliminarDescripcionServicioConf(){
    //alert("vamos bien xdxd")
    crearObjeto();
    eliminacionFinalDescripcion();
}
function eliminacionFinalDescripcion(){
    //alert("si baja mami si baja");
    var id= document.getElementById("id").value;
    var confirmacion=document.getElementById("confirmacion").value;
   
    //alert(id+confirmacion);
    xhr.open("GET", "EliminarDescripcionServicio?id="+id+" &confirmacion="+confirmacion, true);
    xhr.onreadystatechange = detalleConfEliminarDescripcion;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleConfEliminarDescripcion(){
   
            if (xhr.readyState == 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Galeria de fotos
function GaleriaFotos(){
    crearObjeto();
    peticionGaleria();
}

function peticionGaleria(){
    
    xhr.open("GET","GaleriaFotos",true);
    xhr.onreadystatechange=detalleGaleriaFotos;
    xhr.send(null);       
}

function detalleGaleriaFotos(){
     if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Galeria videos

function GaleriaVideos(){
    crearObjeto();
    peticionGaleriaVideo();
}

function peticionGaleriaVideo(){
    
    xhr.open("GET","GaleriaVideos",true);
    xhr.onreadystatechange=detalleGaleriaVideos;
    xhr.send(null);       
}

function detalleGaleriaVideos(){
     if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Cliente consulta de servicios
function formularioConsultarServiciosCliente() {
    crearObjeto();
    enviapeticionFConsultarSC();
}

function enviapeticionFConsultarSC() {
    xhr.open("GET", "formBuscarServiciosCliente", true);
    xhr.onreadystatechange = verificarDetalleConsultarS;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificarDetalleConsultarSCliente() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//busqueda por nombre
function buscarServicioNombreCliente(){
    crearObjeto();
    peticionBSNombreCliente();
}

function peticionBSNombreCliente(){
    var nombre=document.getElementById("nombre").value;
    //alert(nombre);
        xhr.open("GET", "BusquedaNombreServiciosCliente?nombre="+nombre, true);
    xhr.onreadystatechange = detalleBusquedaSNombreCliente;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
    
}

function detalleBusquedaSNombreCliente(){
     if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//busqueda por categoria
function busquedaServicioCategoriaCliente(){
    crearObjeto();
    peticionServicioCategoriaCliente();
}
function peticionServicioCategoriaCliente(){
        var categoria=document.getElementById("categoria").value;
   // alert(categoria);
        xhr.open("GET", "BusquedaCategoriaServiciosCliente?categoria="+categoria, true);
    xhr.onreadystatechange = detalleServicioCategoriaCliente;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleServicioCategoriaCliente(){
         if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//busqueda por calificacion
function busquedaServicioCalificacionCliente(){
    crearObjeto();
    peticionServicioCalificacionCliente();
}
function peticionServicioCalificacionCliente(){
        var calificacion=document.getElementById("calificacion").value;
    //alert(calificacion);
        xhr.open("GET", "BusquedaCalificacionServiciosCliente?calificacion="+calificacion, true);
    xhr.onreadystatechange = detalleServicioCalificacionCliente;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleServicioCalificacionCliente(){
         if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Cliente consulta de Descripcion de servicios

function formularioBuscarDescripcionServicioCliente() {
    crearObjeto();
    enviapeticionBusquedaDescripcionCliente();
}

function enviapeticionBusquedaDescripcionCliente() {
    xhr.open("GET", "formBuscarDescripcionServicioCliente", true);
    xhr.onreadystatechange = verificarDetalleBuscarDescripcionCliente;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function verificarDetalleBuscarDescripcionCliente() {
    if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Busqueda por palabra
function busquedaDescripcionServicioPalabraCliente(){
    //alert("uno");
    crearObjeto();
    peticionDescripcionServicioPalabraCliente();
}
function peticionDescripcionServicioPalabraCliente(){
        var palabra=document.getElementById("palabra").value;
    //alert(palabra);
        xhr.open("GET", "BusquedaDescripcionPalabraCliente?palabra="+palabra, true);
    xhr.onreadystatechange = detalleDescripcionServicioPalabraCliente;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleDescripcionServicioPalabraCliente(){
         if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//Calificacion de servicios
function formCalificar(){
    crearObjeto();
    peticionformCalificar();
}
function peticionformCalificar(){
    var id=document.getElementById("id").value;
   // alert(categoria);
        xhr.open("GET", "FormCalificarServicio?id="+id, true);
    xhr.onreadystatechange = detalleFormCalificar;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleFormCalificar(){
         if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
function calificarServicio(){
    //alert("aver");
    crearObjeto();
    peticionCalificar();
}

function peticionCalificar(){
    var id=document.getElementById("id").value;
    var idCliente=document.getElementById("idCliente").value;
    var calificacion=document.getElementById("cal").value;
    var comentario=document.getElementById("comen").value;
    //alert(id+" "+idCliente+" "+calificacion+" "+comentario);
    xhr.open("GET", "calificarServicio?id="+id+" &idCliente="+idCliente+" &calificacion="+calificacion+" &comentario="+comentario, true);
    xhr.onreadystatechange = detalleFormCalificar;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function detalleCalificar(){
        if (xhr.readyState == 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Agregar a lista de pendientes
function agregarListaDePendientes(){
    crearObjeto();
    peticionListaPendientes();
}

function peticionListaPendientes(){
    var id=document.getElementById("id").value;
    //alert(id);
    xhr.open("GET", "AregarListaPendientes?id="+id, true);
    xhr.onreadystatechange = detalleListaPendientes;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleListaPendientes(){
    if (xhr.readyState == 4) {
        document.getElementById("mensajeConfirmacion").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
    }
    
  //Ver lista de pendientes
  function VerListadePendientes(){
      //alert("paso 1");
      crearObjeto();
      peticionVerLista();
  }
   function peticionVerLista(){
    
    //alert("Ya deberia jalar prro");
    xhr.open("GET", "VerListadePendientes", true);
    xhr.onreadystatechange = detalleVerLista;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
       
   }
   function detalleVerLista(){
     if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }                                                                                                                                            
   }
   
 //Registro de categoria
 function formularioRegistroCategoria(){
     crearObjeto();
     peticionFCategoria();
 }
 
 function peticionFCategoria(){
    xhr.open("GET", "FormularioRegistroCategoria", true);
    xhr.onreadystatechange = detalleFCategoria;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
 }
 
 function detalleFCategoria(){
   if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }  
 }
 
 function registrarCategoria(){
    //alert("bien");
    crearObjeto();
    peticionRegistrarCategoria();
}

function peticionRegistrarCategoria(){
    //alert("entramos");
    var categoria= document.getElementById("categoria").value;

    
    //alert(categoria);
    xhr.open("GET", "RegistrarCategoria?categoria="+categoria, true);
    xhr.onreadystatechange = detalleRegistraCategoria;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function detalleRegistraCategoria(){
    if (xhr.readyState == 4) {
        document.getElementById("mostrarR").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//Buscar todas las descripciones
function buscarTodosLasDescripciones(){
    crearObjeto();
    peticionBusquedaTodasLasDescripciones();
}
function peticionBusquedaTodasLasDescripciones(){
    xhr.open("GET", "BusquedaDescripcionesAll", true);
    xhr.onreadystatechange = detalleTodasDescripciones;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleTodasDescripciones(){
    if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//Buscar todas las descripciones
function buscarTodosLasDescripcionesCliente(){
    crearObjeto();
    peticionBusquedaTodasLasDescripcionesCliente();
}
function peticionBusquedaTodasLasDescripcionesCliente(){
    xhr.open("GET", "BusquedaDescripcionesAllCliente", true);
    xhr.onreadystatechange = detalleTodasDescripcionesCliente;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleTodasDescripcionesCliente(){
    if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//Ver categorias
function buscarCategorias(){
    crearObjeto();
    peticionCategorias();
}
function peticionCategorias(){
    xhr.open("GET", "MostrarCategorias", true);
    xhr.onreadystatechange = detalleCategorias;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleCategorias(){
    if (xhr.readyState == 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
//Actualizar categoria

function formularioActualizarCategoria(){
    crearObjeto();
    peticionFormularioActualizarCategoria();
}
function peticionFormularioActualizarCategoria(){
    var id=document.getElementById("idC").value;
    alert(id);
    xhr.open("GET", "FormularioModificarCategoria?idC="+id, true);
    xhr.onreadystatechange = detalleFormularioActualizarCategoria;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleFormularioActualizarCategoria(){
        if (xhr.readyState == 4) {
        document.getElementById("formularios").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function actualizarCategoria(){
    crearObjeto();
    peticionActualizarCategoria();
}

function peticionActualizarCategoria(){
     var id=document.getElementById("idN").value;
    var nombre=document.getElementById("nombreN").value;
    //alert(id+costo+nombre+categoria);
    //alert(categoria);
    xhr.open("GET", "ActualizarCategoria?idN="+id+" &nombreN="+nombre, true);
    xhr.onreadystatechange = detalleActualizarCategoria;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function detalleActualizarCategoria(){
    if (xhr.readyState == 4) {
        document.getElementById("mensajeConfirmacion").innerHTML = "<em>" + xhr.responseText + "</em>";
    
    }
}

//Eliminar categoria

function abrirConfirmacionCategoria(){
    crearObjeto();
    peticionConfirmacionCategoria();
}
 function peticionConfirmacionCategoria(){
     var idC=document.getElementById("idC").value;
    
         xhr.open("GET", "ConfirmarEliminarCategoria?idC="+idC, true);
         
         //alert(idC);
    xhr.onreadystatechange = detalleConfirmacionCategoria;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
 }
 
 function detalleConfirmacionCategoria(){
     if (xhr.readyState == 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
 }

function confirmarEliminacionCategoria(){
    //alert("vamos bien xdxd")
    crearObjeto();
    peticionConfirmarBajaCategoria();
}
function peticionConfirmarBajaCategoria(){
    //alert("si baja mami si baja");
    var idC= document.getElementById("idC").value;
    var confirmacion=document.getElementById("confirmacion").value;
   
    //alert(idC+" "+confirmacion);
    xhr.open("GET", "EliminarCategoria?idC="+idC+" &confirmacion="+confirmacion, true);
    xhr.onreadystatechange = detalleConfEliminar;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleConfEliminar(){
   
            if (xhr.readyState == 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//MostrarServiciosCliente
function mostrarServiciosCliente(){
    crearObjeto();
    peticionMostrarServiciosCliente();
}
function peticionMostrarServiciosCliente(){
        
   // alert(categoria);
        xhr.open("GET", "MostrarServiciosCliente", true);
    xhr.onreadystatechange = detalleMostrarServicios;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleMostrarServiciosCliente(){
         if (xhr.readyState == 4) {
        document.getElementById("consultaS").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Eliminar servicios nuevo metodo
function confirmarEliminacionFin(){
    //alert("paso 1");
    crearObjeto();
    peticionConfirmarEliminacionFin();
}

function peticionConfirmarEliminacionFin(){
    var id=document.getElementById("id").value;
    xhr.open("GET","ConfirmarEliminacionServicio?id="+id,true);
    xhr.onreadystatechange=detalleConfirmarEliminarFin;
    xhr.send(null);       
}

function detalleConfirmarEliminarFin(){
     if (xhr.readyState === 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
function eliminarServicioConfFin(){
    //alert("vamos bien xdxd");
    crearObjeto();
    eliminacionFinalServicioFin();
}
function eliminacionFinalServicioFin(){
    //alert("si baja mami si baja");
    var id= document.getElementById("id").value;
    var confirmacion=document.getElementById("confirmacion").value;
   
    //alert(id+confirmacion);
    xhr.open("GET", "EliminarServicio?id="+id+" &confirmacion="+confirmacion, true);
    xhr.onreadystatechange = detalleConfEliminarFin;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleConfEliminarFin(){
   
            if (xhr.readyState === 4) {
        document.getElementById("mensajeConfirmacion").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}


//Eliminar categoria Nuevo método

function abrirConfirmacionCategoriaFin(){
    crearObjeto();
    peticionConfirmacionCategoriaFin();
}
 function peticionConfirmacionCategoriaFin(){
     var idC=document.getElementById("idC").value;
    
         xhr.open("GET", "ConfirmarEliminarCategoria?idC="+idC, true);
         
         //alert(idC);
    xhr.onreadystatechange = detalleConfirmacionCategoriaFin;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
 }
 
 function detalleConfirmacionCategoriaFin(){
     if (xhr.readyState == 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
 }

function confirmarEliminacionCategoriaFin(){
    //alert("vamos bien xdxd")
    crearObjeto();
    peticionConfirmarBajaCategoriaFin();
}
function peticionConfirmarBajaCategoriaFin(){
    //alert("si baja mami si baja");
    var idC= document.getElementById("idC").value;
    var confirmacion=document.getElementById("confirmacion").value;
   
    //alert(idC+" "+confirmacion);
    xhr.open("GET", "EliminarCategoria?idC="+idC+" &confirmacion="+confirmacion, true);
    xhr.onreadystatechange = detalleConfEliminarFin;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}
function detalleConfEliminarFin(){
   
            if (xhr.readyState == 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

//Reportar servicio
function FormularioReporte(){
    //alert("paso 1");
    crearObjeto();
    peticionReporte();
}

function peticionReporte(){
    
    xhr.open("GET","FormularioReporte",true);
    xhr.onreadystatechange=detalleReporte;
    xhr.send(null);       
}

function detalleReporte(){
     if (xhr.readyState === 4) {
        document.getElementById("detalle").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}

function ReportarServicio(){
    //alert("aver");
    crearObjeto();
    peticionReporte();
}

function peticionReporte(){
    var id=document.getElementById("id").value;
    var idCliente=document.getElementById("idCliente").value;
    var calificacion=document.getElementById("cal").value;
    var comentario=document.getElementById("comen").value;
    //alert(id+" "+idCliente+" "+calificacion+" "+comentario);
    xhr.open("GET", "ReportarServicio?id="+id+" &idCliente="+idCliente+" &calificacion="+calificacion+" &comentario="+comentario, true);
    xhr.onreadystatechange = detalleReporte;
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(null);
}

function detalleReporte(){
        if (xhr.readyState == 4) {
        document.getElementById("nuevaconsulta").innerHTML = "<em>" + xhr.responseText + "</em>";
    }
}
