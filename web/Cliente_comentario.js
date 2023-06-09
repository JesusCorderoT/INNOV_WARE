var xhr;
function crearObjeto(){
    if(window.ActiveXObject){
        xhr=new ActiveXObject("Microsoft.XMLHttp");
    }
    else if((window.XMLHttpRequest)||(typeof  XMLHttpRequest)!= undefined){
        xhr=new XMLHttpRequest();
    }
    else{
        alert("su navegador no soporta AJAX");
        return;
    }
}



function ver_comen_cliente(){
    crearObjeto();
    enviar_comen_cliente();
  //  alert("muestra");
}

function enviar_comen_cliente(){
    
    
  //  alert("enviado");
        xhr.open("GET","Ver_comentario_cliente", true);
        xhr.onreadystatechange = detalle_comen_cliente;
        xhr.send(null);

}

function detalle_comen_cliente(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("funciones_comentarios").innerHTML=xhr.responseText;
    }
}
//////////////modificar comentario cliente 




function formualrio_mod(){
    crearObjeto();
    enviar_formulario_mod();
  //  alert("muestra");
}

function enviar_formulario_mod(){
    
    
  //  alert("enviado");
        xhr.open("GET","formulario_valida", true);
        xhr.onreadystatechange = det_formulario_mod;
        xhr.send(null);

}

function det_formulario_mod(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("validaciones_comentarios").innerHTML=xhr.responseText;
    }
}
////////////////hacer consulta

function primera_consulta(){
    crearObjeto();
    envi_primera_consulta();
  //  alert("muestra");
}

function envi_primera_consulta(){
    var usuario=document.getElementById("usuario").value;
    var contrasena=document.getElementById("contrasena").value;
    
   //  alert("enviado"+usuario+contrasena);
        xhr.open("GET","Consulta_mod?usuario="+usuario+"&contrasena="+contrasena, true);
        xhr.onreadystatechange = de_primera_consulta;
        xhr.send(null);

}

function de_primera_consulta(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("validaciones_comentarios").innerHTML=xhr.responseText;
    }
}

//*************************************************************************************
///actualizar


function actualiza(){
    crearObjeto();
    enviando_actualizar();
  //  alert("muestra");
}

function enviando_actualizar(){
    var descripcion_noticia=document.getElementById("descripcion_noticia").value;
    var fecha=document.getElementById("fecha").value;
    var usuario=document.getElementById("usuario").value;
    //alert("enviado"+descripcion_noticia+usuario+fecha);
        xhr.open("GET","Modificar_comen?usuario="+usuario+"&descripcion_noticia="+descripcion_noticia+"&fecha="+fecha, true);
        xhr.onreadystatechange = de_actualiza;
        xhr.send(null);

}

function de_actualiza(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("mensajes_comentarios").innerHTML=xhr.responseText;
    }
}

////////////////////eliminar comentario 


//*****************************************radios onfirmacion


function radios_comen(){
    crearObjeto();
    enviar_radios_comen();
  //  alert("muestra");
}

function enviar_radios_comen(){
    
    
  //  alert("enviado");
        xhr.open("GET","Radios", true);
        xhr.onreadystatechange = det_radios_comen;
        xhr.send(null);

}

function det_radios_comen(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("mensajes_comentarios").innerHTML=xhr.responseText;
    }
}

///**************************elimina comentario  validado 



function comen_eliminar(){
    crearObjeto();
    envi_comen_elimina();
    // alert("muestra");
}

function envi_comen_elimina(){
  var descripcion_noticia=document.getElementById("descripcion_noticia").value;
    var fecha=document.getElementById("fecha").value;
    var usuario=document.getElementById("usuario").value;
 
 var vali;


if(document.getElementById("si").checked){
    vali="si";
}else if(document.getElementById("no").checked){
   vali="no";
}
    
    // alert("enviando variable: "+descripcion_noticia+" y variable : "+fecha+usuario+vali);
        xhr.open("GET","Eliminar_comentario?descripcion_noticia="+descripcion_noticia+"&fecha="+fecha+"&usuario="+usuario+"&vali="+vali, true);
        xhr.onreadystatechange = det_comen_elimina;
        xhr.send(null);

}

function det_comen_elimina(){
     if(xhr.readyState==4){
       // alert("recibe");
        document.getElementById("mensajes_comentarios").innerHTML=xhr.responseText;
    }
}