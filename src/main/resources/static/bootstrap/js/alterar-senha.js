function validaLogin() {
  if(document.getElementById("nome").value == "" ||
    document.getElementById("senha").value == "" ||
    document.getElementById("senhaNova").value == "" ){

    alert("É obrigatório o preenchimento dos campos");
    document.getElementById("nome").autofocus();
    document.getElementById("senha").autofocus();
    document.getElementById("senhaNova").autofocus();
    window.location.href = "tela-login.html";
    return false;
  }
}

$('#nome').on('keypress', function() {
     var regex = new RegExp("[a-zA-Z]");
     var _this = this;
     // Curta pausa para esperar colar para completar
     setTimeout( function(){
         var texto = $(_this).val();
         if(!regex.test(texto))
         {
             $(_this).val(texto.substring(0, (texto.length-1)))
         }
     }, 100);
   }
);
