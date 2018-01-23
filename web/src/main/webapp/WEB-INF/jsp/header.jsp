<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
	<nav class='navbar navbar-expand-lg navbar-light bg-light'>
		<a class='navbar-brand' href='../index.html'> <img
			src='${contextPath}../images/bitcamp.svg' width='30'
			height='30' class='d-inline-block align-top' alt=''> 비트도서
		</a>

		<c:if test="${empty menuVisible or menuVisible == true}">
			<button class='navbar-toggler' type='button' data-toggle='collapse'
				data-target='#navbarNav' aria-controls='navbarNav'
				aria-expanded='false' aria-label='Toggle navigation'>
				<span class='navbar-toggler-icon'></span>
			</button>
			<div class='collapse navbar-collapse' id='navbarNav'>
				<ul class='navbar-nav mr-auto'>
					<li class='nav-item'><a class='nav-link' href='../book/list'>책 목록</a>
					</li>
				</ul>

			</div>
		</c:if>

	</nav>
</header>