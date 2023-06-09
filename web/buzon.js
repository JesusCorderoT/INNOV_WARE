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


function enviar_buz(){
    crearObjeto();
    buz_env();
  //  alert("muestra");
}

function buz_env(){
    var correo=document.getElementById("correo").value;
    var nombre_usuario=document.getElementById("nombre_usuario").value;
    var asunto=document.getElementById("asunto").value;
    

        xhr.open("GET","Enviar_buz?correo="+correo+"&nombre_usuario="+nombre_usuario+"&asunto", true);
           // alert("enviado"+correo+nombre_usuario+asunto);
        xhr.onreadystatechange = det_buz;
        xhr.send(null);

}

function det_buz(){
     if(xhr.readyState==4){
       //  alert("recibe");
        document.getElementById("div_buz").innerHTML=xhr.responseText;
    }
}