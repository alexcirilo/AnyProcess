<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="estrutura/header.jsp" %>



    <h1 style="text-align:center; padding:2em">AnyProcess</h1>

    <div style="text-align:center;">
        <a href="/AnyProcess/tipoProcesso"><button class="btn btn-secondary">Novo Tipo de Processo</button></a>
        <a href="/AnyProcess/tipoProcessoView"><button class="btn btn-secondary">Visualizar Tipos de Processos</button></a>
        <a href="/AnyProcess/processo"><button class="btn btn-secondary">Novo Processo</button></a>
        <a href="/AnyProcess/viewProcesso"><button class="btn btn-secondary">Visualizar Processos</button></a>
    </div>
<%@include file="estrutura/footer.jsp" %>