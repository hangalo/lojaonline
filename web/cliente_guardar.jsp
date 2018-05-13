<%-- 
    Document   : produto_guardar
    Created on : 19-mag-2016, 0.45.34
    Author     : praveen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Loja Online - Novo Cliente</title>
        <link href="css/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/estilos.css" rel="stylesheet"/>
        <script src="css/bootstrap-3.3.6/js/bootstrap.min.js"></script>
        <script src="js/jquery-1.12.3.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form role="form" class="form-horizontal" action="clienteControlo?accao=guardar" method="POST">
                <h2 class="titulo_formulario">Novo Cliente</h2>
                   
                <div class="form-group">
                    <label class="col-xs-3 control-label">Nome:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" name="input_nome" placeholder="Nome"/>
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-xs-3 control-label">Sobrenome:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" name="input_sobrenome" placeholder="Sobrenome"/>
                    </div>
                </div>                
               
                        <button type="submit" class="btn btn-primary botao">Guardar</button>                                    
                 
            </form>
            <a href="index.jsp">Home</a>
        </div>
    </body>
</html>
