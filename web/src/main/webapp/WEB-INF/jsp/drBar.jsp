<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
    href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 부트스트랩 드롭다운 스크립트 -->
<script
    src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function() {

        $(".dropdown-menu a").click(function() {

            $(".nav-link dropdown-toggle:first-child").text($(this).text());
            $(".nav-link dropdown-toggle:first-child").val($(this).text());
        });

    });
</script>

<ul class="nav nav-tabs" style="margin-top: 100px">
    <li class="nav-item"><a class="nav-link active" href="#">Cody</a>
    </li>
    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
        data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
        aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">All</a> <a class="dropdown-item"
                href="#">Follower</a>
        </div></li>


    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
        data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
        aria-expanded="false">Gender</a>
        <div class="dropdown-menu">
            <form action="list" method="get">
                <button class="dropdown-item" name="words" value="남자">Guys</button>
                <button class="dropdown-item" name="words" value="여자">Girls</button>

                <a class="dropdown-item" href="#">Guys + Girls</a>
            </form>
        </div></li>

    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
        data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
        aria-expanded="false">Top</a>
        <div class="dropdown-menu">
            <form action="list" method="get">
                <button class="dropdown-item" name="tops" value="90">S(90)</button>
                <button class="dropdown-item" name="tops" value="95">M(95)</button>
                <button class="dropdown-item" name="tops" value="100">L(100)</button>
            </form>
        </div></li>

    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
        data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
        aria-expanded="false">Pants</a>
        <div class="dropdown-menu">
            <form action="list" method="get">
                <button class="dropdown-item" name="pants" value="27">27</button>
                <button class="dropdown-item" name="pants" value="28">28</button>
                <button class="dropdown-item" name="pants" value="29">29</button>
                <button class="dropdown-item" name="pants" value="30">30</button>
                <button class="dropdown-item" name="pants" value="32">32</button>
                <button class="dropdown-item" name="pants" value="34">34</button>
            </form>

        </div></li>

    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
        data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
        aria-expanded="false">Age</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">20</a> <a class="dropdown-item"
                href="#">30</a> <a class="dropdown-item" href="#">40</a> <a
                class="dropdown-item" href="#">50</a>
        </div></li>


    <li class="nav-item"><a class="nav-link disabled" href="form">게시물
            올리기</a></li>
</ul>