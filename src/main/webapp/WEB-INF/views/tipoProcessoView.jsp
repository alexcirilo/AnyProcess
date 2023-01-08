<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="estrutura/header.jsp" %>
<a href="/AnyProcess/"><button class="btn btn-secondary"><i class="fas fa-home"></i></button></a><br><br>
<h2>Tipos de Processo</h2>
<table class="table table-hover table-sm">
    <thead class="table-dark">
        <tr style="text-align:center">
            <th>Id</th>
            <th>Nome</th>
            <th colspan=2>Acoes</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listTipoProcesso}" var="tipo" varStatus="status">
            <tr style="text-align:center">
                <td>${status.index + 1}</td>
                <td>${tipo.nome}</td>
                <td><a href="edit?id=${tipo.id}">Edit</a></td>
                <td><a href="delete?id=${tipo.id}">Delete</a></td>
            </tr>
            </c:forEach>
    </tbody>
</table>
<%@include file="estrutura/footer.jsp" %>