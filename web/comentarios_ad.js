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



//////////////crear comentario formulario


function mostrar_formulario_comentario(){
    crearObjeto();
    enviar_formulario_comentario();
  //  alert("muestra");
}

function enviar_formulario_comentario(){
    
    
  //  alert("enviado");
        xhr.open("GET","Formulario_comentario", true);
        xhr.onreadystatechange = detalles_formulario_comentario;
        xhr.send(null);

}

function detalles_formulario_comentario(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("funciones_comentarios").innerHTML=xhr.responseText;
    }
}

///////////////////comentar------------------------------------------



///////////////////////////

function comentar_ad(){
    crearObjeto();
    enviar_comentar_ad();
    //alert("muestra");
}

function enviar_comentar_ad(){
     var nombre_cliente= document.getElementById("nombre_cliente").value;
    var descripcion_noticia=document.getElementById("descripcion_noticia").value;
    var fecha=document.getElementById("fecha").value;
    
    
        xhr.open("GET","Registrar_comentario_ad?nombre_cliente="+nombre_cliente+"&descripcion_noticia="+descripcion_noticia+"&fecha="+fecha, true);
   // alert("enviado"+nombre_cliente+fecha+descripcion_noticia);    
    xhr.onreadystatechange = detalle_comentar_ad;
        xhr.send(null);

}

function detalle_comentar_ad(){
     if(xhr.readyState==4){
      //   alert("recibe");
        document.getElementById("funciones_comentarios").innerHTML=xhr.responseText;
    }
}


/////////////////////////////ver comentarios


function ver_comentarios_ad(){
    crearObjeto();
    enviar_comentarios_vista();
   // alert("muestra");
}

function enviar_comentarios_vista(){
   
    
        xhr.open("GET","Ver_comentarios_ad", true);
    //alert("enviado"+nombre_cliente+fecha+descripcion_noticia);    
    xhr.onreadystatechange = detalles_comentarios_vista;
        xhr.send(null);

}

function detalles_comentarios_vista(){
     if(xhr.readyState==4){
        // alert("recibe");
        document.getElementById("funciones_comentarios").innerHTML=xhr.responseText;
    }
}
///////////////////eliminar comentarios

function radios_valida_eliminacion_comentario_ad(){
    crearObjeto();
    envia_radios_valida_eliminacion_comentario_ad();
   //  alert("muestra");
}

function envia_radios_valida_eliminacion_comentario_ad(){
   
    
        xhr.open("GET","Valida_eliminar_comentarios_ad", true);
    //alert("enviado"+nombre_cliente+fecha+descripcion_noticia);    
    xhr.onreadystatechange = detalles_radios_valida_eliminacion_comentario_ad;
        xhr.send(null);

}

function detalles_radios_valida_eliminacion_comentario_ad(){
     if(xhr.readyState==4){
     //    alert("recibe");
        document.getElementById("mensajes_comentarios").innerHTML=xhr.responseText;
    }
}


////////////////////////////////////////eliminar comentarios 


function elimina_comentario_ad(){
    crearObjeto();
    envia_elimina_comentario_ad();
   //  alert("muestra");
}

function envia_elimina_comentario_ad(){
   var id_comentario=document.getElementById("id_comentario").value;
    
 var vali;


if(document.getElementById("si").checked){
    vali="si";
}else if(document.getElementById("no").checked){
   vali="no";
}


var eliminar_id=document.getElementById("celda").value;




    
        xhr.open("GET","Eliminar_comentarios_ad?id_comentario="+id_comentario+"&val="+vali, true);
    // alert("enviado"+eliminar_id+" "+vali);    
    xhr.onreadystatechange = detalle_elimina_comentario_ad;
        xhr.send(null);

}

function detalle_elimina_comentario_ad(){
     if(xhr.readyState==4){
        //  alert("recibe");
        document.getElementById("mensajes_comentarios").innerHTML=xhr.responseText;
    }
}

