<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../estrutura/header.jsp" %>

<h2>Editar Tipo de Processo</h2>
<a href="/AnyProcess/"><button class="btn btn-secondary"><i class="fas fa-home" alt="Início"><title>Início</title></i></button></a><br><br>
<form:form method="post" action="editarTipoProcesso">
    <table >
        <tr>

            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Nome: </td>
            <td><form:input path="nome" class="form-control" required="true" /></td>
        </tr>
        <tr>
            <br/>
            <td><input type="submit" class="btn btn-success" value="Salvar" /></td>
            <td><input type="submit" class="btn btn-success" value="Salvar" /></td>
        </tr>
    </table>
</form:form>

<%@include file="../estrutura/footer.jsp" %>