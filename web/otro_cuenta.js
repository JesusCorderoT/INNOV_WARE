
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








function mostrarFormulario(){
    crearObjeto();
    enviarFOrmulario();
   // alert("muestra");
}

function enviarFOrmulario(){
    
    
   // alert("enviado");
        xhr.open("GET","Formulario_cuenta", true);
        xhr.onreadystatechange = detalleFormulario;
        xhr.send(null);

}

function detalleFormulario(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("funciones_cuenta").innerHTML=xhr.responseText;
    }
}

//----------------------registrar cuenta administrador--------------------------

function mostrarRegistroAD(){
    crearObjeto();
    enviarRegistroAD();
    //alert("muestra");
}

function enviarRegistroAD(){
    var nombre_usuario=document.getElementById("nombre_usuario").value;
    var apellidos=document.getElementById("apellidos").value;
    var telefono=document.getElementById("telefono").value;
    var usuario=document.getElementById("usuario").value;
    var password_user=document.getElementById("password_user").value;
    var sex=document.getElementById("sexo");  
    var sexo=sex.options[sex.selectedIndex].value;
    
    var correo_electronico=document.getElementById("correo_electronico").value;
    
    var dom=document.getElementById("dominio");
    var dominio=dom.options[dom.selectedIndex].value;
    
    //
    
  //alert("enviado");
        xhr.open("GET","RegistrarAdministrador?nombre_usuario="+nombre_usuario+"&apellidos="+apellidos+"&telefono="+telefono+"&usuario="+usuario+"&password_user="+password_user+"&sexo="+sexo+"&correo_electronico="+correo_electronico+"&dominio="+dominio, true);
        xhr.onreadystatechange = detalleRegistroAD;
        xhr.send(null);

}

function detalleRegistroAD(){
     if(xhr.readyState==4){
        // alert("recibe");
        document.getElementById("funciones_cuenta").innerHTML=xhr.responseText;
    }
}
/////////////////////////////////formulario para verificar cuenta 













function mostrar_formulario_verificacion(){
    crearObjeto();
    enviar_formulario_verificacion();
//alert("muestra");
}

function enviar_formulario_verificacion(){
    
    
  //alert("enviado");
        xhr.open("GET","Verificar_cuenta_ad", true);
        xhr.onreadystatechange = detalles_formulario_verificacion;
        xhr.send(null);

}

function detalles_formulario_verificacion(){
     if(xhr.readyState==4){
      //  alert("recibe");
        document.getElementById("funciones_cuenta").innerHTML=xhr.responseText;
    }
}

///verificacion de cuenta completada

function mostrar_verificacion_ad(){
    crearObjeto();
    enviar_verificacion_ad();
//alert("muestra");
}

function enviar_verificacion_ad(){
    var codigo=document.getElementById("codigo").value;
    var usuario=document.getElementById("usuario").value;
    
 // alert("enviado");
        xhr.open("GET","VerificarCuenta?codigo="+codigo+"&usuario="+usuario, true);
        xhr.onreadystatechange = detalle_verificacion_ad;
        xhr.send(null);

}

function detalle_verificacion_ad(){
     if(xhr.readyState==4){
      //  alert("recibe");
        document.getElementById("mensajes_cuenta").innerHTML=xhr.responseText;
    }
}

////////////////////////////////////////////
////////////////////////////////////////////eliminar cuentas 
////////////////////////////////////////////
///////////////////////////////////////////









/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
///////////////////////////////////////////
/////////////////////////
/////////////////////               Cambiar contraseña
//////////////////////////
/////////////////////////////////////
////////////////////////////////////////////////////////////////////


function cambiar_contra(){
    crearObjeto();
    enviar_cambiar_contra();
   // alert("muestra");
}

function enviar_cambiar_contra(){
    
    
   // alert("enviado");
        xhr.open("GET","Formulario_cambio", true);
        xhr.onreadystatechange = detalle_cambiar_contra;
        xhr.send(null);

}

function detalle_cambiar_contra(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("funciones_cuenta").innerHTML=xhr.responseText;
    }
}

//// realiza cambio de contraseña


function contra_cambiada(){
    crearObjeto();
    enviar_contra_cambiada();
   // alert("muestra");
}

function enviar_contra_cambiada(){
    var usuario=document.getElementById("usuario").value;
    var password=document.getElementById("password").value;
    var nuevo_password=document.getElementById("nuevo_password").value;
    var confirmacion=document.getElementById("confirmacion").value;
    
    
    
        xhr.open("GET","Cambiar_password?usuario="+usuario+"&password="+password+"&nuevo_password="+nuevo_password+"&confirmacion="+confirmacion, true);
       //alert("enviado "+usuario+" "+password+" "+nuevo_password+" "+confirmacion);
    xhr.onreadystatechange = detalle_contra_cambiada;
        xhr.send(null);

}

