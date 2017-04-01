<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>
            Minha Livraria Virtual
        </title>
    </head>
    <body bgcolor="#FFFFFF">
        <center> 
            <hr>
            <br>
            <h1> 
                <img width="50" src="../imagem/livro.gif">
                <font size="+3">Minha Livraria Virtual</font> 
                <img width="50" src="../imagem/livro.gif">
            </h1> 
        </center>
           <br>
            <hr>
               <p><b>Livraria Online</b></p>
               <c:url var="url" value="/livros/catalogo" />
               <p><b><a href="${url}?Add=">Iniciar compras</a></b>
            <br>
            <hr>
      <center><em>Copyright © 2010 Livraria Virtual. </em></center>
   </body>
</html>