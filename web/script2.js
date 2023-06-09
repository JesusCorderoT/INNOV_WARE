var divinInicial="inicio";
var xhr;
function DinamicoDiv(divActual){
    document.getElementById(divActual).style.display="block";
    if(divinInicial != divActual){
         document.getElementById(divinInicial).style.display="none";
    }
    divinInicial=divActual;
}
function crearObjeto() {
    if (window.ActiveXObject) {
        xhr = new ActiveXObject("Microsoft.XMLHttp");
    } else {
        if ((window.XMLHttpRequest) || (typeof XMLHttpRequest) != undefined) {
            xhr = new XMLHttpRequest();
        } else {
            alert("Su navegador no soporta AJAX");
            return;
        }
    }
}
function FormAgendar(){
    crearObjeto();
    age();
}
function age(){
    xhr.open("GET","AGENDARCITA",true);
    xhr.onreadystatechange=agendar;
    xhr.send(null);    
   
    
}
function agendar(){
    if(xhr.readyState==4){
        document.getElementById("maque").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function MensajeConf(){
    crearObjeto();
    conf();
}
function conf(){
    xhr.open("GET","Confirmacion",true);
    xhr.onreadystatechange=co;
    xhr.send(null);    
   
    
}
function co(){
    if(xhr.readyState==4){
        document.getElementById("mensajeco").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function registrarcita(){
    crearObjeto();
    reg();
}
function reg(){
        var mensaje;
       var nombre=document.getElementById("nombre").value;
       var  apellidos=document.getElementById("apellidos").value;
       var empresa=document.getElementById("empresa").value;
       var asunto=document.getElementById("asunto").value;
       var fecha=document.getElementById("fecha").value;
        var hora=document.getElementById("hora").value;
        if(document.getElementById("si").checked){
            mensaje="si";
        }
        if(document.getElementById("no").checked){
            mensaje="no";
        }
    xhr.open("GET","AgendarCita?nombre="+nombre+"&apellidos="+apellidos+"&empresa="+empresa+"&asunto="+asunto+"&fecha="+fecha+"&hora="+hora+"&me="+mensaje,true);
    xhr.onreadystatechange=registrar;
    xhr.send(null);    
   
    
}
function registrar(){
    if(xhr.readyState==4){
        document.getElementById("respuestaagenda").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function Formcita(){
    crearObjeto();
    clitaForm();
}
function clitaForm(){
    xhr.open("GET","ConsultarCita",true);
    xhr.onreadystatechange=clifor;
    xhr.send(null);    
   
    
}
function clifor(){
    if(xhr.readyState==4){
        document.getElementById("maquet").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function datoscitacli(){
    crearObjeto();
    datoscli();
}
function datoscli(){
    var folio=document.getElementById("folio").value;
    xhr.open("GET","ConsultarcitaDatos?folio="+folio,true);
    xhr.onreadystatechange=datosclis;
    xhr.send(null);    
   
    
}
function datosclis(){
    if(xhr.readyState==4){
        document.getElementById("datosCons").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function FormModificar(){
    crearObjeto();
    citaclimodificar();
}
function citaclimodificar(){
    xhr.open("GET","Modifcarcita",true);
    xhr.onreadystatechange=cliformmod;
    xhr.send(null);    
   
    
}
function cliformmod(){
    if(xhr.readyState==4){
        document.getElementById("maqueta").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function datosmocita(){
    crearObjeto();
    datosmo();
}
function datosmo(){
    var folio=document.getElementById("folio").value;
    xhr.open("GET","ModificarcitaDatos?folio="+folio,true);
    xhr.onreadystatechange=datosmocitas;
    xhr.send(null);    
   
    
}
function datosmocitas(){
    if(xhr.readyState==4){
        document.getElementById("modatos").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function modificarcitasql(){
    crearObjeto();
    mosql();
}
function mosql(){
       var asunto=document.getElementById("asunto").value;
       var fecha=document.getElementById("fecha").value;
        var folio=document.getElementById("folio").value;
    xhr.open("GET","ModificarcitaSQL?asunto="+asunto+"&fecha="+fecha+"&folio="+folio,true);
    xhr.onreadystatechange=mosqls;
    xhr.send(null);    
   
    
}
function mosqls(){
    if(xhr.readyState==4){
        document.getElementById("respmodatos").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function FormCancelar(){
    crearObjeto();
    cancelarcita();
}
function cancelarcita(){
    xhr.open("GET","CancelarCita",true);
    xhr.onreadystatechange=cancecita;
    xhr.send(null);    
   
    
}
function cancecita(){
    if(xhr.readyState==4){
        document.getElementById("maquetado").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function candatosclie(){
    crearObjeto();
    cadi();
}
function cadi(){
    var folio=document.getElementById("folio").value;
    xhr.open("GET","CancelarDatos?folio="+folio,true);
    xhr.onreadystatechange=ca;
    xhr.send(null);    
   
    
}
function ca(){
    if(xhr.readyState==4){
        document.getElementById("candatos").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function cancelarSQL(){
    crearObjeto();
    casql();
}
function casql(){
       var asunto=document.getElementById("asunto").value;
       var fecha=document.getElementById("fecha").value;
        var folio=document.getElementById("folio").value;
    xhr.open("GET","CancelarSQL?asunto="+asunto+"&folio="+folio,true);
    xhr.onreadystatechange=caql;
    xhr.send(null);    
   
    
}
function caql(){
    if(xhr.readyState==4){
        document.getElementById("rescandatos").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function FormFiltros(){
    crearObjeto();
    fil();
}
function fil(){
    xhr.open("GET","Filtros",true);
    xhr.onreadystatechange=filt;
    xhr.send(null);    
   
    
}
function filt(){
    if(xhr.readyState==4){
        document.getElementById("admimaque").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function fltronombre(){
    crearObjeto();
    filnom();
}
function filnom(){
        var nombre=document.getElementById("cliente").value;
    xhr.open("GET","FitrarPorNombre?nombre="+nombre,true);
    xhr.onreadystatechange=non;
    xhr.send(null);    
   
    
}
function non(){
    if(xhr.readyState==4){
        document.getElementById("tabla").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function fltrofecha(){
    crearObjeto();
    filfecha();
}
function filfecha(){
        var fecha=document.getElementById("fecha").value;
    xhr.open("GET","FiltrarFecha?fecha="+fecha,true);
    xhr.onreadystatechange=fec;
    xhr.send(null);    
   
    
}
function fec(){
    if(xhr.readyState==4){
        document.getElementById("tabla").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function fltroNombreE(){
    crearObjeto();
    filnombreE();
}
function filnombreE(){
        var nombreE=document.getElementById("empresa").value;
    xhr.open("GET","FiltrarNombreEmpresa?nombreE="+nombreE,true);
    xhr.onreadystatechange=noe;
    xhr.send(null);    
   
    
}
function noe(){
    if(xhr.readyState==4){
        document.getElementById("tabla").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function ActualizarEstado(){
    crearObjeto();
    actuaEs();
}
function actuaEs(){
        var estado=document.getElementById("estado").value;
         var folio=document.getElementById("folio").value;
    xhr.open("GET","ActualizarEstado?estado="+estado+"&folio="+folio,true);
    xhr.onreadystatechange=ac;
    xhr.send(null);    
   
    
}
function ac(){
    if(xhr.readyState==4){
        document.getElementById("Estado").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function CancelarCitaADmi(){
    crearObjeto();
    cancead();
}
function cancead(){
        var estado=document.getElementById("estado").value;
         var folio=document.getElementById("folio").value;
         var asunto=document.getElementById("asunto1").value;
         var nombre=document.getElementById("nombre").value;
    xhr.open("GET","CancelarCitaAdmin?estado="+estado+"&folio="+folio+"&asunto="+asunto+"&nombre="+nombre,true);
    xhr.onreadystatechange=caad;
    xhr.send(null);    
   
    
}
function caad(){
    if(xhr.readyState==4){
        document.getElementById("RespuestaEstado").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function modificarAD(){
    crearObjeto();
    MOdiAD();
}
function MOdiAD(){
    var folio=document.getElementById("folio").value;
    xhr.open("GET","DatosModificar?folio="+folio,true);
    xhr.onreadystatechange=modad;
    xhr.send(null);    
   
    
}
function modad(){
    if(xhr.readyState==4){
        document.getElementById("Estado").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}
function modificarADSQL(){
    crearObjeto();
    MOdiADSQL();
}
function MOdiADSQL(){
    var folio=document.getElementById("folio").value;
     var hora=document.getElementById("hora").value;
    xhr.open("GET","MoDatosSQL?folio="+folio+"&hora="+hora,true);
    xhr.onreadystatechange=modadSQL;
    xhr.send(null);    
   
    
}
function modadSQL(){
    if(xhr.readyState==4){
        document.getElementById("respmodatosad").innerHTML="<em>"+xhr.responseText+"</em>";
    }
}