function detalle_contra_cambiada(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("mensajes_cuenta").innerHTML=xhr.responseText;
    }
}
///////////////////////////












//////////////////////////////consultar usuarios llenado de select

function ver_usuarios(){
    crearObjeto();
    enviar_ver_usuarios();
   // alert("muestra");
}

function enviar_ver_usuarios(){
    
    
   // alert("enviado");
        xhr.open("GET","select_buscar", true);
        xhr.onreadystatechange = detalle_ver_usuarios;
        xhr.send(null);

}

function detalle_ver_usuarios(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("funciones_cuenta").innerHTML=xhr.responseText;
    }
}
///llenar informacion-------------------------------------------------------------------------------

function ver_info_ad(){
    crearObjeto();
    enviar_info_ad();
   // alert("muestra");
}

function enviar_info_ad(){
    var us=document.getElementById("select");  
    var usuario=us.options[us.selectedIndex].value;
    
   // alert("enviado");
        xhr.open("GET","Resultado_busqueda_usuarios?usuario="+usuario, true);
        xhr.onreadystatechange = detalle_info_ad;
        xhr.send(null);

}

function detalle_info_ad(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("validaciones_cuenta").innerHTML=xhr.responseText;
    }
}



////////////////////////eliminacion 
////////////////////////////
///////////////////////////
///////////////////
//////
/////////////////
//////////////////////////
/////////////////////////////



///confirmacion de eliminar 



function radio_elimina(){
    crearObjeto();
    enviar_radio_elimina();
   // alert("muestra");
}

function enviar_radio_elimina(){
    
    
   // alert("enviado");
        xhr.open("GET","Verificar_radio_eliminar", true);
        xhr.onreadystatechange = detalle_radio_elimina;
        xhr.send(null);

}

function detalle_radio_elimina(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("mensajes_cuenta").innerHTML=xhr.responseText;
    }
}
/////eliminar la cuenta verificada


function elimina_cuenta(){
    crearObjeto();
    envia_elimina_cuenta();
   // alert("muestra");
}

function envia_elimina_cuenta(){
    var usuario_e=document.getElementById("usuario_e").value;
    var vali;
    if(document.getElementById("si").checked){
    vali="si";
}else if(document.getElementById("no").checked){
   vali="no";
}
    
  //alert("enviado"+usuario_e+vali);
        xhr.open("GET","Eliminar_cuenta_ad?usuario_e="+usuario_e+"&val="+vali, true);
        xhr.onreadystatechange = detalle_elimina_cuenta;
        xhr.send(null);

}

function detalle_elimina_cuenta(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("mensajes_cuenta").innerHTML=xhr.responseText;
    }
}


///////////////////////////////////
//////////////////}}}///////////////
///////////////////
//-------------------------------eliminar cuenta cliente
/////////////////////////
////////////////////////////////
/////////////////////////////


function formulario_elimina_cliente(){
    crearObjeto();
    envia_formulario_elimina_cliente();
   // alert("muestra");
}

function envia_formulario_elimina_cliente(){
    
    
   // alert("enviado");
        xhr.open("GET","Formulario_elimina_cliente", true);
        xhr.onreadystatechange = detalle_formulario_elimina_cliente;
        xhr.send(null);

}

function detalle_formulario_elimina_cliente(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("funciones_cuenta").innerHTML=xhr.responseText;
    }
}


///////////////radio botones 

function radio_elimina(){
    crearObjeto();
    envia_radio_elimina();
   // alert("muestra");
}

function envia_radio_elimina(){
    
    
   // alert("enviado");
        xhr.open("GET","Radio_botones_elim", true);
        xhr.onreadystatechange = detalle_radio_elimina;
        xhr.send(null);

}

function detalle_radio_elimina(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("validaciones_cuenta").innerHTML=xhr.responseText;
    }
}

/////eliminar cuenta cliente

function elimina_cliente(){
    crearObjeto();
    envia_elimina_cliente();
   // alert("muestra");
}

function envia_elimina_cliente(){
    var usuario=document.getElementById("usuario").value;
    var contrasena=document.getElementById("contrasena").value;
    var verificar=document.getElementById("verificar").value;
    
    var vali;
    if(document.getElementById("si").checked){
    vali="si";
}else if(document.getElementById("no").checked){
   vali="no";
}
    //alert("enviado: "+usuario+contrasena+verificar+vali);
        xhr.open("GET","Elimina_cliente?usuario="+usuario+"&contrasena="+contrasena+"&verificar="+verificar+"&val="+vali, true);
        xhr.onreadystatechange = detalle_elimina_cliente;
        xhr.send(null);

}

function detalle_elimina_cliente(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("validaciones_cuenta").innerHTML=xhr.responseText;
    }
}
///////////////////
//////////////////////
//////////////////////
/////////////////////
////////////////////
/////////////////////
//Modificar informacion de perfil

