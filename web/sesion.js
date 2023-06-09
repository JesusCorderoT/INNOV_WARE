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



function sesion(){
    crearObjeto();
    enviar_sesion();
    alert("muestra");
}

function enviar_sesion(){
    var usuario=document.getElementById("usuario").value;
    var contrasena=document.getElementById("contrasena").value;
    
    alert("enviado"+usuario+contrasena);
        xhr.open("GET","Inicio_sesion?usuario="+usuario+"&contrasena="+contrasena, true);
        xhr.onreadystatechange = detalle_sesion;
        xhr.send(null);

}

function detalle_sesion(){
     if(xhr.readyState==4){
         alert("recibe");
        document.getElementById("formulario_registro_cliente").innerHTML=xhr.responseText;
    }
}

