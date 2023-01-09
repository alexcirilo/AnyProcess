<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../estrutura/header.jsp" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>Processos</h2>
<a href="/"><button class="btn btn-secondary"><i class="fas fa-home"><title>Início</title></i></button></a><br><br>

<form method="get" action="viewProcessoPorNumero">


<hr/>
<h2>Busca de Processos</h2>
   <table align="center">
   <tr>

   </tr>
      <tr align="center">
         <td>Consultar Número do Processo: </td> <td><input class="form-control" type = "text" name = "numero_processo"/></td>
         <td><input type="submit" class="btn btn-info" value="Pesquisar" /></td>
      </tr>
   </table>
   <br>
</form>


<table class="table table-hover" id="resultados">
    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Tipo Processo</th>
            <th>Número</th><th>Objetivo</th>
            <th>Data de Entrada</th>
            <th>Valor do Recurso</th>
            <th>Editar</th>
            <th>Delete</th>
            </tr>
    </thead>
    <tbody>
       <c:forEach var="p" items="${list}">
       <tr>
       <td>${p.id}</td>
       <td>${p.tipoProcesso.nome}</td>
       <td>${p.numero_processo}</td>
       <td>${p.objetivo}</td>
       <td>${p.data_entrada}</td>
       <td>${p.valor_recurso}</td>
       <td><a href="editProcesso?id=${p.id}"><button class="btn btn-outline-dark">Editar</button></a></td>
       <td><a href="deleteProcesso/${p.id}"><button class="btn btn-outline-danger">Deletar</button></a></td>
       </tr>
       </c:forEach>
   </tbody>
   </table>
   <br/>

   <a href="/processo"><button class="btn btn-success">Novo Processo</button></a>
   <a href="/tipoProcesso"><button class="btn btn-primary">Novo Tipo de Processo</button></a>
   <a href="/tipoProcessoView"><button class="btn btn-dark">Visualizar Tipos de Processos</button></a>
   <%@include file="../estrutura/footer.jsp" %>