var divInicial="inicio";
var xhr;
function DinamicoDiv(divActual){
    document.getElementById(divActual).style.display='block';
    
    if(divInicial != divActual){
        document.getElementById(divInicial).style.display='none';
    }
    divInicial=divActual;
}





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





 


