<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
    href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
    src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>




<title>Fashion community</title>
<link rel='stylesheet'
    href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/form.css'>
</head>

<body>
    <div class='container'>
        <jsp:include page="../header.jsp" />
        <jsp:include page="../drBar.jsp" />
        <div id="main_table">
            <div id="left">
<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" id="mystatus" value="title" type="button" data-toggle="dropdown" aria-expanded="true">
    제목
    <span class="caret"></span>
    </button>
    <ul id="mytype" class="dropdown-menu" role="menu" aria-labelledby="searchType">
        <li role="presentation">
            <a role="menuitem" tabindex="-1" href="#" value="a">A</a>
        </li>
        <li role="presentation">
            <a role="menuitem" tabindex="-1" href="#" value="b">B</a>
        </li>
        <li role="presentation">
            <a role="menuitem" tabindex="-1" href="#" value="c">C</a>
        </li>
    </ul>
</div>
                <c:forEach items="${list}" var="cody">
                    <table class='table table-hover'>

                        <tbody>

                            <c:set var="title"
                                value="${fn:length(cody.title) == 0 ? '(제목이없습니다.)' : cody.title}" />

                            <tr>
                                <td>
                                    <!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
                                    <a data-target="#exampleModalCenter" data-toggle="modal"
                                    href='${cody.co_no},${cody.wtest}' class='btn btn-light btn-sm'
                                    style="vertical-align: middle;"><span
                                        class="d-inline-block text-truncate" style="max-width: 300px;">${cody.title}</span></a>

                                    <div class="modal fade" id="exampleModalCenter" tabindex="-1"
                                        role="dialog" aria-labelledby="exampleModalCenterTitle"
                                        aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered"
                                            role="document" style="margin:30px 0;">
                                            <div class="modal-content" style="width:1200px;">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>


                                                <div class="modal-body"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
                                </td>
                            </tr>

                            <tr>
                                <td colspan="2"><a style="color: black;"
                                    href='${cody.co_no},${cody.wtest}'><span
                                        class="d-inline-block text-truncate" style="max-width: 300px;"><h3>${cody.title}</h3></span></a></td>
                                <td style="color: blue; font-style: italic;">${cody.wtest}
                                    <button class="btn btn-primary btn-sm tag"
                                        data-target="#exampleModalCenter">${cody.wtest}</button>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3"><img class="img-rounded"
                                    src="${contextPath}/download/${cody.co_photo}" width=500
                                    height="500" align="middle"></td>
                            </tr>
                            <tr>
                                <td colspan="2">Top Size: ${cody.top}</td>
                                <td>Pants Size: ${cody.pants}</td>
                                <%-- <td><a href='${board.no}'>${fn:substring(title, 0, 20)} ${(fn:length(board.title) > 20) ? '...' : ''}</a></td> --%>
                            </tr>
                            <tr>
                                <td colspan="3"><p>Like+ ${cody.likedcount}</p></td>
                            </tr>

                        </tbody>
                    </table>
                </c:forEach>
            </div>

            <jsp:include page="../rigBar.jsp" />
        </div>

        <jsp:include page="../footer.jsp" />

    </div>

    <jsp:include page="../jslib.jsp" />
</body>
</html>