
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



function formulario_reportar(){
    crearObjeto();
    enviar_formulario_reportar();
    //alert("muestra");
}

function enviar_formulario_reportar(){
    
    
  //alert("enviado");
        xhr.open("GET","Formulario_reporte", true);
        xhr.onreadystatechange = detalles_formulario_reportar;
        xhr.send(null);

}

function detalles_formulario_reportar(){
     if(xhr.readyState==4){
         //alert("recibe");
        document.getElementById("funciones_noticia").innerHTML=xhr.responseText;
    }
}

///////////registro

function registrar_report(){
    crearObjeto();
    enviar_registrar_report();
    //alert("muestra");
}

function enviar_registrar_report(){
    var usuario=document.getElementById("usuario").value;
    var descripccion_reporte=document.getElementById("descripccion_reporte").value;
    
    
    var tit=document.getElementById("select");
    var titulo_noticia=tit.options[tit.selectedIndex].value;
    
  // alert("enviado"+usuario+descripccion_reporte+titulo_noticia);
        xhr.open("GET","Registrar_reporte?usuario="+usuario+"&descripccion_reporte="+descripccion_reporte+"&titulo_noticia="+titulo_noticia, true);
        xhr.onreadystatechange = detalles_registrar_report;
        xhr.send(null);

}

function detalles_registrar_report(){
     if(xhr.readyState==4){
         //alert("recibe");
        document.getElementById("validaciones_noticia").innerHTML=xhr.responseText;
    }
}

//////////////////ver reportes***********************

function ver_reportes(){
    crearObjeto();
    enviar_reporte();
    //alert("muestra");
}

function enviar_reporte(){
    
    
  //alert("enviado");
        xhr.open("GET","Ver_reportes", true);
        xhr.onreadystatechange = det_reporte;
        xhr.send(null);

}

function det_reporte(){
     if(xhr.readyState==4){
         //alert("recibe");
        document.getElementById("funciones_noticia").innerHTML=xhr.responseText;
    }
}