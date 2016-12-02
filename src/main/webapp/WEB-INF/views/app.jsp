<%@ page import="com.websystique.springsecurity.model.Ticket" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 16.10.2016
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://code.jquery.com/jquery-1.8.3.js" prefix="jq" %>--%>

<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>--%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-select.css" />" rel="stylesheet">

    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
    <%--<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>--%>
    <script src="<c:url value="/resources/js/bootstrap-select.js" />"></script>
    <script>
        $('.selectpicker').selectpicker({
        });
    </script>

    <title>Application</title>

    <style>
        #user {
            margin-left: 750px;
        }
        #controls {
            margin-left: 780px;
        }
        .filter-option {
            color: white;
        }
        .violationPick {
            width: 350px;
            /*color: white;*/
        }
        select[title]{
            /*color: white;*/
        }
        body{
            padding:50px;
        }
        .btn-group {
            white-space: nowrap;
            width: 250px;
        }
        .btn-group .btn {
            float: none;
            display: inline-block;
        }
        .btn + .dropdown-toggle {
            margin-left: -4px;
        }

        .table-responsive {
            overflow-x: visible !important;
            overflow-y: visible !important;
        }
    </style>
</head>
<body>
    <div class="container">
            <c:url value="/j_spring_security_logout" var="logoutUrl" />

            <!-- csrf for log out-->
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>

            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <div id="user">
                    Здравствуйте, ${pageContext.request.userPrincipal.name} | <a
                        href="javascript:formSubmit()">Выйти</a>
                </div>
            </c:if>
        <ul class="nav nav-tabs" id="myTab" >
            <li class="active">
                <a href="#inputTickets" data-toggle="tab" >Входящие заявки</a>
            </li>
            <li>
                <a href="#handledTickets" data-toggle="tab" >Обработанные заявки</a>
            </li>
            <li>
                <a href="#archivedTickets" data-toggle="tab" >Архив заявок</a>
            </li>
        </ul>
        <div class="tab-content table-responsive">
            <div class="tab-pane active" id="inputTickets">
                <table class="table table-striped table-bordered table-hover" style="">
                    <thead>
                    <tr>
                        <th class="id">ID</th>
                        <th class="">Вид нарушения</th>
                        <th class="">Номерной знак</th>
                        <th class="">Адрес места нарушения</th>
                        <th class="">Дата</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${inputTickets}" var="item">
                        <tr data-toggle="collapse" data-target="#${item.id}" class="accordion-toggle collapsed"
                            aria-expanded="false">

                            <td class="id"><c:out value="${item.id}"/></td>
                            <td class="violation"></td>
                            <td class="lPlate"><c:out value="${item.licensePlate}"/></td>
                            <td class="address"><c:out value="${item.address}"/></td>
                            <td class="date"><c:out value="${item.date}"/></td>
                        </tr>
                        <tr>
                            <td colspan="12" class="hiddenRow">
                                <div class="accordion-body collapse" id="${item.id}" aria-expanded="false" style="height: 0px;">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th class="">Фото №1</th>
                                            <th class="">Фото №2</th>
                                            <th class="">Фото №3</th>
                                            <th class="">Вид нарушения</th>
                                            <th class="">Действия</th>
                                            <th class="">Комментарий</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td class="">...</td>
                                            <td class="">...</td>
                                            <td class="">...</td>
                                            <td class="">
                                                <div class="btn-group">
                                                    <select class="selectpicker violationPick" title="Выберите нарушение" data-style="btn-info">
                                                        <c:forEach var="violation" items="${rusViolations}">
                                                            <option value=""><c:out value="${violation}"></c:out></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="btn-group">
                                                    <select class="selectpicker actionPick" multiple title="Выберите действие" data-style="btn-info">
                                                        <c:forEach var="action" items="${rusActions}">
                                                            <option value=""><c:out value="${action}"></c:out></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </td>
                                            <td class=""></td>

                                        </tr>
                                        </tbody>
                                    </table>

                                    <div class="btn-group" id="controls">
                                        <button type="button" class="btn btn-danger">Action</button>
                                        <button type="button" class="btn btn-danger dropdown-toggle"
                                                data-toggle="dropdown">
                                            <span class="caret"></span>
                                            <span class="sr-only">Toggle Dropdown</span>
                                        </button>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Action</a>
                                            </li>
                                            <li><a href="#">Another action</a>
                                            </li>
                                            <li><a href="#">Something else here</a>
                                            </li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane" id="handledTickets">
                <table class="table table-striped table-bordered table-hover" style="">
                    <thead>
                    <tr>
                        <th class="id">ID</th>
                        <th class="">Вид нарушения</th>
                        <th class="">Номерной знак</th>
                        <th class="">Адрес места нарушения</th>
                        <th class="">Дата</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${handledTickets}" var="item">
                        <tr data-toggle="collapse" data-target="#${item.id}" class="accordion-toggle collapsed"
                            aria-expanded="false">

                            <td class="id"><c:out value="${item.id}"/></td>
                            <td class="violation">...</td>
                            <td class="lPlate"><c:out value="${item.licensePlate}"/></td>
                            <td class="address"><c:out value="${item.address}"/></td>
                            <td class="date"><c:out value="${item.date}"/></td>
                        </tr>
                        <tr>
                            <td colspan="12" class="hiddenRow">
                                <div class="accordian-body collapse" id="${item.id}" aria-expanded="false" style="height: 0px;">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th class="">Фото №1</th>
                                            <th class="">Фото №2</th>
                                            <th class="">Фото №3</th>
                                            <th class="">Вид нарушения</th>
                                            <th class="">Комментарий</th>
                                            <th class="">Действия</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td class="">...</td>
                                            <td class="">...</td>
                                            <td class="">...</td>
                                            <td class="">
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-danger">Action</button>
                                                    <button type="button" class="btn btn-danger dropdown-toggle"
                                                            data-toggle="dropdown"> <span class="caret"></span>
                                                        <span class="sr-only">Toggle Dropdown</span>

                                                    </button>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a href="#">Action</a>
                                                        </li>
                                                        <li><a href="#">Another action</a>
                                                        </li>
                                                        <li><a href="#">Something else here</a>
                                                        </li>
                                                        <li class="divider"></li>
                                                        <li><a href="#">Separated link</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </td>
                                            <td class=""></td>
                                            <td>
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-danger">Action</button>
                                                    <button type="button" class="btn btn-danger dropdown-toggle"
                                                            data-toggle="dropdown">
                                                        <span class="caret"></span>
                                                        <span class="sr-only">Toggle Dropdown</span>
                                                    </button>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a href="#">Action</a>
                                                        </li>
                                                        <li><a href="#">Another action</a>
                                                        </li>
                                                        <li><a href="#">Something else here</a>
                                                        </li>
                                                        <li class="divider"></li>
                                                        <li><a href="#">Separated link</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane" id="archivedTickets">
                <table class="table table-striped table-bordered table-hover" style="">
                    <thead>
                    <tr>
                        <th class="id">ID</th>
                        <th class="">Вид нарушения</th>
                        <th class="">Номерной знак</th>
                        <th class="">Адрес места нарушения</th>
                        <th class="">Дата</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${archivedTickets}" var="item">
                        <tr data-toggle="collapse" data-target="#${item.id}" class="accordion-toggle collapsed"
                            aria-expanded="false">

                            <td class="id"><c:out value="${item.id}"/></td>
                            <td class="violation">...</td>
                            <td class="lPlate"><c:out value="${item.licensePlate}"/></td>
                            <td class="address"><c:out value="${item.address}"/></td>
                            <td class="date"><c:out value="${item.date}"/></td>
                        </tr>
                        <tr>
                            <td colspan="12" class="hiddenRow">
                                <div class="accordian-body collapse" id="${item.id}" aria-expanded="false" style="height: 0px;">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th class="">Фото №1</th>
                                            <th class="">Фото №2</th>
                                            <th class="">Фото №3</th>
                                            <th class="">Вид нарушения</th>
                                            <th class="">Комментарий</th>
                                            <th class="">Действия</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td class="">...</td>
                                            <td class="">...</td>
                                            <td class="">...</td>
                                            <td class="">
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-danger">Action</button>
                                                    <button type="button" class="btn btn-danger dropdown-toggle"
                                                            data-toggle="dropdown"> <span class="caret"></span>
                                                        <span class="sr-only">Toggle Dropdown</span>

                                                    </button>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a href="#">Action</a>
                                                        </li>
                                                        <li><a href="#">Another action</a>
                                                        </li>
                                                        <li><a href="#">Something else here</a>
                                                        </li>
                                                        <li class="divider"></li>
                                                        <li><a href="#">Separated link</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </td>
                                            <td class=""></td>
                                            <td>
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-danger">Action</button>
                                                    <button type="button" class="btn btn-danger dropdown-toggle"
                                                            data-toggle="dropdown">
                                                        <span class="caret"></span>
                                                        <span class="sr-only">Toggle Dropdown</span>
                                                    </button>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a href="#">Action</a>
                                                        </li>
                                                        <li><a href="#">Another action</a>
                                                        </li>
                                                        <li><a href="#">Something else here</a>
                                                        </li>
                                                        <li class="divider"></li>
                                                        <li><a href="#">Separated link</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
