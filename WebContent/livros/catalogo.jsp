<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Minha Livraria Virtual</title>
</head>
<body bgcolor="#FFFFFF">
	<center>
		<hr>
		<br>
		<h1>
			<img width="50" src="../imagem/livro.gif"> <font size="+3">Minha Livraria Virtual</font> <img width="50" src="../imagem/livro.gif">
		</h1>
	</center>
	<br>
	<hr>
	<jsp:useBean id="livrariaBean" class="view.LivrariaBean" scope="page">
		<jsp:setProperty name="livrariaBean" property="sistema"
			value="${sistemaLivraria}" />
	</jsp:useBean>

	<c:if test="${!empty param.Add}">
		<c:set var="idL" value="${param.Add}" />
		<jsp:setProperty name="livrariaBean" property="idLivro" value="idL" />
		<c:set var="livroAdicionado" value="${livrariaBean.livro}" />
		<h3>
			<font color="red" size="+2">Você adicionou o livro <em>${livroAdicionado.titulo}</em> ao seu carrinho de compras.</font>
		</h3>
	</c:if>
	
	<c:choose>
		<c:when test="${sessionScope.cart.numeroItens>0}">
			<c:url var="url" value="/livros/mostrarCarrinho">
				<c:param name="limpar" value="0" />
				<c:param name="remover" value="0" />
			</c:url>
			<p>
				<strong> <a href="${sessionScope.cart.numeroItens>0}"/> 
				<c:url var="url" value="/livros/mostrarCarrinho">
					<c:param name="limpar" value="0" />
					<c:param name="remover" value="0" />
				</c:url>
			<p>
				<strong><a href="{url}">Ver carrinho de compras</a> 
				<c:url var="url" value="/livros/comprar" /> 
					<a href="${url}">Finalizar compras</a></strong>
			</p>
		</c:when>
		<c:otherwise>
			Seu carrinho de compras está vazio.
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<h3>Livros disponíveis para compra:</h3>
	<div>
		<table summary="layout">

			<c:forEach var="livro" begin="0" items="${livrariaBean.livros}">
				<tr>
					<c:set var="idLivro" value="${livro.idLivro}" />
					<td bgcolor="#ffffaa">
						<c:url var="url" value="/livros/detalhesLivro">
							<c:param name="idLivro" value="${idLivro}" />
						</c:url> 
						<a href="${url}"> <strong>${livro.titulo} </strong></a>
					</td>
					<td bgcolor="#ffffaa" rowspan=2>
						<strong> ${livro.descricao}"</strong></td>
					<td bgcolor="#ffffaa" rowspan=2>
						<fmt:formatNumber value="${livro.preco}" type="currency" />
					</td>
					<td bgcolor="#ffffaa" rowspan=2>
						<c:url var="url" value="/livros/catalogo">
							<c:param name="Add" value="${idLivro}" />
						</c:url>
						<p>
						<strong><a href="${url}"> Adicionar livro ao carrinho </a></strong>
					</td>
				</tr>

				<tr>
					<td bgcolor="#ffffff"> 
						<em>${livro.autores} </em>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<br>
	<hr>
	<center>
		<em>Copyright © 2010 Livraria Virtual. </em>
	</center>
</body>
</html>