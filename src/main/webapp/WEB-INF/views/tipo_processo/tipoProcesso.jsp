<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../estrutura/header.jsp" %>

<h2>Adicionar Novo Tipo de Processo</h2>
<a href="/"><button class="btn btn-secondary"><i class="fas fa-home"></i></button></a><br><br>
<form:form method="post" action="salvarTipoProcesso">
    <table >
        <tr>
            <td>Nome: </td>
            <td><form:input class="form-control" path="nome" required="true" /></td>
        </tr>
        <tr>
            <br/>


        </tr>
    </table>
    <td><input class="btn btn-success" type="submit" value="Salvar" /></td>
    <a href="/"><input class="btn btn-success" type="button" value="Voltar"></a>
</form:form>


<%@include file="../estrutura/footer.jsp" %>