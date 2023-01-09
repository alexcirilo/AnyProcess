<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../estrutura/header.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <h1 style="text-align:center; padding:2em">AnyProcess</h1>

<h3>Já existe um processo cadastrado com esse número!</h3>
<a href="/AnyProcess/viewProcesso"><button class="btn btn-primary">Voltar</button></a><br><br>
<%@include file="../estrutura/footer.jsp" %>