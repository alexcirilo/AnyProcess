<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../estrutura/header.jsp" %>

<h2 style="padding:1em">Editar Processos</h2>
<a href="/AnyProcess/"><button class="btn btn-secondary"><i class="fas fa-home"></i></button></a><br><br>
<form:form method="POST" methodAttribute="command" action="editProcessoSave">
    <table style="text-align:center; margin:auto" >
        <tr>
            <td>Id: </td>
            <td><form:input class="form-control" path="id"/></td>
        </tr>
        <tr>

        <td>Tipo de Processo: </td>
            <div class="form-row align-itens-center">
                <td><div class="col-auto-my-1">

                    <form:select class="custom-select mr-sm-2" path="tipoProcessoId" required="true">

                        <c:forEach items="${listTipoProcesso}" var="tipo">
                            <option value="${tipo.tipoProcesso.id}">${tipo.tipoProcesso.nome}</option>
                        </c:forEach>
                    </form:select>
                </td>
            </div>
        </div>
        </tr>
        <tr>
            <td>Numero : </td>
            <td><form:input class="form-control" path="numero_processo" required="true" /></td>
        </tr>
        <tr>
            <td>Objetivo : </td>
            <td><form:input class="form-control" path="objetivo" required="true" value=""/></td>
        </tr>
        <tr>
             <td>Data de Entrada : </td>
             <td><form:input class="form-control" path="data_entrada" type="date" required="true"/></td>
        </tr>
        <tr>
            <td>Valor do Recurso : </td>
            <td><form:input class="form-control" path="valor_recurso" required="true" /></td>
        </tr>

    </table>
    <tr><br>
        <input class="btn btn-success" type="submit" value="Enviar">
    </tr>
</form:form>


<%@include file="../estrutura/footer.jsp" %>