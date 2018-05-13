<%-- 
    Document   : cliente_lista
    Created on : 19-mag-2016, 1.21.44
    Author     : praveen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lojaonline.modelo.Produto"%>
<%@page import="lojaonline.dao.ProdutoDAO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Loja Online - Listagem dos produtos</title>
        <link href="css/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/estilos.css" rel="stylesheet"/>
        <script src="css/bootstrap-3.3.6/js/bootstrap.min.js"></script>
        <script src="js/jquery-1.12.3.min.js"></script>
    </head>
</head>
<body>
    <div class="container">

        <h2>Lista dos Produtos</h2>
        <%
            ProdutoDAO produtoDAO = new ProdutoDAO();
            List<Produto> produtos = produtoDAO.listaTodos();

        %>
        <table class=" table table-hover">
            <thead>
                <tr>
                     <th>Id</th>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Preço</th>
                </tr>
            </thead>
            <tbody>
                <%for (Produto produto : produtos) {%>
                <tr>
                    <td><%=produto.getIdProduto()%></td>

                    <td><%=produto.getCodigoProduto() %></td>
                    <td><%=produto.getNomeProduto()%></td>
                    <td><%=produto.getPrecoProduto()%></td>
                    <td>Editar</td>
                    <td>Eliminar</td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
</body>
</html>
