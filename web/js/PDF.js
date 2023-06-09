
//--------------------------------
document.getElementById('export').addEventListener('click',exportPDF);

var specialElementHandlers = {
  // element with id of "bypass" - jQuery style selector
  '.no-export': function(element, renderer) {
    // true = "handled elsewhere, bypass text extraction"
    return true;
  }
};

function exportPDF() {

  var doc = new jsPDF('p', 'pt', 'a4');
  //A4 - 595x842 pts
  //https://www.gnu.org/software/gv/manual/html_node/Paper-Keywords-and-paper-size-in-points.html
  //Html source 
  var source = document.getElementById('no').innerHTML;
  var arti = document.getElementById('txt-total2').textContent;
  var c = document.getElementById('cart-container2').textContent;

  var margins = {
    top: 10,
    bottom: 10,
    left: 10,
    width: 595
  };

  doc.fromHTML(
    source, // HTML string or DOM elem ref.
    margins.left,
    margins.top, {
      'width': margins.width,
      'elementHandlers': specialElementHandlers
    },

    function(dispose) {
                        //alert(c);
        if(arti=="$0.0" || source=="No seleccionaste productos Mensaje de JS Carro2" || c==!c){
        alert("Primero selecciona productos");
        return false;
        }else{
        alert("Generando PDF");
        doc.text('Aqui esta el resumen de tu cotizacion',200,40);
        doc.text('Total de tu cotizacion: '+arti,200,55);
        var a = doc.save('cotizacionProductos.pdf');
        doc.save('PDFS/');
        doc.save('PDFS/a');
    
        }
    }, margins);
}
