$('#radioBtn a').on('click', function(){
    var sel = $(this).data('title');
    var tog = $(this).data('toggle');
    $('#'+tog).prop('value', sel);
    
    $('a[data-toggle="'+tog+'"]').not('[data-title="'+sel+'"]').removeClass('active').addClass('notActive');
    $('a[data-toggle="'+tog+'"][data-title="'+sel+'"]').removeClass('notActive').addClass('active');
})





   $(function() {
        $.mask.definitions['~'] = "[+-]";
        
        $("#placa").mask("aaa-9999");
        
        $("#prefixo").mask("99-999");
        
      
        

        $("input").blur(function() {
            $("#info").html("Unmasked value: " + $(this).mask());
        }).dblclick(function() {
            $(this).unmask();
        });
    });
 $(function() {
        $.mask.definitions['~'] = "[+-]";
        
        $("#placa02").mask("aaa-9999");
        
        $("#prefixo02").mask("99-999");
        
      
        

        $("input").blur(function() {
            $("#info").html("Unmasked value: " + $(this).mask());
        }).dblclick(function() {
            $(this).unmask();
        });
    });

    function valida_modelo() {
        var filter_nome = /^([a-zA-Zà-úÀ-Ú]|\s+)+$/;
        if (!filter_nome.test(document.getElementById("modelo").value)) {
            document.getElementById("modelo").value = '';
            document.getElementById("modelo").placeholder = "Nome inválido ";
            document.getElementById("modelo").style.borderColor = "#ff0000";
            document.getElementById("modelo").style.outline = "#ff0000";
            document.getElementById("modelo").focus();
            document.getElementById("modelo").onkeydown = function keydown_nome() {
                document.getElementById("modelo").placeholder = "";
                document.getElementById("modelo").style.borderColor = "#999999";
                document.getElementById("modelo").style.outline = null;
                document.getElementById("modelo").requered;
            }
            return false;
        } else {
           // document.getElementById("modelo").value = '';
           // document.getElementById("modelo").placeholder = "Nome Válido";
        }
        return true;
    }

function valida_vtr() {
        var filter_nome = /^([a-zA-Zà-úÀ-Ú]|\s+)+$/;
        if (!filter_nome.test(document.getElementById("vtr").value)) {
            document.getElementById("vtr").value = '';
            document.getElementById("vtr").placeholder = "Nome inválido ";
            document.getElementById("vtr").style.borderColor = "#ff0000";
            document.getElementById("vtr").style.outline = "#ff0000";
            document.getElementById("vtr").focus();
            document.getElementById("vtr").onkeydown = function keydown_nome() {
                document.getElementById("vtr").placeholder = "";
                document.getElementById("vtr").style.borderColor = "#999999";
                document.getElementById("vtr").style.outline = null;
                document.getElementById("vtr").requered;
            }
            return false;
        } else {

        	alert("Viatura Cadastrada Com Sucesso!");
           // document.getElementById("modelo").value = '';
           // document.getElementById("modelo").placeholder = "Nome Válido";
             location.href="Cadastro-de-Viaturas.html";
        }
        return true;
    }
    
function valida_modelo02() {
        var filter_nome = /^([a-zA-Zà-úÀ-Ú]|\s+)+$/;
        if (!filter_nome.test(document.getElementById("modelo02").value)) {
            document.getElementById("modelo02").value = '';
            document.getElementById("modelo02").placeholder = "Nome inválido ";
            document.getElementById("modelo02").style.borderColor = "#ff0000";
            document.getElementById("modelo02").style.outline = "#ff0000";
            document.getElementById("modelo02").focus();
            document.getElementById("modelo02").onkeydown = function keydown_nome() {
                document.getElementById("modelo02").placeholder = "";
                document.getElementById("modelo02").style.borderColor = "#999999";
                document.getElementById("modelo02").style.outline = null;
                document.getElementById("modelo02").requered;
            }
            return false;
        } else {
           // document.getElementById("modelo").value = '';
           // document.getElementById("modelo").placeholder = "Nome Válido";
        }
        return true;
    }

function valida_vtr02() {
        var filter_nome = /^([a-zA-Zà-úÀ-Ú]|\s+)+$/;
        if (!filter_nome.test(document.getElementById("vtr02").value)) {
            document.getElementById("vtr02").value = '';
            document.getElementById("vtr02").placeholder = "Nome inválido ";
            document.getElementById("vtr02").style.borderColor = "#ff0000";
            document.getElementById("vtr02").style.outline = "#ff0000";
            document.getElementById("vtr02").focus();
            document.getElementById("vtr02").onkeydown = function keydown_nome() {
                document.getElementById("vtr02").placeholder = "";
                document.getElementById("vtr02").style.borderColor = "#999999";
                document.getElementById("vtr02").style.outline = null;
                document.getElementById("vtr02").requered;
            }
            return false;
        } else {

            alert("Viatura Atualizada Com Sucesso!");
           // document.getElementById("modelo").value = '';
           // document.getElementById("modelo").placeholder = "Nome Válido";
             location.href="Cadastro-de-Viaturas.html";
        }
        return true;
    }