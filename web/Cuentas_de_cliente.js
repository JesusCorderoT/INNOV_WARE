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










function mostrarFormulario_c(){
    crearObjeto();
    enviarFOrmulario_c();
   // alert("muestra");
}

function enviarFOrmulario_c(){
    
    
   // alert("enviado");
        xhr.open("GET","Formulario_cliente", true);
        xhr.onreadystatechange = detalleFormulario_c;
        xhr.send(null);

}

function detalleFormulario_c(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("formulario_registro_cliente").innerHTML=xhr.responseText;
    }
}

////////////////***************************************registro





function mostrarRegistroC(){
    crearObjeto();
    enviarRegistroC();
   //  alert("muestra");
}

function enviarRegistroC(){
    var nombre_usuario=document.getElementById("nombre_usuario").value;
    var apellidos=document.getElementById("apellidos").value;
    var telefono=document.getElementById("telefono").value;
    var usuario=document.getElementById("usuario_c").value;
    var password_user=document.getElementById("password_user").value;
    var sex=document.getElementById("sexo");  
    var sexo=sex.options[sex.selectedIndex].value;
    
    var correo_electronico=document.getElementById("correo_electronico").value;
    
    var dom=document.getElementById("dominio");
    var dominio=dom.options[dom.selectedIndex].value;
    
    //
    
  // alert("enviado");
        xhr.open("GET","Cliente_registro?nombre_usuario="+nombre_usuario+"&apellidos="+apellidos+"&telefono="+telefono+"&usuario="+usuario+"&password_user="+password_user+"&sexo="+sexo+"&correo_electronico="+correo_electronico+"&dominio="+dominio, true);
        xhr.onreadystatechange = detalleRegistroC;
        xhr.send(null);

}

function detalleRegistroC(){
     if(xhr.readyState==4){
      //    alert("recibe");
        document.getElementById("formulario_registro_cliente").innerHTML=xhr.responseText;
    }
}
////////////***************************************verificar

function mostrar_formulario_verificacion_c(){
    crearObjeto();
    enviar_formulario_verificacion_c();
 //alert("muestra");
}

function enviar_formulario_verificacion_c(){
    
    
   //alert("enviado");
        xhr.open("GET","Form_verifica", true);
        xhr.onreadystatechange = detalles_formulario_verificacion_c;
        xhr.send(null);

}

function detalles_formulario_verificacion_c(){
     if(xhr.readyState==4){
        // alert("recibe");
        document.getElementById("formulario_registro_cliente").innerHTML=xhr.responseText;
    }
}

//************verificar


function mostrar_verificacion_c(){
    crearObjeto();
    enviar_verificacion_c();
 //alert("muestra");
}

function enviar_verificacion_c(){
    var codigo=document.getElementById("codigo").value;
    var usuario_v=document.getElementById("user").value;
    
//  alert("enviado"+codigo+usuario);
        xhr.open("GET","Verificar_c?codigo="+codigo+"&usuario_v="+usuario_v, true);
        xhr.onreadystatechange = detalle_verificacion_c;
        xhr.send(null);

}

function detalle_verificacion_c(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("cliente_mensajes").innerHTML=xhr.responseText;
    }
}
