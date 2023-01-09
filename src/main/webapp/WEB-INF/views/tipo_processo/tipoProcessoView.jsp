<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../estrutura/header.jsp" %>
<a href="/"><button class="btn btn-secondary"><i class="fas fa-home"><title>Início</title></i></button></a><br><br>
<h2>Tipos de Processo</h2>
<table class="table table-hover" id="resultados">
    <thead class="table-dark">
        <tr style="text-align:center">
            <th>Id</th>
            <th>Nome</th>
            <th>Edit</th>
            <th>Delete< /th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listTipoProcesso}" var="tipo" varStatus="status">
            <tr style="text-align:center">
                <td>${tipo.id}</td>
                <td>${tipo.nome}</td>
                <td><a href="edit?id=${tipo.id}"><button class="btn btn-outline-dark">Edit</button></a></td>
                <td><a href="delete?id=${tipo.id}" onClick=""><button class="btn btn-outline-danger">Delete</button></a></td>
            </tr>
            </c:forEach>
    </tbody>
</table>
<%@include file="../estrutura/footer.jsp" %>