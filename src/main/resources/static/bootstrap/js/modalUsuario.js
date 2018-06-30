/**
 * 
 */
$(document).ready(function() {
	$('.table .btn-xs').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(usuario, status) {
			$('.container-fluid #id').val(usuario.id);
			$('.container-fluid #nomeCompleto').val(usuario.nomeCompleto);
			$('.container-fluid #nomeUsuario').val(usuario.nomeUsuario);
			$('.container-fluid #senhaUsuario').val(usuario.senhaUsuario);
			$('.container-fluid #numeroMatricula').val(usuario.numeroMatricula);
			$('.container-fluid #lotacao').val(usuario.lotacao);
			$('.container-fluid #cnh').val(usuario.cnh);
			$('.container-fluid #orgaoEmissor').val(usuario.orgaoEmissor);
			$('.container-fluid #uf').val(usuario.uf);
			$('.container-fluid #validade').val(usuario.validade);
			$('.container-fluid #tipoCnh').val(usuario.tipoCnh);
			$('.container-fluid #email').val(usuario.email);
			$('.container-fluid #tipoUsuario').val(usuario.tipoUsuario);
			$('.container-fluid #ativo').val(usuario.ativo);


			
		});
		$('.modal-body #myModal02').modal();
	});
});