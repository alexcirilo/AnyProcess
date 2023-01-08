<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="estrutura/header.jsp" %>

<h2>Adicionar Novo Tipo de Processo</h2>
<a href="/AnyProcess/"><button class="btn btn-secondary"><i class="fas fa-home"></i></button></a><br><br>
<form:form method="post" action="salvarTipoProcesso">
    <table >
        <tr>
            <td>Nome: </td>
            <td><form:input path="nome" required="true" /></td>
        </tr>
        <tr>
            <br/>
            <td><input type="submit" value="Salvar" /></td>
        </tr>
    </table>
</form:form>

<%@include file="estrutura/footer.jsp" %>