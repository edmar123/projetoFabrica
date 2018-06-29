





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

