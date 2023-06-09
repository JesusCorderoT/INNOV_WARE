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


//////////////////////////////////////////////////////////////muestra formulario de registro
function mostrar_formulario_noticia(){
    crearObjeto();
    enviar_formulario_noticia();
   // alert("muestra");
}

function enviar_formulario_noticia(){
    
    
   // alert("enviado");
        xhr.open("GET","Formulario_noticia", true);
        xhr.onreadystatechange = detalles_formulario_noticia;
        xhr.send(null);

}

function detalles_formulario_noticia(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("funciones_noticia").innerHTML=xhr.responseText;
    }
}

//////////////////realiza registro
function mostrar_registro_noticia(){
    crearObjeto();
    enviar_registro_noticia();
    // alert("muestra");
}

function enviar_registro_noticia(){
    
    var titulo_noticia=document.getElementById("titulo_noticia").value;
    var descripcion_noticia=document.getElementById("descripcion_noticia").value;
    var autor=document.getElementById("autor").value;
    var fecha=document.getElementById("fecha").value;
   //  alert("enviado variables "+titulo_noticia+" "+descripcion_noticia+" "+autor+" "+fecha);
        xhr.open("GET","Registro?titulo_noticia="+titulo_noticia+"&descripcion_noticia="+descripcion_noticia+"&autor="+autor+"&fecha="+fecha, true);
   //     alert("manda a servlet");
    xhr.onreadystatechange = detalles_registro_noticia;
        xhr.send(null);

}

function detalles_registro_noticia(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("mostrar_mensajes_noticias").innerHTML=xhr.responseText;
    }
}
//mostrar noticia 

function mostrar_noticias_admin(){
    crearObjeto();
    enviar_noticias_admin();
  //   alert("muestra");
}

function enviar_noticias_admin(){
    
  
    //alert("enviando");
        xhr.open("GET","Mostrar_noticias", true);
   //     alert("manda a servlet");
    xhr.onreadystatechange = detalles_noticias_admin;
        xhr.send(null);

}

function detalles_noticias_admin(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("mostrar_mensajes_noticias").innerHTML=xhr.responseText;
    }
}

///////////////////////////////////////////////seccion para eliminar noticia

//---------------select de titulos
function mostrar_titulos_para_buscar(){
    crearObjeto();
    enviar_titulos_para_buscar();
   // alert("muestra");
}

function enviar_titulos_para_buscar(){
    
    
   // alert("enviado");
        xhr.open("GET","Select__buscar_titulos", true);
        xhr.onreadystatechange = detalles_titulos_busqueda;
        xhr.send(null);

}

function detalles_titulos_busqueda(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("funciones_noticia").innerHTML=xhr.responseText;
    }
}
///mostrar noticia por busqueda de titulos---------------------------------------------------------------

function mostrar_resultado_busqueda(){
    crearObjeto();
    enviar_resultado_de_busqueda();
   // alert("muestra");
}

function enviar_resultado_de_busqueda(){
    var tit=document.getElementById("select");
    var titulo_noticia=tit.options[tit.selectedIndex].value;
  // alert("enviado"+titulo_noticia);
        xhr.open("GET","Resultado_de_busqueda?titulo_noticia="+titulo_noticia, true);
        xhr.onreadystatechange = detalles_resultado_busqueda;
        xhr.send(null);

}

function detalles_resultado_busqueda(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("validaciones_noticia").innerHTML=xhr.responseText;
    }
}




//////////////////////////////////////////////seccion para buscar por titulo
/////////////////////////////////////////////
/////////////////////////////////////////////


//---------------select de titulos para eliminar
function mostrar_noticia_para_eliminar(){
    crearObjeto();
    enviar_titulos_para_eliminar();
   // alert("muestra");
}

function enviar_titulos_para_eliminar(){
    
    
   // alert("enviado");
        xhr.open("GET","Select_eliminar_noticia", true);
        xhr.onreadystatechange = detalle_titulos_del_selec;
        xhr.send(null);

}

function detalle_titulos_del_selec(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("funciones_noticia").innerHTML=xhr.responseText;
    }
}

//////////////////////////seccion para validar eliminacion con radios botoes

