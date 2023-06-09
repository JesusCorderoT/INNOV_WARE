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


function form_modificar(){
    crearObjeto();
    en_form_modificar();
   // alert("muestra");
}

function en_form_modificar(){
    
    
   // alert("enviado");
        xhr.open("GET","Form_modificar", true);
        xhr.onreadystatechange = de_form_modificar;
        xhr.send(null);

}

function de_form_modificar(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("mensajes_cuenta").innerHTML=xhr.responseText;
    }
}
///////////////////////formulario 2



function form_modificar2(){
    crearObjeto();
    en_form_modificar2();
   // alert("muestra");
}

function en_form_modificar2(){
    var usuario=document.getElementById("usuario").value;
    var contrasena=document.getElementById("contrasena").value;
    
    // alert("enviado"+usuario+contrasena);
        xhr.open("GET","Form_recibe?usuario="+usuario+"&contrasena="+contrasena, true);
        xhr.onreadystatechange = de_form_modificar2;
        xhr.send(null);

}

function de_form_modificar2(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("mensajes_cuenta").innerHTML=xhr.responseText;
    }
}
/////modifica 




function modifica(){
    crearObjeto();
    en_modifica();
   // alert("muestra");
}

function en_modifica(){
    var usuario=document.getElementById("usuario").value;
    var contrasena=document.getElementById("contrasena").value;
    var telefono=document.getElementById("telefono").value;
    var correo_electronico=document.getElementById("correo_electronico").value;
    
    // alert("enviado"+usuario+contrasena+"     "+telefono+correo_electronico);
        xhr.open("GET","Modificar?usuario="+usuario+"&contrasena="+contrasena+"&telefono="+telefono+"&correo_electronico="+correo_electronico, true);
        xhr.onreadystatechange = de_modifica;
        xhr.send(null);

}

function de_modifica(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("mensajes_cuenta").innerHTML=xhr.responseText;
    }
}
