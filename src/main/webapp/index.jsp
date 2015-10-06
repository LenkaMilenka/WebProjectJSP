<%-- 
    Document   : index
    Created on : 07.09.2015, 10:32:00
    Author     : Korsak L.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Главная страница блога</title>
    </head>
    <body>
        <header>
            <a href="/"><img alt="Логотип" id="top-image" src="#"/></a>
            <div id="user-panel">
                <a href="#"><img alt="Иконка юзера" scr=""/></a>
                <a href="javascript:void(0);">[Панель для юзера]</a>
            </div>
        </header>
        <div id="main">
            <aside class="leftAside">
                <h2>Темы статей</h2>
                <ul>
                    <li><a href="#">Тема 1</a></li>
                    <li><a href="#">Тема 2</a></li>
                    <li><a href="#">Тема 3</a></li>
                    <li><a href="#">Тема 3</a></li>
                    
                </ul>
            </aside>
            <section>
               <c:forEach var = "article" items="${articles}">
               		<article>
               			<h1>${ article.title }</h1>
               			<div class = "text-article">
               				 ${fn:substring(article.text,0,300)} ...
               			</div>
               			<div class = "footter-article">
               				 <span class="read"><a href="article?id=${article.id}">
                                     Читать...</a></span>
                        <span class="date-article">Дата статьи: ${article.date}</span>
               			</div>
               		</article>
               </c:forEach>
            </section>
        </div>
        <footer>
            <div>
                <span>Приложение на  JAVA EE</span>
                <span><a target="_blanc" href="http://onedeveloper.ru/search?w=Java">JavaEE</a></span>
            </div>
        </footer>
    </body>
</html>