function mostrar_radios_eliminar_noticia(){
    crearObjeto();
    enviar_radios_eliminar_noticia();
   // alert("muestra");
}

function enviar_radios_eliminar_noticia(){
    
    
   // alert("enviado");
        xhr.open("GET","Validar_eliminacion", true);
        xhr.onreadystatechange = detalle_radios_eliminar_noticia;
        xhr.send(null);

}

function detalle_radios_eliminar_noticia(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("validaciones_noticia").innerHTML=xhr.responseText;
    }
}

///hacer eliminacion validada----------------------------------------------


function elimina_noticia_enviada(){
    crearObjeto();
    enviar_noticia_para_eliminar();
   // alert("muestra");
}

function enviar_noticia_para_eliminar(){
 var tit=document.getElementById("select");
  var titulo_noticia=tit.options[tit.selectedIndex].value;
    
 var vali;


if(document.getElementById("si").checked){
    vali="si";
}else if(document.getElementById("no").checked){
   vali="no";
}
    
   // alert("enviando variable: "+titulo_noticia+" y variable : "+vali);
        xhr.open("GET","Eliminar_noticia?titulo_noticia="+titulo_noticia+"&val="+vali, true);
        
        xhr.onreadystatechange = detalle_eliminado;
        xhr.send(null);

}

function detalle_eliminado(){
     if(xhr.readyState==4){
     //   alert("recibe");
        document.getElementById("validaciones_noticia").innerHTML=xhr.responseText;
    }
}
////////////////////////////////////
//////////////////////////////////////
//////////////////////////////////////MODIFICAR NOTICIA----------------------------------------------------
//////////////////////////////////////

function mostrar_noticias_modificar(){
    crearObjeto();
    enviar_noticias_modificar();
   // alert("muestra");
}

function enviar_noticias_modificar(){
    
    
 // alert("enviado");
        xhr.open("GET","Select_titulo_modificar", true);
        xhr.onreadystatechange = detalle_noticias_modificar;
        xhr.send(null);

}

function detalle_noticias_modificar(){
     if(xhr.readyState==4){
      //  alert("recibe");
        document.getElementById("funciones_noticia").innerHTML=xhr.responseText;
    }
}


/////////////////////////-----------------------------llenar formulario de noticia a modificar



function mostrar_formulario_modificable(){
    crearObjeto();
    enviar_formulario_modificable();
   // alert("muestra");
}

function enviar_formulario_modificable(){
    var tit=document.getElementById("select");
    var titulo_noticia=tit.options[tit.selectedIndex].value;
   //alert("enviado"+titulo_noticia);
        xhr.open("GET","Formulario_lleno_noticias?titulo_noticia="+titulo_noticia, true);
        xhr.onreadystatechange = detalles_formulario_modificable;
        xhr.send(null);

}

function detalles_formulario_modificable(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("validaciones_noticia").innerHTML=xhr.responseText;
    }
}

//////////////////////////////noticia actualizada funcion

function mostrar_actualizada_noticia(){
    crearObjeto();
    enviar_actualizada_noticia();
   // alert("muestra");
}

function enviar_actualizada_noticia(){
    var titulo_noticia=document.getElementById("titulo_noticia").value;
    var descripcion_noticia=document.getElementById("descripcion_noticia").value;
    var autor=document.getElementById("autor").value;
    var fecha=document.getElementById("fecha").value;
    var id_boletin=document.getElementById("id_boletin").value;
  // alert("enviado"+titulo_noticia+" "+descripcion_noticia+" "+autor+" "+fecha);
        xhr.open("GET","Noticia_Modificada?titulo_noticia="+titulo_noticia+"&descripcion_noticia="+descripcion_noticia+"&autor="+autor+"&fecha="+fecha+"&id_boletin="+id_boletin, true);
        xhr.onreadystatechange = detalles_noticia_actualizada;
        xhr.send(null);

}

function detalles_noticia_actualizada(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("validaciones_noticia").innerHTML=xhr.responseText;
    }
}








///////////////////////
///////////////////////
////////////////////
/////////////////////
///////////////////////
///////////////////          cliente
//////////////////////
//////////////////////
/////////////////////
/////////////////////

